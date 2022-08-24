/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miPortfolio.Portfolio.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DtoExperiencia {
    @NotBlank
    private String nombreExp;
    @NotBlank
    private String tiempoExp;
    @NotBlank
    private String descripcionExp;

    public DtoExperiencia() {
    }

    public DtoExperiencia(String nombreExp, String tiempoExp, String descripcionExp) {
        this.nombreExp = nombreExp;
        this.tiempoExp = tiempoExp;
        this.descripcionExp = descripcionExp;
    }
    
    
}
