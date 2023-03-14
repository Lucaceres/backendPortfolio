package com.miPortfolio.Portfolio.Service;

import com.miPortfolio.Portfolio.Entity.Educacion;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface IEducacionService {

    public List<Educacion> getAll();

    public Educacion getById(long id);

    public Educacion getByGrado(String grado);

    public  void save (Educacion educacion);

    public void delete (long id);

    public boolean existsByGrado(String grado);

    public boolean existsById(long id);

}
