package com.api.prototype.Exception;

public class UserNotFoundException extends CustomException {


    public UserNotFoundException(String message) {
        super(message);
    }

    @Override
    public int statusCode() {
        return 404;
    }
}
