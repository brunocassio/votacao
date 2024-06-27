package com.example.votacao.application.response;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ExceptionResponse(HttpStatus status, String message, LocalDateTime timestamp) {
}
