package mx.edu.uteq.idgs09.eval2.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "categorias")
@Data
public class Categoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id;
    
    @Column(nullable = false, length = 100)
    private String nombre;
    
    @Column(name = "nombre_categoria_anterior", length = 100)
    private String nombreCategoriaAnterior;
    
    @Column(name = "nombre_categoria_federal", nullable = false, length = 100)
    private String nombreCategoriaFederal;
    
    @Column(name = "nombre_categoria_estatal", nullable = false, length = 100)
    private String nombreCategoriaEstatal;
    
    private boolean activo = true;
    
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion = LocalDateTime.now();
    
    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion = LocalDateTime.now();

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Requisito> requisitos;
    
    @PreUpdate
    public void preUpdate() {
        this.fechaActualizacion = LocalDateTime.now();
    }
}