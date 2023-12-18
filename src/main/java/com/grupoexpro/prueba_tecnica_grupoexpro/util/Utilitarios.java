package com.grupoexpro.prueba_tecnica_grupoexpro.util;

import com.grupoexpro.prueba_tecnica_grupoexpro.util.Exception.Errors.ErrorResponseException;
import org.springframework.http.HttpStatus;

import java.util.Map;

import static com.grupoexpro.prueba_tecnica_grupoexpro.util.Constantes.EX_ERROR_PARAMETROS;
import static com.grupoexpro.prueba_tecnica_grupoexpro.util.Constantes.EX_VALORES_VACIOS;

public class Utilitarios {
    public static final boolean IsValidateParametros(Map<String, String> dict, String parametrosRequeridos[]) throws ErrorResponseException {
        for (String parametro : parametrosRequeridos) {
            if (!dict.containsKey(parametro)) {
                throw new ErrorResponseException(EX_ERROR_PARAMETROS, HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST);
            }
        }
        return true;
    }
    public static final boolean IsNotEmptyValores(Map<String, String> dict, String parametrosRequeridos[]) throws ErrorResponseException {
        for (String parametro: parametrosRequeridos){
            if(dict.get(parametro).isEmpty() || dict.get(parametro) == null){
                throw new ErrorResponseException(EX_VALORES_VACIOS,HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST);
            }
        }
        return true;
    }
}
