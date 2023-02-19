/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miPortfolio.Portfolio.Service;

import com.miPortfolio.Portfolio.Entity.ExperienciaLaboral;
import com.miPortfolio.Portfolio.Repository.IExpLabRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Transactional
public class ExpLabService implements IExpLabService{
    @Autowired
    IExpLabRepository exp;
    
    @Override
    public List<ExperienciaLaboral> getAll() {
        return exp.findAll();
    }
   

    @Override
    public ExperienciaLaboral get(int id) {
        return exp.findById(id).orElse(null);
    }

    @Override
    public ExperienciaLaboral getByNombreExp(String nombreExp) {
        return exp.findByNombreExp(nombreExp).orElse(null);
    }

    @Override
    public void save(ExperienciaLaboral experiencia) {
        exp.save(experiencia);
    }

    @Override
    public void delete(int id) {
        exp.deleteById(id);
    }

    @Override
    public boolean existsById(int id) {
        return exp.existsById(id);
    }

    @Override
    public boolean existsByNombreExp(String nombreExp) {
        return exp.existsByNombreExp(nombreExp);
    }
    
}
