package mx.edu.uteq.idgs09.eval2.service;

import java.util.List;
import mx.edu.uteq.idgs09.eval2.model.entity.Categoria;
import mx.edu.uteq.idgs09.eval2.model.repository.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
 @Autowired
 private CategoriaRepository categoriaRepository;

 public List<Categoria> listar() {
    return categoriaRepository.findAll();
 }

 public Categoria guardar(Categoria categoria) {
    return categoriaRepository.save(categoria);
 }
}