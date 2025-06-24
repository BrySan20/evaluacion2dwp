package mx.edu.uteq.idgs09.eval2.model.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class RequisitoDTO {
    private int id;
    private String nombre;
    private boolean activo;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
    private TipoRequisitoDTO tipoRequisito;
    private CategoriaDTO categoria;
}