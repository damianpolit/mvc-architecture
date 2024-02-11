package com.wsb.mvcarchitecture.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CarDatabaseEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    private UUID id;
    private String brand;
    private String plate;
    private Long weight;
    private LocalDateTime entryTime;

}
