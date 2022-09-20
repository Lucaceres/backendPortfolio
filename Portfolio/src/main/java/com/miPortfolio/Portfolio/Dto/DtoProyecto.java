package com.miPortfolio.Portfolio.Dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class DtoProyecto {
    @NotNull
    private String titulo;
    @NotNull
    private String descripcion;

    @NotNull
    private String link;

    public DtoProyecto() {
    }

    public DtoProyecto(String titulo, String descripcion, String link) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.link = link;
    }
}
