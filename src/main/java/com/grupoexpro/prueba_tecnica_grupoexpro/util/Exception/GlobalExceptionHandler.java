package com.grupoexpro.prueba_tecnica_grupoexpro.util.Exception;

import com.grupoexpro.prueba_tecnica_grupoexpro.util.Exception.Errors.ErrorResponseException;
import com.grupoexpro.prueba_tecnica_grupoexpro.util.Exception.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = ErrorResponseException.class)
    public ResponseEntity<ErrorDTO> handleCustomException(ErrorResponseException e) {
        ErrorDTO error = ErrorDTO.builder()
                .httpStatus(e.getHttpStatus())
                .message(e.getMessage())
                .code(e.getStatus())
                .build();
        return new ResponseEntity<>(error,e.getHttpStatus());
    }
}
