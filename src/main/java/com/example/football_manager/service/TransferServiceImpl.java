package com.example.football_manager.service;

import com.example.football_manager.exception.EntityNotFoundException;
import com.example.football_manager.exception.TransferException;
import com.example.football_manager.model.Player;
import com.example.football_manager.model.Team;
import com.example.football_manager.repository.PlayerRepository;
import com.example.football_manager.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransferServiceImpl implements TransferService {

    private final PlayerRepository playerRepository;

    private final TeamRepository teamRepository;

    @Override
    @Transactional
    public void transferPlayer(Long playerId, Long toTeamId) {
        Player player = playerRepository.findById(playerId).orElseThrow(
                () -> new EntityNotFoundException("Can't find player by id: " + playerId));
        Team fromTeam = player.getTeam();
        Team toTeam = teamRepository.findById(toTeamId).orElseThrow(
                () -> new EntityNotFoundException("To team not found with id: " + toTeamId));
        if (fromTeam.equals(toTeam)) {
            throw new TransferException("Teams haven't to be the same.");
        }
        double transferCost = (player.getMonthsOfExperience() * 100000.0) / player.getAge();
        double commission = fromTeam.getCommissionRate() * transferCost / 100;
        double totalCost = transferCost + commission;

        if (toTeam.getAccountBalance() < totalCost) {
            throw new TransferException("Insufficient funds");
        }

        toTeam.setAccountBalance(toTeam.getAccountBalance() - totalCost);
        fromTeam.setAccountBalance(fromTeam.getAccountBalance() + totalCost);

        player.setTeam(toTeam);
        playerRepository.save(player);
        teamRepository.save(fromTeam);
        teamRepository.save(toTeam);
    }
}
