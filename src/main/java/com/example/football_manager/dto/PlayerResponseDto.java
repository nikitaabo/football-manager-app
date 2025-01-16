package com.example.football_manager.dto;

import lombok.Data;

@Data
public class PlayerResponseDto {
    private Long id;
    private String name;
    private int age;
    private int monthsOfExperience;
    private Long teamId;
}
