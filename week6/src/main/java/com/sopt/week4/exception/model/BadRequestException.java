package com.sopt.week4.exception.model;

import com.sopt.week4.exception.Error;

public class BadRequestException extends SoptException {
    public BadRequestException(Error error, String message) {
        super(error, message);
    }
}
