package com.tms.ECommerce.exception;

import com.tms.ECommerce.dto.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CategoryAlreadyExistException.class)
    public ResponseEntity<ExceptionResponseDTO> categoryExistException(CategoryAlreadyExistException ex, WebRequest request){
        ExceptionResponseDTO exceptiondto = new ExceptionResponseDTO(request.getDescription(false),HttpStatus.CONFLICT,ex.getMessage(), LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exceptiondto);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ExceptionResponseDTO> categoryNotFoundException(CategoryNotFoundException ex, WebRequest request){
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(request.getDescription(false),HttpStatus.NOT_FOUND,ex.getMessage(),LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponseDTO);
    }

}
