@RestController
@RequestMapping("/api/requisitos")
public class RequisitosController {
    @Autowired private RequisitoService requisitoService;

    @GetMapping
    public List<Requisito> listar() {
        return requisitoService.listar();
    }

    @PostMapping
    public Requisito crear(@RequestBody RequisitoDTO dto) {
        return requisitoService.guardar(dto);
    }
}