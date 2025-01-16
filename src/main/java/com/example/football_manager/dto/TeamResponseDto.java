package com.example.football_manager.dto;

import lombok.Data;

@Data
public class TeamResponseDto {
    private Long id;
    private String name;
    private double accountBalance;
    private double commissionRate;
}
