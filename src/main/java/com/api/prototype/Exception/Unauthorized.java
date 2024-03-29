package com.api.prototype.Exception;

public class Unauthorized extends CustomException{

    private static final String MESSAGE = "Need authorization";

    public Unauthorized(String message, Throwable cause) {
        super(MESSAGE, cause);
    }

    public Unauthorized() {
        super(MESSAGE);
    }


    @Override
    public int statusCode() {
        return 401;
    }
}
