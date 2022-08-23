/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miPortfolio.Portfolio.Service;

import com.miPortfolio.Portfolio.Entity.Persona;
import com.miPortfolio.Portfolio.Repository.IPersonaRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
@Service
public class PersonaService implements IPersonaService{
    @Autowired
    IPersonaRepository iPersonaRepository;

    @Override
    public List<Persona> getPersona() {
    return iPersonaRepository.findAll();
    }

    @Override
    public void savePersona(Persona persona) {
     iPersonaRepository.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
    iPersonaRepository.deleteById(id);
    }

    @Override
    public Persona searchPersona(Long id) {
     return iPersonaRepository.findById(id).orElse(null);
    }
    
}
