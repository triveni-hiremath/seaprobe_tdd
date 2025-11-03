package com.example.seaprobe_tdd.exception;
import com.example.seaprobe_tdd.dto.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProbeValidationException.class)
    public ResponseEntity<ErrorResponse> handleInvalidProbe(Exception ex) {
        ErrorResponse error = new ErrorResponse();
                error.setMessage(ex.getMessage());
                error.setStatus("400");
        return ResponseEntity.badRequest().body(error);
    }
}