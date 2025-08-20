package com.jean.portacademia.api.exceptionHandler;

import com.jean.portacademia.domain.exception.EntidadeEmUsoException;
import com.jean.portacademia.domain.exception.EntidadeNaoEncontradaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.OffsetDateTime;

@RestControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler(EntidadeNaoEncontradaException.class)
    public ResponseEntity<Problema> entidadeNaoEncontradaException(EntidadeNaoEncontradaException e){
        var status = HttpStatus.NOT_FOUND;
        var problema = Problema.builder()
                .status(status.value())
                .menssagem(e.getLocalizedMessage())
                .timestamp(OffsetDateTime.now())
                .build();
        return ResponseEntity.status(status).body(problema);
    }

    @ExceptionHandler(EntidadeEmUsoException.class)
    public ResponseEntity<Problema> entidadeEmUsoException(EntidadeEmUsoException e){
        var status = HttpStatus.CONFLICT;
        var problema = Problema.builder()
                .status(status.value())
                .menssagem(e.getLocalizedMessage())
                .timestamp(OffsetDateTime.now())
                .build();
        return ResponseEntity.status(status).body(problema);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Problema> methodArgumentNotValidException(MethodArgumentNotValidException e){
        var status = HttpStatus.BAD_REQUEST;

        var fields = e.getFieldErrors().stream()
                .map(fieldError -> Problema.Erro.builder()
                        .nome(fieldError.getField())
                        .menssagem(fieldError.getDefaultMessage())
                        .build())
                .toList();

        var problema = Problema.builder()
                .status(status.value())
                .menssagem(status.getReasonPhrase())
                .timestamp(OffsetDateTime.now())
                .erros(fields)
                .build();
        return ResponseEntity.status(status).body(problema);
    }


}
