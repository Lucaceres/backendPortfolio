package com.miPortfolio.Portfolio.Service;

import com.miPortfolio.Portfolio.Entity.Proyecto;
import com.miPortfolio.Portfolio.Repository.IproyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProyectoService implements IProyectoService{
    @Autowired
    IproyectoRepository iproyectoRepository;


    @Override
    public List<Proyecto> getAll() {
        return iproyectoRepository.findAll();
    }

    @Override
    public Proyecto get(long id) {
        return iproyectoRepository.getById(id);
    }

    @Override
    public Proyecto getByTitulo(String titulo) {
        return iproyectoRepository.findByTitulo(titulo).orElse(null);
    }

    @Override
    public Proyecto getByLink(String link) {
        return iproyectoRepository.findByLink(link).orElse(null);
    }

    @Override
    public void save(Proyecto proyecto) {
    iproyectoRepository.save(proyecto);
    }

    @Override
    public void delete(long id) {
        iproyectoRepository.deleteById(id);
    }

    @Override
    public boolean existsByTitulo(String titulo) {
        return iproyectoRepository.existsByTitulo(titulo);
    }

    @Override
    public boolean existsById(long id) {
        return iproyectoRepository.existsById(id);
    }

    @Override
    public boolean existByLink(String link)
    {
        return iproyectoRepository.existsByLink(link);
    }
}
