package com.example.football_manager.controller;

import com.example.football_manager.dto.PlayerRequestDto;
import com.example.football_manager.dto.PlayerResponseDto;
import com.example.football_manager.dto.TeamRequestDto;
import com.example.football_manager.dto.TeamResponseDto;
import com.example.football_manager.service.PlayerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Players management", description = "Endpoints for managing players ")
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/players")
public class PlayerController {
    private final PlayerService playerService;

    @GetMapping
    @Operation(summary = "Get players", description = "Get all players from the DB.")
    public List<PlayerResponseDto> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a player", description = "Get a player by id")
    public PlayerResponseDto getPlayerById(@PathVariable @Positive Long id) {
        return playerService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Create a player", description = "Create a new player.")
    public PlayerResponseDto createPlayer( @RequestBody @Valid PlayerRequestDto player) {
        return playerService.createPlayer(player);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a player", description = "Update player's information.")
    public PlayerResponseDto updatePlayer( @PathVariable @Positive Long id,
                                       @RequestBody @Valid PlayerRequestDto player) {
        return playerService.updatePlayer(id, player);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a player", description = "Delete a player by id")
    public void deletePlayer(@PathVariable @Positive Long id) {
        playerService.deleteById(id);
    }
}
