package com.miPortfolio.Portfolio.Security.Payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

public class SignupRequest {
    @NotBlank
    @Size(min = 3 , max= 20)
    private String nombreUsuario;

    private Set<String> roles;

    @NotBlank
    @Size(min = 5 , max = 40)
    private String passUsuario;

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public String getPassUsuario() {
        return passUsuario;
    }

    public void setPassUsuario(String passUsuario) {
        this.passUsuario = passUsuario;
    }

    public SignupRequest(String nombreUsuario, Set<String> roles, String passUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.roles = roles;
        this.passUsuario = passUsuario;
    }

    public SignupRequest() {
    }
}
