package com.example.football_manager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class TeamRequestDto {
    @NotBlank
    private String name;
    @Positive
    private double accountBalance;
    @Positive
    private double commissionRate;
}
