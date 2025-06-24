package mx.edu.uteq.idgs09.eval2.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.edu.uteq.idgs09.eval2.model.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    
}
