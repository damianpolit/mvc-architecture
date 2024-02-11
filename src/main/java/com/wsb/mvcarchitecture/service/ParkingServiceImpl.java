package com.wsb.mvcarchitecture.service;

import com.wsb.mvcarchitecture.controller.ParkingMapper;
import com.wsb.mvcarchitecture.exception.CarNotFoundException;
import com.wsb.mvcarchitecture.model.Car;
import com.wsb.mvcarchitecture.model.CarId;
import com.wsb.mvcarchitecture.repository.ParkingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class ParkingServiceImpl implements ParkingService {

    private final ParkingMapper parkingMapper;
    private final ParkingRepository parkingRepository;

    public ParkingServiceImpl(ParkingMapper parkingMapper, ParkingRepository parkingRepository) {
        this.parkingMapper = parkingMapper;
        this.parkingRepository = parkingRepository;
    }


    @Override
    public void addCar(Car car) {
        parkingRepository.save(parkingMapper.carToCarDatabaseEntity(car));
    }

    @Override
    public void deleteCar(CarId carId) {
        parkingRepository.findById(carId.id())
                .map(car -> {
                    parkingRepository.delete(car);
                    return car;
                })
                .orElseThrow(CarNotFoundException::new);
    }

    @Override
    public List<Car> getCars() {
        return StreamSupport.stream(parkingRepository.findAll().spliterator(), false)
                .map(parkingDatabaseEntity -> new Car(new CarId(parkingDatabaseEntity.getId()),
                        parkingDatabaseEntity.getBrand(), parkingDatabaseEntity.getPlate(),
                        parkingDatabaseEntity.getWeight(), parkingDatabaseEntity.getEntryTime()))
                .toList();
    }
}
