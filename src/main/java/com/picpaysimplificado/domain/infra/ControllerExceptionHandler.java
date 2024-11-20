package com.picpaysimplificado.domain.infra;

import com.picpaysimplificado.domain.dtos.ExceptionDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity threatDuplicateEntry(DataIntegrityViolationException expection){
        ExceptionDTO exceptionDTO = new ExceptionDTO("Usuario cadastrado", 400);
        return ResponseEntity.badRequest().body(exceptionDTO);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity threat404(EntityNotFoundException  expection){
               return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity threatGeneralExpection(Exception expection){
        ExceptionDTO exceptionDTO = new ExceptionDTO("Usuario do tipo lojista não está autorizado a realizar a transação", 500);
        return ResponseEntity.internalServerError().body(exceptionDTO);
    }


}
