package com.grupoexpro.prueba_tecnica_grupoexpro.service;

import com.grupoexpro.prueba_tecnica_grupoexpro.util.Exception.Errors.ErrorResponseException;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface ILoginService {
    ResponseEntity<String> islogin(Map<String, String> request) throws ErrorResponseException;
}
