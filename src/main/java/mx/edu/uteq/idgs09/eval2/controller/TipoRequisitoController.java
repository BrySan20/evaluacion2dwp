@RestController
@RequestMapping("/api/tipo-requisitos")
public class TipoRequisitoController{
    @Autowired private TipoRequisitoService tipoService;

    @GetMapping
    public List<TipoRequisito> obtenerTipos(){
        return tipoService.listar();
    }

    @PostMapping
    public TipoRequisito crearTipo(@RequestBody TipoRequisito tipo){
        return tipoService.guardar(tipo);
    }
}