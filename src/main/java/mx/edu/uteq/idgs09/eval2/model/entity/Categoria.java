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