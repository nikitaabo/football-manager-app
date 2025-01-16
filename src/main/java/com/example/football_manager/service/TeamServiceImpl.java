package com.example.football_manager.service;

import com.example.football_manager.dto.TeamRequestDto;
import com.example.football_manager.dto.TeamResponseDto;
import com.example.football_manager.exception.EntityNotFoundException;
import com.example.football_manager.mapper.TeamMapper;
import com.example.football_manager.model.Team;
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
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    @Override
    @Transactional(readOnly = true)
    public List<TeamResponseDto> getAllTeams() {
        return teamRepository.findAll().stream()
                .map(teamMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public TeamResponseDto createTeam(TeamRequestDto team) {
        Team savedTeam = teamRepository.save(teamMapper.toModel(team));
        log.info("Team with id {} was created", savedTeam.getId());
        return teamMapper.toDto(savedTeam);
    }

    @Override
    @Transactional
    public TeamResponseDto updateTeam(Long id, TeamRequestDto updatedTeam) {
        Team team = teamRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("There's no team with id: " + id));
        teamMapper.updateTeam(updatedTeam, team);
        log.info("Team with id {} is updated.", id);
        return teamMapper.toDto(teamRepository.save(team));
    }

    @Override
    @Transactional(readOnly = true)
    public TeamResponseDto findById(Long id) {
        Team team = teamRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't find team by id: " + id));
        return teamMapper.toDto(team);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Team team = teamRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't find team by id: " + id));
        teamRepository.deleteById(id);
        log.info("Team with id {} was deleted.", id);
    }
}
