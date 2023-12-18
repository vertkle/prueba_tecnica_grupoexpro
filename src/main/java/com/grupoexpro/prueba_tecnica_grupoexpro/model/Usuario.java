package com.grupoexpro.prueba_tecnica_grupoexpro.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Usuario {
    private String usuario;
    private String password;
    private String nombre;

    public Usuario(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }
}
