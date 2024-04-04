package com.api.prototype.Exception;

import com.api.prototype.response.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    protected ErrorResponse handleMethodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        ErrorResponse errorResponse = new ErrorResponse();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        errorResponse.setCreatetime(dateFormat.format(new Date()));
        errorResponse.setReason(request.getServletPath());
        errorResponse.setStatus(String.valueOf(ex.getStatusCode()));
        for (FieldError field : fieldErrors) {
            errorResponse.addErrors(field.getDefaultMessage());
        }

        return errorResponse;
    }

    @ExceptionHandler(CustomException.class)
    @ResponseBody
    protected ErrorResponse handleUnAuthorizeException(HttpServletRequest request, Unauthorized ex) {
        ErrorResponse errorResponse = new ErrorResponse();

        errorResponse.setStatus(String.valueOf(ex.statusCode()));
        errorResponse.setReason(ex.getMessage());
        errorResponse.setCreatetime(String.valueOf(new Date()));

        return errorResponse;
    }

    @ExceptionHandler(BoardNotFoundException.class)
    @ResponseBody
    protected ErrorResponse handleBoardNotFoundException(HttpServletRequest request, BoardNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse();

        errorResponse.setStatus(String.valueOf(ex.statusCode()));
        errorResponse.setReason(ex.getMessage());
        errorResponse.setCreatetime(String.valueOf(new Date()));

        return errorResponse;
    }
}