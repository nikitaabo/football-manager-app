package com.example.football_manager.controller;

import com.example.football_manager.dto.TeamRequestDto;
import com.example.football_manager.dto.TeamResponseDto;
import com.example.football_manager.service.TeamService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Teams management", description = "Endpoints for managing teams ")
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/teams")
public class TeamController {
    private final TeamService teamService;

    @GetMapping
    @Operation(summary = "Get teams", description = "Get all teams from the DB.")
    public List<TeamResponseDto> getAllTeams() {
        return teamService.getAllTeams();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a team", description = "Get a team by id")
    public TeamResponseDto getTeamById(@PathVariable @Positive Long id) {
        return teamService.findById(id);
    }

    @PostMapping
    @Operation(summary = "Create a team", description = "Create a new team.")
    public TeamResponseDto createTeam( @RequestBody @Valid TeamRequestDto team) {
        return teamService.createTeam(team);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a team", description = "Update information of a team.")
    public TeamResponseDto updateTeam( @PathVariable @Positive Long id,
                                      @RequestBody @Valid TeamRequestDto team) {
        return teamService.updateTeam(id, team);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a team", description = "Delete a team by id")
    public void deleteTeam(@PathVariable @Positive Long id) {
        teamService.deleteById(id);
    }
}
