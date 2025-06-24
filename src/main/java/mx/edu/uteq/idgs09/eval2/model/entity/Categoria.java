package mx.edu.uteq.idgs09.eval2.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;


@Entity

public class Categoria{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String nombre;

@ManyToOne
@JoinColumn(name = "categoria_anterior_id")
private Categoria categoriaAnterior;

private String categoriaFederal;
private String categoriaEstatal;

@OneToMany(mappedBy = "categoria", cascade = CascadeType.All)
private List<Requisito> requisitos;
}