package com.wsb.mvcarchitecture.repository;

import com.wsb.mvcarchitecture.entity.CarDatabaseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ParkingRepository extends CrudRepository<CarDatabaseEntity, UUID> {
}
