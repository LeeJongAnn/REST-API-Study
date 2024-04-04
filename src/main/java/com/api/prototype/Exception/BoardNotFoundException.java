package com.api.prototype.Exception;

public class BoardNotFoundException extends CustomException {


    private static String message = "Board not found those id";


    public BoardNotFoundException() {
        super(message);

    }



    @Override
    public int statusCode() {
        return 404;
    }
}
