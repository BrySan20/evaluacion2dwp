package mx.edu.uteq.idgs09.eval2.service;

import java.util.List;
import mx.edu.uteq.idgs09.eval2.model.dto.RequisitoDTO;
import mx.edu.uteq.idgs09.eval2.model.entity.Requisito;
import mx.edu.uteq.idgs09.eval2.model.repository.CategoriaRepository;
import mx.edu.uteq.idgs09.eval2.model.repository.TipoRequisitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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