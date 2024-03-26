package com.api.prototype.Exception;

import com.api.prototype.service.Token;

public class InvalidPassword extends Exception {


    public InvalidPassword(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidPassword(String message) {
        super(message);
    }
}
