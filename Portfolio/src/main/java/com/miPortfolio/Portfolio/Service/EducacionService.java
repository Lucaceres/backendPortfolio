package com.miPortfolio.Portfolio.Service;

import com.miPortfolio.Portfolio.Entity.Educacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EducacionService implements IEducacionService{
@Autowired
IEducacionService iEducacionService;
    @Override
    public List<Educacion> getAll() {
        return iEducacionService.getAll();
    }

    @Override
    public Educacion getById(long id) {
        return iEducacionService.getById(id);
    }

    @Override
    public Educacion getByGrado(String grado) {
        return iEducacionService.getByGrado(grado);
    }

    @Override
    public void save(Educacion educacion) {
    iEducacionService.save(educacion);
    }

    @Override
    public void delete(long id) {
    iEducacionService.delete(id);
    }

    @Override
    public boolean existsByGrado(String grado) {
        return iEducacionService.existsByGrado(grado);
    }
}
