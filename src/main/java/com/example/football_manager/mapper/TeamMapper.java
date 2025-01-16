package com.example.football_manager.mapper;

import com.example.football_manager.config.MapperConfig;
import com.example.football_manager.dto.TeamRequestDto;
import com.example.football_manager.dto.TeamResponseDto;
import com.example.football_manager.model.Team;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class)
public interface TeamMapper {
    Team toModel(TeamRequestDto teamRequestDto);
    TeamResponseDto toDto(Team team);
    void updateTeam(TeamRequestDto updatedTeam, @MappingTarget Team team);

}
