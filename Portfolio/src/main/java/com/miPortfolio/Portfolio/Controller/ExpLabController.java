/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miPortfolio.Portfolio.Controller;

import com.miPortfolio.Portfolio.Dto.DtoExperiencia;
import com.miPortfolio.Portfolio.Service.IExpLabService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import com.miPortfolio.Portfolio.Entity.ExperienciaLaboral;
import javax.transaction.Transactional;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("explab")
@CrossOrigin(origins = "http://localhost:4200")
@Transactional
public class ExpLabController {
    @Autowired
    IExpLabService iExpService;
    
    @GetMapping("/list")
    public ResponseEntity <List <ExperienciaLaboral>> getAll()
    {
        List<ExperienciaLaboral> list = iExpService.getAll();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<ExperienciaLaboral> getById(@PathVariable("id") int id){
        if(!iExpService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        ExperienciaLaboral experiencia = iExpService.get(id);
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    
    @PostMapping ("/create")
    public ResponseEntity<?> create(@RequestBody DtoExperiencia dtoexp) 
    {
        
        //valido si esta en blanco
        if(StringUtils.isBlank(dtoexp.getNombreExp()))
        {
            return new ResponseEntity(new Mensaje("Name cant be blank"), HttpStatus.BAD_REQUEST);
        }
        
        //si no esta en balnco verifico si no existe otra exp con el mismo nombre
        else if(iExpService.existsByNombreExp(dtoexp.getNombreExp()))
        {
            return new ResponseEntity(new Mensaje("experience already exists"),HttpStatus.BAD_REQUEST);
        }
        
        // si paso por las 2 validaciones se crea la nueva experiencia
        ExperienciaLaboral experiencia = new ExperienciaLaboral(dtoexp.getNombreExp(),dtoexp.getTiempoExp(), dtoexp.getDescripcionExp());
        iExpService.save(experiencia);
        return new ResponseEntity(new Mensaje("Experience added"),HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoExperiencia dtoexp)
    {
        if(!iExpService.existsById(id))
        {
            return new ResponseEntity(new Mensaje("Cant finind Id"),HttpStatus.BAD_REQUEST);
        }
        
        else if(iExpService.existsByNombreExp(dtoexp.getNombreExp()) && iExpService.getByNombreExp(dtoexp.getNombreExp()).getId() != id)
        {
            return new ResponseEntity(new Mensaje("Experience already exists"), HttpStatus.BAD_REQUEST);
        }
        
        else if(StringUtils.isBlank(dtoexp.getNombreExp()))
        {
            return new ResponseEntity (new Mensaje("The name can`t be blank"), HttpStatus.BAD_REQUEST);
        }
        
        ExperienciaLaboral experiencia = iExpService.get(id);
        experiencia.setNombreExp(dtoexp.getNombreExp());
        experiencia.setTiempoExp(dtoexp.getTiempoExp());
        experiencia.setDescripcionExp(dtoexp.getDescripcionExp());
        return new ResponseEntity(new Mensaje("Updated experience"),HttpStatus.OK);
    }
    
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id)
    {
        if(!iExpService.existsById(id))
        {
            return new ResponseEntity(new Mensaje("Non existent Id"),HttpStatus.BAD_REQUEST);
        }
        iExpService.delete(id);
        return new ResponseEntity(new Mensaje("Deleted experience correctly"), HttpStatus.OK);
    }
}


