package mx.edu.uteq.idgs09.eval2.controller;

import mx.edu.uteq.idgs09.eval2.model.entity.Requisito;
import mx.edu.uteq.idgs09.eval2.service.RequisitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/requisito")
public class RequisitoController {

    @Autowired
    private RequisitoService service;

    @GetMapping
    public List<Requisito> buscarTodos(@RequestParam(defaultValue = "false") boolean soloActivos) {
        return service.buscarTodos(soloActivos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/por-categoria/{categoriaId}")
    public List<Requisito> buscarPorCategoria(@PathVariable int categoriaId) {
        return service.buscarPorCategoria(categoriaId);
    }

    @GetMapping("/por-tipo-requisito/{tipoRequisitoId}")
    public List<Requisito> buscarPorTipoRequisito(@PathVariable int tipoRequisitoId) {
        return service.buscarPorTipoRequisito(tipoRequisitoId);
    }

    @GetMapping("/buscar-por-nombre")
    public List<Requisito> buscarPorNombre(@RequestParam String nombre) {
        return service.buscarPorNombre(nombre);
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Requisito requisito, 
                                   @RequestParam int categoriaId, 
                                   @RequestParam int tipoRequisitoId) {
        Optional<Requisito> opt = service.crear(requisito, categoriaId, tipoRequisitoId);
        if (opt.isPresent()) {
            return ResponseEntity.ok(opt.get());
        }
        return ResponseEntity.badRequest().body("Categoría o Tipo de Requisito no encontrado");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable int id, @RequestBody Requisito requisito) {
        Optional<Requisito> opt = service.editar(id, requisito);
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