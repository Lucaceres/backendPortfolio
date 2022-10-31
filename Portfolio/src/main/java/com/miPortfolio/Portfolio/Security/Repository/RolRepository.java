package com.miPortfolio.Portfolio.Security.Repository;

import com.miPortfolio.Portfolio.Security.Entity.Rol;
import com.miPortfolio.Portfolio.Security.Entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol,Long> {
    Optional<Rol> findByNombreRol(Roles nombreRol);
}
