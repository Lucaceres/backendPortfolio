package com.miPortfolio.Portfolio.Security.Payload.response;

import java.util.List;

public class UsuarioInfoResponse {
    private Long id;
    private String nombreUsuario;
    private List<String> roles;

    private String token;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UsuarioInfoResponse(Long id, String nombreUsuario, List<String> roles, String token) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.roles = roles;
        this.token = token;
    }
}
