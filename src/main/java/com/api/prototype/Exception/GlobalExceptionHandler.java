package com.api.prototype.Exception;

import com.api.prototype.response.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

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
        errorResponse.setStatus(ex.getStatusCode());
        for (FieldError field : fieldErrors) {
            errorResponse.addErrors(field.getDefaultMessage());
        }

        return errorResponse;
    }

}