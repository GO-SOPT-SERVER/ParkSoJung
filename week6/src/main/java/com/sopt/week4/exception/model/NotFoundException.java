package com.sopt.week4.exception.model;

import com.sopt.week4.exception.Error;

public class NotFoundException extends SoptException {
    public NotFoundException(Error error, String message) {
        super(error, message);
    }
}
