package com.api.prototype.Exception;

public class UserNotFoundException extends CustomException {

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public int statusCode() {
        return 404;
    }
}
