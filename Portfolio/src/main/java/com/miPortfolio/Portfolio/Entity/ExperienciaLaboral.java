/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miPortfolio.Portfolio.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class ExperienciaLaboral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
   
    private String nombreExp;

    private String tiempoExp;
    
    private String descripcionExp;
    
   //constructores

    public ExperienciaLaboral() {
    }

    public ExperienciaLaboral( String nombreExp, String tiempoExp, String descripcionExp) {
        this.nombreExp = nombreExp;
        this.tiempoExp = tiempoExp;
        this.descripcionExp = descripcionExp;
    }
  
    
}
