package com.miPortfolio.Portfolio.Security.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuarios",uniqueConstraints = {@UniqueConstraint(columnNames = "nombreUsuario")})
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String nombreUsuario;


    @NotBlank
    @Size(max = 120)
    private String passUsuario;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "usuario_roles",
            joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
            private Set<Rol> roles = new HashSet<>();

    public Usuario() {
    }

    public Usuario(String nombreUsuario, String passUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.passUsuario = passUsuario;
    }
}
