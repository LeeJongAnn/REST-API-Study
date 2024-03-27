package com.api.prototype.response;


import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.lang.String;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ErrorResponse {


    private HttpStatusCode status;
    private String reason;
    private String createtime;
    private List<String> errors = new ArrayList<>();

    public ErrorResponse(HttpStatusCode status, String reason, String createtime, List<String> errors) {
        this.status = status;
        this.reason = reason;
        this.createtime = createtime;
        this.errors = errors;
    }

    public ErrorResponse() {
    }

    public void addErrors(String error) {
        this.errors.add(error);
    }


}
