/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miPortfolio.Portfolio.Controller;

import com.miPortfolio.Portfolio.Entity.Persona;
import com.miPortfolio.Portfolio.Service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author user
 */
@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*", maxAge = 3600)
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
                               @RequestParam ("nombre") String nuevoNombre,
                               @RequestParam("apellido") String nuevoApellido)
    {
        Persona persona = iPersonaService.searchPersona(id);
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        iPersonaService.savePersona(persona);
        return persona;
    }
                        
    
    
    @DeleteMapping("/persona/borrar/{id}")

    public String deletePersona(@PathVariable Long id)
    {
        iPersonaService.deletePersona(id);
        return "Persona borrada correctamente";
    }
    
    
    
    
}
