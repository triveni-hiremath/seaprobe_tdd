package com.example.seaprobe_tdd.exception;

public class ProbeValidationException extends RuntimeException{

    public ProbeValidationException(String errorMessage){
        super(errorMessage);
    }
}
