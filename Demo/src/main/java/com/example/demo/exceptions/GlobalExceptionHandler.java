package com.example.demo.exceptions;

import com.example.demo.model.Funcionario;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handlerValidationExceptions(MethodArgumentNotValidException m, WebRequest wr) {
        Map<String, String> erros = new HashMap<>();
        m.getBindingResult().getAllErrors().forEach((error) -> {
            String nomeDoCampo = ((org.springframework.validation.FieldError) error).getField();
            String mensagemDeErro = error.getDefaultMessage();
            erros.put(nomeDoCampo, mensagemDeErro);
        });

        return new ResponseEntity<>(erros, HttpStatus.BAD_REQUEST);
    }
}
