package com.api.prototype.Exception;

public class LoginInvalidException extends CustomException {


    private static final String MESSAGE = "Email or Password is incorrect";

    public LoginInvalidException() {
        super(MESSAGE);
    }


    @Override
    public int statusCode() {
        return 4000;
    }
}
