package com.miPortfolio.Portfolio.Security.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Setter
@Getter
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Roles nombreRol;

    public Rol() {
    }

    public Rol(Roles nombreRol) {
        this.nombreRol = nombreRol;
    }

}
