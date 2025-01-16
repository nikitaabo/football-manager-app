package com.example.football_manager.mapper;

import com.example.football_manager.config.MapperConfig;
import com.example.football_manager.dto.PlayerRequestDto;
import com.example.football_manager.dto.PlayerResponseDto;
import com.example.football_manager.model.Player;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class)
public interface PlayerMapper {
    @Mapping(target = "team.id", source = "teamId")
    Player toModel(PlayerRequestDto playerRequestDto);

    @Mapping(target = "teamId", source = "team.id")
    PlayerResponseDto toDto(Player player);


    void updatePlayer(PlayerRequestDto updatedPlayer, @MappingTarget Player player);
}
