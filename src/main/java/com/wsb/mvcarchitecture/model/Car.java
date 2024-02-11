package com.wsb.mvcarchitecture.model;

import java.time.LocalDateTime;

public record Car(CarId carId, String brand, String plate, Long weight, LocalDateTime entryTime) {
}
