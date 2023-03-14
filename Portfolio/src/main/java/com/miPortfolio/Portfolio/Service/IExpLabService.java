/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.miPortfolio.Portfolio.Service;

import com.miPortfolio.Portfolio.Entity.ExperienciaLaboral;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IExpLabService {
    
    public List<ExperienciaLaboral>getAll();
    
    public ExperienciaLaboral get(int id);
    
    public ExperienciaLaboral getByNombreExp(String nombreExp);
    
    public void save(ExperienciaLaboral experiencia);
    
    public void delete(int id);
    
    public boolean existsById(int id);
    
    public boolean existsByNombreExp(String nombreExp);
    
}
