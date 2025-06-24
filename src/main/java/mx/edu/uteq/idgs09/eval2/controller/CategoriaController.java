@RestController
@RequestMapping("api/categorias")
public class CategoriasController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> obtenerCategorias() {
        return categoriaService.listar()
    }

    @PostMapping
    public Categoria crearCategoria(@RequestBody Categoria categoria){
        return categoriaService.guardar(categoria);
    }
}