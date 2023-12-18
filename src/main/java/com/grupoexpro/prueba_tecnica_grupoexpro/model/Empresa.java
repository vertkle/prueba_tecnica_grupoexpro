package com.grupoexpro.prueba_tecnica_grupoexpro.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "empresa")
@Getter
@Setter
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmpresa;

    @Column(unique = true, length = 11, nullable = false)
    private String ruc;

    @Column(nullable = false)
    private String razonSocial;
    private String direccion;
    private Integer estado;
}
