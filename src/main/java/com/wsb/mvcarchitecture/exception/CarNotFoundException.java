package com.wsb.mvcarchitecture.exception;

public class CarNotFoundException extends RuntimeException {
    private static final String MESSAGE = "Car not found";

    public CarNotFoundException() {
        super(MESSAGE);
    }
}
