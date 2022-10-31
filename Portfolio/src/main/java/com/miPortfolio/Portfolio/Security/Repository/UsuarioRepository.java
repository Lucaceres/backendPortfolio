package com.miPortfolio.Portfolio.Security.Repository;

import com.miPortfolio.Portfolio.Security.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    Optional<Usuario> findUsuarioByNombreUsuario(String nombreUsuario);

    Boolean existsUsuarioByNombreUsuario(String nomrbeUsuario);

}
