package com.miPortfolio.Portfolio.Service;

import com.miPortfolio.Portfolio.Entity.Proyecto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IProyectoService {

 public List<Proyecto> getAll();

 public Proyecto get(long id);

 public Proyecto getByTitulo(String titulo);
 public Proyecto getByLink(String link);

 public void save(Proyecto proyecto);

 public void delete(long id);

 public boolean existsByTitulo(String id);

 public boolean existsById(long id);

 public boolean existByLink(String link);
}
