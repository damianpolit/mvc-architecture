package com.wsb.mvcarchitecture.config;

import com.wsb.mvcarchitecture.entity.CarDatabaseEntity;
import com.wsb.mvcarchitecture.repository.ParkingRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class DataLoader implements ApplicationRunner {
    private final ParkingRepository carRepository;

    public DataLoader(ParkingRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        carRepository.save(new CarDatabaseEntity(null, "Ford Focus", "SZ12345", 1000L, LocalDateTime.now()));
    }
}
