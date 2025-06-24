package mx.edu.uteq.idgs09.eval2.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class TipoRequisito{

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String nombre;

@OneToMany(mappedBy = "tipoRequisito", cascade = CascadeType.ALL)
private List<Requisito> requisitos;
}