package com.example.football_manager.service;

import com.example.football_manager.dto.PlayerRequestDto;
import com.example.football_manager.dto.PlayerResponseDto;
import com.example.football_manager.exception.EntityNotFoundException;
import com.example.football_manager.mapper.PlayerMapper;
import com.example.football_manager.model.Player;
import com.example.football_manager.model.Team;
import com.example.football_manager.repository.PlayerRepository;
import com.example.football_manager.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlayerServiceImpl implements PlayerService{
    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;
    private final PlayerMapper playerMapper;
    @Override
    @Transactional(readOnly = true)
    public List<PlayerResponseDto> getAllPlayers() {
        return playerRepository.findAll().stream()
                .map(playerMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public PlayerResponseDto findById(Long id) {
        Player player = playerRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't find player by id: " + id));
        return playerMapper.toDto(player);
    }

    @Override
    @Transactional
    public PlayerResponseDto createPlayer(PlayerRequestDto player) {
        Team team = teamRepository.findById(player.getTeamId()).orElseThrow(
                () -> new EntityNotFoundException("There's no team with id: " + player.getTeamId()));
        Player savedPlayer = playerRepository.save(playerMapper.toModel(player));
        log.info("Player with id {} was created", savedPlayer.getId());
        return playerMapper.toDto(savedPlayer);
    }

    @Override
    @Transactional
    public PlayerResponseDto updatePlayer(Long id, PlayerRequestDto updatedPlayer) {
        Team team = teamRepository.findById(updatedPlayer.getTeamId()).orElseThrow(
                () -> new EntityNotFoundException("There's no team with id: " + updatedPlayer.getTeamId()));
        Player player = playerRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("There's no player with id: " + id));
        playerMapper.updatePlayer(updatedPlayer, player);
        player.setTeam(team);
        log.info("Player with id {} is updated.", id);
        return playerMapper.toDto(playerRepository.save(player));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Player player = playerRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't find player by id: " + id));
        playerRepository.deleteById(id);
        log.info("Player with id {} was deleted.", id);
    }
}
