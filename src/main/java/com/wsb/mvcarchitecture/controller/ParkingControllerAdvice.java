package com.wsb.mvcarchitecture.controller;

import com.wsb.mvcarchitecture.exception.CarNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ParkingControllerAdvice {

    @ExceptionHandler(CarNotFoundException.class)
    public ResponseEntity handleCarNotFoundException(CarNotFoundException e) {
        return ResponseEntity.status(404).body(e.getMessage());
    }
}
