package com.example.football_manager.service;

import com.example.football_manager.dto.TeamRequestDto;
import com.example.football_manager.dto.TeamResponseDto;
import java.util.List;

public interface TeamService {
    List<TeamResponseDto> getAllTeams();

    TeamResponseDto createTeam(TeamRequestDto team);

    TeamResponseDto updateTeam(Long id, TeamRequestDto team);

    TeamResponseDto findById(Long id);

    void deleteById(Long id);
}
