package mx.edu.uteq.idgs09.eval2.model.dto;
import lombok.Data;

@Data
public class CategoriaDTO {
    private String nombre;
    private String categoriaAnterior;
    private String categoriaFederal;
    private String categoriaEstatal;
}
