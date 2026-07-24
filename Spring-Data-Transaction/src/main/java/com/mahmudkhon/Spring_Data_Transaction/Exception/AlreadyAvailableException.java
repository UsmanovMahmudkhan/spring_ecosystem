package com.mahmudkhon.Spring_Data_Transaction.Exception;

public class AlreadyAvailableException extends RuntimeException {
    public AlreadyAvailableException(String message) {
        super(message);
    }
}
