package com.wsb.mvcarchitecture.controller;

import com.wsb.mvcarchitecture.model.Car;
import com.wsb.mvcarchitecture.model.CarId;
import com.wsb.mvcarchitecture.model.CarRequest;
import com.wsb.mvcarchitecture.service.ParkingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = {})
public class ParkingController {

    private final ParkingService parkingService;
    private final ParkingMapper parkingMapper;

    public ParkingController(ParkingService parkingService, ParkingMapper parkingMapper) {
        this.parkingService = parkingService;
        this.parkingMapper = parkingMapper;
    }

    @GetMapping("/parking")
    public ResponseEntity<List<Car>> getCars() {
        return ResponseEntity.ok(parkingService.getCars());
    }

    @PostMapping("/parking")
    public ResponseEntity<Void> addCar(@RequestBody CarRequest carRequest) {
        var car = parkingMapper.carRequestToCar(carRequest);
        parkingService.addCar(car);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/parking/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable("id") UUID carId) {
        parkingService.deleteCar(new CarId(carId));
        return ResponseEntity.noContent().build();
    }
}
