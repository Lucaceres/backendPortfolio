package com.miPortfolio.Portfolio.Controller;

import com.miPortfolio.Portfolio.Dto.DtoEducacion;
import com.miPortfolio.Portfolio.Entity.Educacion;
import com.miPortfolio.Portfolio.Service.IEducacionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.EditorKit;
import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("api/educacion")
@CrossOrigin(origins = "https://frontendap-222a1.web.app/")
//@CrossOrigin(origins = "http://localhost:4200")
@Transactional
public class EducacionController {
    @Autowired
    IEducacionService iEducacionService;

    @GetMapping("/list")

    public ResponseEntity<List<Educacion>>getAll()
    {
        List<Educacion> list = iEducacionService.getAll();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")

    public ResponseEntity<Educacion> getById(@PathVariable("id") long id)
    {
        if(!iEducacionService.existsById(id))
        {
            return new ResponseEntity(new Mensaje("Id not found"), HttpStatus.NOT_FOUND);
        }
        else{
            Educacion educacion = iEducacionService.getById(id);
            return new ResponseEntity(educacion, HttpStatus.OK);
        }
    }

    @PostMapping("/create")

    public ResponseEntity<?> create(@RequestBody DtoEducacion dtoEducacion)
    {
        //VALIDACIONES

        //Atributo en blanco
        if(StringUtils.isBlank(dtoEducacion.getGrado())
           || StringUtils.isBlank(dtoEducacion.getDescripcion())
           || StringUtils.isBlank(dtoEducacion.getAnioInicio()) ||
                StringUtils.isBlank(dtoEducacion.getAnioFin()))
        {
            return new ResponseEntity(new Mensaje("Attributes cannot be blank"),HttpStatus.BAD_REQUEST);
        }

        // Si existe una educacion con el mismo grado
        else if(iEducacionService.existsByGrado(dtoEducacion.getGrado()))
        {
            return new ResponseEntity(new Mensaje("Educacion already exists"), HttpStatus.BAD_REQUEST);
        }

        //Si pasa las validaciones lo creo

        Educacion educacion = new Educacion(dtoEducacion.getGrado(),dtoEducacion.getAnioInicio(),dtoEducacion.getAnioFin(),dtoEducacion.getDescripcion());
        iEducacionService.save(educacion);
        return new ResponseEntity(new Mensaje("created Succesfuly"),HttpStatus.OK);
    }

    @PutMapping("update/{id}")

    public ResponseEntity<?> update (@PathVariable("id") long id,
                                     @RequestBody DtoEducacion dtoEducacion)
    {
        //Validaciones
        //busco ese id
        if(!iEducacionService.existsById(id))
        {
            return new ResponseEntity(new Mensaje("Id not found"),HttpStatus.NOT_FOUND);
        }
        else if(iEducacionService.existsByGrado(dtoEducacion.getGrado()) &&
                iEducacionService.getByGrado(dtoEducacion.getGrado()).getId()!=id)
        {
            return new ResponseEntity(new Mensaje("Grado Already exists"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = iEducacionService.getById(id);
        educacion.setDescripcion(dtoEducacion.getDescripcion());
        educacion.setGrado(dtoEducacion.getGrado());
        educacion.setAnioInicio(dtoEducacion.getAnioInicio());
        educacion.setAnioFin(dtoEducacion.getAnioFin());
        return new ResponseEntity(new Mensaje("Educacion modified succesfully"),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")

    public ResponseEntity<?> delete(@PathVariable("id") long id)
    {
        if(!iEducacionService.existsById(id))
        {
            return new ResponseEntity(new Mensaje("non existent Id"), HttpStatus.NOT_FOUND);
        }
        iEducacionService.delete(id);
        return new ResponseEntity(new Mensaje("Deleted Educacion succesfully"), HttpStatus.OK);
    }
}
