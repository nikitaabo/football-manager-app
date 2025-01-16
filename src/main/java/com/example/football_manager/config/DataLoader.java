package com.example.football_manager.config;

import com.example.football_manager.model.Player;
import com.example.football_manager.model.Team;
import com.example.football_manager.repository.PlayerRepository;
import com.example.football_manager.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;

    @Override
    public void run(String... args) {
        Team team1 = new Team();
        team1.setName("Real Madrid");
        team1.setCommissionRate(5);
        team1.setAccountBalance(1000000);
        Team team2 = new Team();
        team2.setName("Manchester City");
        team2.setCommissionRate(3);
        team2.setAccountBalance(800000);
        teamRepository.save(team1);
        teamRepository.save(team2);

        Player player1 = new Player();
        player1.setName("Kylian Mbappe");
        player1.setAge(25);
        player1.setTeam(team1);
        player1.setMonthsOfExperience(60);
        Player player2 = new Player();
        player2.setName("Cristiano Ronaldo");
        player2.setAge(30);
        player2.setTeam(team2);
        player2.setMonthsOfExperience(120);
        playerRepository.save(player1);
        playerRepository.save(player2);
    }
}
