package com.example.football_manager.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Table(name = "players")
@Getter
@Setter
@SQLDelete(sql = "UPDATE players SET is_deleted = TRUE WHERE id = ?")
@SQLRestriction(value = "is_deleted = FALSE")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private int monthsOfExperience;
    @ManyToOne
    private Team team;
    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted = false;

}
