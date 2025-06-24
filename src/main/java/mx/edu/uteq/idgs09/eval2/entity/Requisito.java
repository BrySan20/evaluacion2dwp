@Entity
public class Requisito{
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "tipo_requisito_id")
    private TipoRequisito tipoRequisito;
}