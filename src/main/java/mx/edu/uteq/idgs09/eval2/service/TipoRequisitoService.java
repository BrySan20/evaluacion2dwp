@Servicepublic class TipoRequisitoService {
    @Autowired private TipoRequisitoRepository tipoRepo;

    public List<TipoRequisito> listar() {
        return tipoRepo.findAll();
    }

    public TipoRequisito guardar(TipoRequisito tipo) {
        return tipoRepo.save(tipo);
    }
}