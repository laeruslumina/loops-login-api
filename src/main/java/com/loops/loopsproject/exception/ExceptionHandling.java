package com.loops.loopsproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ExceptionHandling extends Exception{
    public ExceptionHandling(String message){
        super(message);
    }
}
