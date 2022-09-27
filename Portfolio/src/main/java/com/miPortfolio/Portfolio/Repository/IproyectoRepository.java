package com.miPortfolio.Portfolio.Repository;

import com.miPortfolio.Portfolio.Entity.ExperienciaLaboral;
import com.miPortfolio.Portfolio.Entity.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IproyectoRepository extends JpaRepository<Proyecto, Long> {
    public Optional<Proyecto> findByTitulo(String nombre);

    public Optional<Proyecto> findByLink(String titulo);
    public boolean existsByTitulo(String nombre);

    public boolean existsByLink(String nombre);
}
