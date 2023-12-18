package com.grupoexpro.prueba_tecnica_grupoexpro.controller;

import com.grupoexpro.prueba_tecnica_grupoexpro.model.Empresa;
import com.grupoexpro.prueba_tecnica_grupoexpro.service.EmpresaService;
import com.grupoexpro.prueba_tecnica_grupoexpro.util.Exception.Errors.ErrorResponseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/empresa")
public class EmpresaController {
    @Autowired
    private EmpresaService empresaService;

    @PostMapping
    public Empresa createEmpresa(@RequestBody(required = true)Map<String, String> request) throws ErrorResponseException {
        return empresaService.registroEmpresa(request);
    }

    @GetMapping
    public List<Empresa> getLastEmpresaregister(){
        return empresaService.findByLastRegister();
    }
}
