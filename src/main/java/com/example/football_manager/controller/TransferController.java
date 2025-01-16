package com.example.football_manager.controller;

import com.example.football_manager.service.TransferService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Transfers management", description = "Endpoints for managing transfers ")
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/transfers")
public class TransferController {
    private final TransferService transferService;

    @PostMapping
    public ResponseEntity<String> transferPlayer(
            @RequestParam Long playerId,
            @RequestParam Long toTeamId) {
        try {
            transferService.transferPlayer(playerId, toTeamId);
            return ResponseEntity.ok("Player transferred successfully.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
