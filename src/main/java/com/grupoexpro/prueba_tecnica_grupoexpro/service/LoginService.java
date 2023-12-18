package com.grupoexpro.prueba_tecnica_grupoexpro.service;

import com.grupoexpro.prueba_tecnica_grupoexpro.model.Usuario;
import com.grupoexpro.prueba_tecnica_grupoexpro.util.Exception.Errors.ErrorResponseException;
import com.grupoexpro.prueba_tecnica_grupoexpro.util.security.jwt.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import static com.grupoexpro.prueba_tecnica_grupoexpro.util.Utilitarios.IsNotEmptyValores;
import static com.grupoexpro.prueba_tecnica_grupoexpro.util.Utilitarios.IsValidateParametros;


@Service
public class LoginService implements ILoginService{
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public ResponseEntity<String> islogin(Map<String, String> request) throws ErrorResponseException {
        String parametrosRequeridos[] = {"usuario", "password"};
        IsValidateParametros(request, parametrosRequeridos);
        IsNotEmptyValores(request, parametrosRequeridos);

        Usuario usuario = new Usuario(request.get("usuario"), request.get("password"));
        if(usuario.getUsuario().equals("admin") && usuario.getPassword().equals("admin")){
            return new ResponseEntity<String>(
                    "{\"token \":\"" + jwtUtil.generateToken(usuario.getUsuario(),
                            "-") +"\"}",
                    HttpStatus.OK);
        }
        return new ResponseEntity<String>("{\"mensaje\": " + "Credenciales Incorrectas"+"\"}", HttpStatus.BAD_REQUEST);
    }
}
