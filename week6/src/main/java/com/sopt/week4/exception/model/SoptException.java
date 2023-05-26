package com.sopt.week4.exception.model;

import com.sopt.week4.exception.Error;
import lombok.Getter;

@Getter
public class SoptException extends RuntimeException {
    private final Error error;

    public SoptException(Error error, String message) {
        super(message);
        this.error = error;
    }

    public int getHttpStatus() {
        return error.getHttpStatusCode();
    }
}
