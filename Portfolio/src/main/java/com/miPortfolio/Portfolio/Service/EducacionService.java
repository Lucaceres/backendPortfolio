package com.miPortfolio.Portfolio.Service;

import com.miPortfolio.Portfolio.Entity.Educacion;
import com.miPortfolio.Portfolio.Repository.IeducacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
public class EducacionService implements IEducacionService{
@Autowired
IeducacionRepository iEducacionRepository;
    @Override
    public List<Educacion> getAll() {
        return iEducacionRepository.findAll();
    }

    @Override
    public Educacion getById(long id) {
        return iEducacionRepository.findById(id).orElse(null);
    }

     @Override
    public Educacion getByGrado(String grado) {
        return iEducacionRepository.findByGrado(grado).orElse(null);
    }

     @Override
    public void save(Educacion educacion) {
        iEducacionRepository.save(educacion);
    }

    @Override
    public void delete(long id) {
        iEducacionRepository.deleteById(id);
    }

    @Override
    public boolean existsByGrado(String grado) {
        return iEducacionRepository.existsByGrado(grado);
    }

    @Override
    public boolean existsById(long id) {
        return iEducacionRepository.existsById(id);
    }
}
