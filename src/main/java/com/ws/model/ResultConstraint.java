package com.ws.model;

import lombok.Getter;

import javax.validation.ConstraintViolation;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class ResultConstraint {

    private String message;
    private Boolean success;


    ResultConstraint(String msg){
        this.message = msg;
        this.success = true;
    }


    public ResultConstraint(Set<? extends ConstraintViolation<?>> violations){

        this.success = false;
        this.message = violations.stream().map(c -> c.getMessage()).collect(Collectors.joining(" , "));

    }

}
