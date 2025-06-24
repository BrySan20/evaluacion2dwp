package mx.edu.uteq.idgs09.eval2.controller;

import mx.edu.uteq.idgs09.eval2.model.entity.TipoRequisito;
import mx.edu.uteq.idgs09.eval2.service.TipoRequisitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tipo-requisito")
public class TipoRequisitoController {

    @Autowired
    private TipoRequisitoService service;

    @GetMapping
    public List<TipoRequisito> buscarTodos(@RequestParam(defaultValue = "false") boolean soloActivos) {
        return service.buscarTodos(soloActivos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/buscar-por-nombre")
    public List<TipoRequisito> buscarPorNombre(@RequestParam String nombre) {
        return service.buscarPorNombre(nombre);
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody TipoRequisito tipoRequisito) {
        TipoRequisito entity = service.crear(tipoRequisito);
        return ResponseEntity.ok(entity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable int id, @RequestBody TipoRequisito tipoRequisito) {
        Optional<TipoRequisito> opt = service.editar(id, tipoRequisito);
        if (opt.isPresent()) {
            return ResponseEntity.ok(opt.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable int id) {
        if (service.borrar(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}/desactivar")
    public ResponseEntity<?> desactivar(@PathVariable int id) {
        if (service.desactivar(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}