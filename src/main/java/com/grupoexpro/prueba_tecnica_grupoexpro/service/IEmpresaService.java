package com.grupoexpro.prueba_tecnica_grupoexpro.service;

import com.grupoexpro.prueba_tecnica_grupoexpro.model.Empresa;
import com.grupoexpro.prueba_tecnica_grupoexpro.util.Exception.Errors.ErrorResponseException;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface IEmpresaService {
    List<Empresa> findByLastRegister();
    Empresa registroEmpresa(Map<String, String> values) throws ErrorResponseException;

    void hasEmpresaRegistrada(Map<String, String> values) throws ErrorResponseException;
}
