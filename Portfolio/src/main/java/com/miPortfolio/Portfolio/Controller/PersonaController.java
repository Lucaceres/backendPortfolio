/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miPortfolio.Portfolio.Controller;

import com.miPortfolio.Portfolio.Dto.DtoPersona;
import com.miPortfolio.Portfolio.Entity.Persona;
import com.miPortfolio.Portfolio.Service.IPersonaService;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author user
 */
@RestController
//@CrossOrigin(origins = "https://frontendap-222a1.web.app")
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")

public class PersonaController {
    @Autowired
    IPersonaService iPersonaService;
    
    @GetMapping ("/persona/getall")

    public List<Persona> getPersona()
    {
        return iPersonaService.getPersona();
    }
    
    @GetMapping ("/persona/get/{id}")

    public Persona getPersonaById(@PathVariable Long id)
    {
        return iPersonaService.searchPersona(id);
    }
    
    @PostMapping ("/persona/new")
    public String savePersona(@RequestBody Persona persona)
    {
        iPersonaService.savePersona(persona);
        return "Persona creada correctamente";
    }
    
    @PutMapping ("/persona/editar/{id}")

    public Persona editPersona(@PathVariable Long id,
                               @RequestBody Persona persona)
    {
        Persona personaEditar = iPersonaService.searchPersona(id);
        personaEditar.setNombre(persona.getNombre());
        personaEditar.setApellido(persona.getApellido());
        personaEditar.setAcerca(persona.getAcerca());
        personaEditar.setPuesto(persona.getPuesto());
        iPersonaService.savePersona(personaEditar);
        return personaEditar;
    }
                        
    
    
    @DeleteMapping("/persona/borrar/{id}")

    public String deletePersona(@PathVariable Long id)
    {
        iPersonaService.deletePersona(id);
        return "Persona borrada correctamente";
    }
    
    
    
    
}
