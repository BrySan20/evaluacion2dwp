package mx.edu.uteq.idgs09.eval2.service;

import java.util.List;
import mx.edu.uteq.idgs09.eval2.model.entity.TipoRequisito;
import mx.edu.uteq.idgs09.eval2.model.repository.TipoRequisitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoRequisitoService {
    @Autowired private TipoRequisitoRepository tipoRepo;

    public List<TipoRequisito> listar() {
        return tipoRepo.findAll();
    }

    public TipoRequisito guardar(TipoRequisito tipo) {
        return tipoRepo.save(tipo);
    }
}