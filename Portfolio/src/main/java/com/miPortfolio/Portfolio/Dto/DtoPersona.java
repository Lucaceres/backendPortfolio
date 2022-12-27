package com.miPortfolio.Portfolio.Dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
@Getter @Setter
public class DtoPersona {
    @NotNull
    private String nombre;

    @NotNull
    private String apellido;

    @NotNull
    private String acerca;
}
