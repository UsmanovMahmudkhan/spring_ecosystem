package com.mahmudkhon.Spring_Data_Transaction.Exception;

public class NotFoundBookException extends RuntimeException {
    public NotFoundBookException(String message) {
        super(message);
    }
}
