package com.example.votacao.application.exception;

import com.example.votacao.application.response.ExceptionResponse;
import com.example.votacao.domain.exception.PautaNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ControllerAdvice(basePackages = "com.example.votacao.application.rest")
public class VotacaoControllerAdvice {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(PautaNotFoundException.class)
    public ExceptionResponse handlePautaNotFoundException(PautaNotFoundException ex) {
        return new ExceptionResponse(HttpStatus.NOT_FOUND,"Pauta inexistente!", LocalDateTime.now());
    }
}
