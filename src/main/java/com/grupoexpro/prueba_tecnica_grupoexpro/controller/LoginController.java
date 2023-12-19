package com.grupoexpro.prueba_tecnica_grupoexpro.controller;

import com.grupoexpro.prueba_tecnica_grupoexpro.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static com.grupoexpro.prueba_tecnica_grupoexpro.util.Constantes.ALGO_SALIO_MAL;

@RestController
@RequestMapping("/api/usuario")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestBody(required = true) Map<String,String> requestMap){
        try {
            return loginService.islogin(requestMap);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(ALGO_SALIO_MAL, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
