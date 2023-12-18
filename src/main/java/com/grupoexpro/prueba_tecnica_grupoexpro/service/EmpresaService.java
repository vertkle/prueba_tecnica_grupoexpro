package com.grupoexpro.prueba_tecnica_grupoexpro.service;

import com.grupoexpro.prueba_tecnica_grupoexpro.dao.EmpresaDAO;
import com.grupoexpro.prueba_tecnica_grupoexpro.model.Empresa;
import com.grupoexpro.prueba_tecnica_grupoexpro.util.Exception.Errors.ErrorResponseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static com.grupoexpro.prueba_tecnica_grupoexpro.util.Constantes.ESTADO_HABILITADO;
import static com.grupoexpro.prueba_tecnica_grupoexpro.util.Constantes.EX_DUPLICADO;
import static com.grupoexpro.prueba_tecnica_grupoexpro.util.Utilitarios.IsNotEmptyValores;
import static com.grupoexpro.prueba_tecnica_grupoexpro.util.Utilitarios.IsValidateParametros;

@Service
public class EmpresaService implements IEmpresaService{
    @Autowired
    private EmpresaDAO empresaDAO;


    @Override
    public List<Empresa> findByLastRegister() {
        return empresaDAO.findFirstLasts();
    }

    @Override
    public Empresa registroEmpresa(Map<String, String> values) throws ErrorResponseException {
        String parametrosRequeridos [] = {"ruc", "razon_social", "direccion"};
        IsValidateParametros(values, parametrosRequeridos);
        IsNotEmptyValores(values, parametrosRequeridos);
        hasEmpresaRegistrada(values);

        Empresa emp = new Empresa();
        emp.setRuc(values.get("ruc"));
        emp.setRazonSocial(values.get("razon_social"));
        emp.setDireccion(values.get("direccion"));
        emp.setEstado(ESTADO_HABILITADO);
        return empresaDAO.save(emp);
    }

    @Override
    public void hasEmpresaRegistrada(Map<String, String> values) throws ErrorResponseException {
        Empresa e = empresaDAO.findByRuc(values.get("ruc"));
        if(e != null){
            throw new ErrorResponseException(EX_DUPLICADO,HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST);
        }
    }
}
