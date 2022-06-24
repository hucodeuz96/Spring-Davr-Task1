package com.example.springdavrtask.hucode.excaption;

public class CustomSQLException extends RuntimeException {

    public CustomSQLException(String message) {
        super(message);
    }

}
