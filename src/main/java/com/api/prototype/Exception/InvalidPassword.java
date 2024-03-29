package com.api.prototype.Exception;


public class InvalidPassword extends CustomException {

    private static final String MESSAGE = "There is Invalid Password";

    public InvalidPassword(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public int statusCode() {
        return 400;
    }

}
