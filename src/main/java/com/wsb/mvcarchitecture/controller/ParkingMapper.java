package com.wsb.mvcarchitecture.controller;

import com.wsb.mvcarchitecture.entity.CarDatabaseEntity;
import com.wsb.mvcarchitecture.model.Car;
import com.wsb.mvcarchitecture.model.CarId;
import com.wsb.mvcarchitecture.model.CarRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class ParkingMapper {

    public Car carDatabaseEntityToCar(CarDatabaseEntity carDatabaseEntity) {
        return new Car(new CarId(carDatabaseEntity.getId()), carDatabaseEntity.getBrand(),
                carDatabaseEntity.getPlate(), carDatabaseEntity.getWeight(),
                carDatabaseEntity.getEntryTime());
    }

    public Car carRequestToCar(CarRequest carRequest) {
        return new Car(null, carRequest.brand(), carRequest.plate(), carRequest.weight(), LocalDateTime.now());
    }

    public CarDatabaseEntity carToCarDatabaseEntity(Car car) {
        return new CarDatabaseEntity(Optional.ofNullable(car.carId()).map(CarId::id).orElse(null),
                car.brand(), car.plate(), car.weight(), car.entryTime());
    }
}
