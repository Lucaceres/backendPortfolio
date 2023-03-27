package com.miPortfolio.Portfolio.Controller;

import com.miPortfolio.Portfolio.Dto.DtoExperiencia;
import com.miPortfolio.Portfolio.Dto.DtoProyecto;
import com.miPortfolio.Portfolio.Entity.Proyecto;
import com.miPortfolio.Portfolio.Service.IProyectoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("api/proyecto")
@CrossOrigin(origins = "https://frontendap-222a1.web.app/")
//@CrossOrigin(origins = "http://localhost:4200")
@Transactional
public class ProyectoController {
    @Autowired
    IProyectoService iProyectoService;

    @GetMapping("/list")

    public ResponseEntity<List<Proyecto>>getAll()
    {
        List<Proyecto> list = iProyectoService.getAll();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")

    public ResponseEntity<Proyecto> getById(@PathVariable("id") long id)
    {
        if(!iProyectoService.existsById(id))
        {
            return new ResponseEntity(new Mensaje ("Id not found"),HttpStatus.NOT_FOUND);
        }
        else {
            Proyecto proyecto = iProyectoService.get(id);
            return new ResponseEntity(proyecto, HttpStatus.OK);
        }
    }

    @PostMapping("/create")

    public ResponseEntity<?> create(@RequestBody DtoProyecto dtoProyecto)
    {

        //VALIDACIONES
        //valido si tiene algun atrtibuto en blanco
        if (StringUtils.isBlank(dtoProyecto.getTitulo())
                ||StringUtils.isBlank(dtoProyecto.getDescripcion())
                || StringUtils.isBlank(dtoProyecto.getLink()))
        {
            return new ResponseEntity(new Mensaje("Attributes cannot be blank"),HttpStatus.BAD_REQUEST);
        }

        //Valida si ya existe un proyecto con el mismo titulo
        else if (iProyectoService.existsByTitulo(dtoProyecto.getTitulo()))
        {
            return new ResponseEntity(new Mensaje("Project already exists"), HttpStatus.BAD_REQUEST);
        }

        //valida si ya existe un proyecto con el mismo link
        else if(iProyectoService.existByLink(dtoProyecto.getLink()))
        {
            return new ResponseEntity(new Mensaje("Link already used"),HttpStatus.BAD_REQUEST);
        }

        //CREACION

        Proyecto proyecto = new Proyecto(dtoProyecto.getTitulo(), dtoProyecto.getDescripcion(), dtoProyecto.getLink());
        iProyectoService.save(proyecto);
        return new ResponseEntity(new Mensaje("Creation Successfull"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")

    public ResponseEntity<?> update (@PathVariable("id") long id,
                                     @RequestBody DtoProyecto dtoProyecto)
    {
        //VALIDACIONES
        //Valido el ID
        if(!iProyectoService.existsById(id))
        {
            return new ResponseEntity(new Mensaje("Id not found"),HttpStatus.NOT_FOUND);
        }

        //valido si ya existe el mismo titulo
        else if(iProyectoService.existsByTitulo(dtoProyecto.getTitulo()) &&
                iProyectoService.getByTitulo(dtoProyecto.getTitulo()).getId()!= id)
        {
            return new ResponseEntity(new Mensaje("Titulo already exist"),HttpStatus.BAD_REQUEST);
        }

        //Valida si ya existe un proyecto con el mismo link
        else if (iProyectoService.existByLink(dtoProyecto.getLink()) &&
                 iProyectoService.getByLink(dtoProyecto.getLink()).getId() != id)
        {
            return new ResponseEntity(new Mensaje("Link already exists"),HttpStatus.BAD_REQUEST);
        }

        Proyecto proyecto = iProyectoService.get(id);
        proyecto.setTitulo(dtoProyecto.getTitulo());
        proyecto.setDescripcion(dtoProyecto.getDescripcion());
        proyecto.setLink(dtoProyecto.getLink());
        return new ResponseEntity(new Mensaje("Proyecto Modified Successfully!"), HttpStatus.OK);
    }

    @DeleteMapping ("/delete/{id}")

    public ResponseEntity<?> delete(@PathVariable("id") long id)
    {
        if(!iProyectoService.existsById(id))
        {
            return new ResponseEntity(new Mensaje("Non existent Id"),HttpStatus.BAD_REQUEST);
        }
        iProyectoService.delete(id);
        return new ResponseEntity(new Mensaje("Deleted experience correctly"), HttpStatus.OK);
    }
}
