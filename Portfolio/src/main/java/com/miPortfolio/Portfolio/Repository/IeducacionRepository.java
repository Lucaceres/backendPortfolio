package com.miPortfolio.Portfolio.Repository;

import com.miPortfolio.Portfolio.Entity.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IeducacionRepository extends JpaRepository<Educacion, Long> {
    public Optional<Educacion> findByGrado(String Grado);

    public boolean existsByGrado(String grado);

}
