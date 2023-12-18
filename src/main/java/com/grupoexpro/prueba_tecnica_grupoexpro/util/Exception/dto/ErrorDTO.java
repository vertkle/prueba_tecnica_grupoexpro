package com.grupoexpro.prueba_tecnica_grupoexpro.util.Exception.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ErrorDTO {
    private HttpStatus httpStatus;
    private String message;
    private int code;
}
