package com.miPortfolio.Portfolio.Dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter @Getter
public class DtoEducacion {

    @NotNull
    private String grado;

    @NotNull
    private String anioInicio;

    @NotNull
    private String anioFin;

    @NotNull
    private String descripcion;

    public DtoEducacion() {
    }

    public DtoEducacion(String grado, String anioInicio, String anioFin, String descripcion) {
        this.grado = grado;
        this.anioInicio = anioInicio;
        this.anioFin = anioFin;
        this.descripcion = descripcion;
    }
}
