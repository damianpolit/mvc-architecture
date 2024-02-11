package com.wsb.mvcarchitecture.service;

import com.wsb.mvcarchitecture.model.Car;
import com.wsb.mvcarchitecture.model.CarId;

import java.util.List;

public interface ParkingService {

    void addCar(Car car);

    void deleteCar(CarId id);

    List<Car> getCars();
}
