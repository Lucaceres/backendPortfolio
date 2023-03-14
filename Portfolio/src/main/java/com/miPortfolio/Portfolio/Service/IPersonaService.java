/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.miPortfolio.Portfolio.Service;

import com.miPortfolio.Portfolio.Entity.Persona;
import org.springframework.stereotype.Service;

import java.util.List;



public interface IPersonaService {
    public List<Persona> getPersona();
    
    public void savePersona(Persona persona);
    
    public void deletePersona(Long id);
    
    public Persona searchPersona(Long id);
    
    
}
