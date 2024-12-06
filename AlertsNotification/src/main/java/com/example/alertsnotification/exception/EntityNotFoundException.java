package com.example.alertsnotification.exception;

//Exception to be displayed when no result is present
public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message) {
        super(message);
    }
}
