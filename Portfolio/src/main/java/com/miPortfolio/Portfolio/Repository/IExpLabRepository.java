/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.miPortfolio.Portfolio.Repository;

import com.miPortfolio.Portfolio.Entity.ExperienciaLaboral;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExpLabRepository extends JpaRepository<ExperienciaLaboral, Integer>{
    public Optional<ExperienciaLaboral> findByNombreExp(String nombreExp);
    public boolean existsByNombreExp(String nombreExp);
}
