@Entity
public class tipoRequisito{

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String nombre;

@OneToMany(mappedBy = "tipoRequisito", cascade = CascadeType.ALL)
private List<Requisito> requisitos;
}