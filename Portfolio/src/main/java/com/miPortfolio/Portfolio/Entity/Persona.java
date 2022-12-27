/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miPortfolio.Portfolio.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;


@Entity
@Getter @Setter
public class Persona{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String nombre;
    @NotNull
    private String apellido;

    @NotNull
    private String acerca;

    @NotNull
    private String puesto;

    @JsonIgnoreProperties("persona")
    @OneToMany
    @JoinColumn(name = "persona_id", referencedColumnName = "id")
    private List<Educacion> educaciones;

    @JsonIgnoreProperties("persona")
    @OneToMany
    @JoinColumn(name = "persona_id", referencedColumnName = "id")
    private List<ExperienciaLaboral> experienciaslab;

    @JsonIgnoreProperties("persona")
    @OneToMany
    @JoinColumn(name = "persona_id", referencedColumnName = "id")
    private List<Proyecto> proyectos;

    public Persona(String nombre, String apellido, String acerca, String puesto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.acerca = acerca;
        this.puesto = puesto;
    }
    public Persona()
    {

    }
}
