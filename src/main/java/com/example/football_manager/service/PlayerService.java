package com.example.football_manager.service;

import com.example.football_manager.dto.PlayerRequestDto;
import com.example.football_manager.dto.PlayerResponseDto;

import java.util.List;

public interface PlayerService {
    List<PlayerResponseDto> getAllPlayers();

    PlayerResponseDto findById(Long id);

    PlayerResponseDto createPlayer(PlayerRequestDto player);

    PlayerResponseDto updatePlayer(Long id, PlayerRequestDto player);

    void deleteById(Long id);
}
