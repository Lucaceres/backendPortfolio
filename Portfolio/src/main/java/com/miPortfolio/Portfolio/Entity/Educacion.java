package com.miPortfolio.Portfolio.Entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Setter @Getter
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String grado;

    @NotNull
    private String anioInicio;

    @NotNull
    private String anioFin;

    @NotNull
    private String descripcion;

    public Educacion(String grado, String anioInicio, String anioFin, String descripcion)
    {
        this.grado = grado;
        this.anioInicio = anioInicio;
        this.anioFin = anioFin;
        this.descripcion = descripcion;
    }
}
