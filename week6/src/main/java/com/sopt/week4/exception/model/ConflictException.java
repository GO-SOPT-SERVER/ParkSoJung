package com.sopt.week4.exception.model;

import com.sopt.week4.exception.Error;

public class ConflictException extends SoptException {
    public ConflictException(Error error, String message) {
        super(error, message);
    }
}
