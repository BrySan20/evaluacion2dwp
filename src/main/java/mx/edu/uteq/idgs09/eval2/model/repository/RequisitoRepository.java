package mx.edu.uteq.idgs09.eval2.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.edu.uteq.idgs09.eval2.model.entity.Requisito;

public interface RequisitoRepository extends JpaRepository<Requisito, Integer> {
    
}
