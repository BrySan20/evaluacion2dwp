@Service
public class RequisitoService {
    @Autowired private TipoRequisitoRepository requisitoRepo;
    @Autowired private CategoriaRepository categoriaRepo;
    @Autowired private TipoRequisitoRepository tipoRepo;

    public Requisito guardar(RequisitoDTO dto) {
        Requisito r = new Requisito();
        r.setNombre(dto.getNombre());
        r.setCategoria(categoriaRepo.findByNombre(dto.getCategoria()));
        r.setTipoRequisito(tipoRepo.findByNombre(dto.getTipoRequisito()));
        return requisitoRepo.save(r);
    }

    public List<Requisito> listar(){
        return requisitoRepo.findAll();
    }
}