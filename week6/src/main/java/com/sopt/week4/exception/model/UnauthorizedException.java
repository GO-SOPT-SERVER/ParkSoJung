package com.sopt.week4.exception.model;

import com.sopt.week4.exception.Error;
import lombok.Getter;

@Getter
public class UnauthorizedException extends SoptException {
    public UnauthorizedException(Error error, String message) {
        super(error, message);
    }
}
