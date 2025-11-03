package com.example.seaprobe_tdd.dto;

import lombok.Data;

@Data
public class ErrorResponse {
    String status;
    String message;
}
