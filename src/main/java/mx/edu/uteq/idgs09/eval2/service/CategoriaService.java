@Service
public class CategoriaService {
 @Autowired
 private CategoriaRepository categoriaRepository;

 public List<Categoria> listar() {
    return categoriaRepository.findAll();
 }

 public Categoria guardar(Categoria categoria) {
    return categoriaRepository.save(categoria);
 }
}