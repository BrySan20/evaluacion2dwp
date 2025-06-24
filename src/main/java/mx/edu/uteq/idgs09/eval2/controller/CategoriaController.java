package mx.edu.uteq.idgs09.eval2.controller;

import mx.edu.uteq.idgs09.eval2.model.entity.Categoria;
import mx.edu.uteq.idgs09.eval2.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping
    public List<Categoria> buscarTodos(@RequestParam(defaultValue = "false") boolean soloActivos) {
        return service.buscarTodos(soloActivos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/buscar-por-nombre")
    public List<Categoria> buscarPorNombre(@RequestParam String nombre) {
        return service.buscarPorNombre(nombre);
    }

    @GetMapping("/buscar-por-federal")
    public List<Categoria> buscarPorNombreFederal(@RequestParam String nombreFederal) {
        return service.buscarPorNombreFederal(nombreFederal);
    }

    @GetMapping("/buscar-por-estatal")
    public List<Categoria> buscarPorNombreEstatal(@RequestParam String nombreEstatal) {
        return service.buscarPorNombreEstatal(nombreEstatal);
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Categoria categoria) {
        Categoria entity = service.crear(categoria);
        return ResponseEntity.ok(entity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable int id, @RequestBody Categoria categoria) {
        Optional<Categoria> opt = service.editar(id, categoria);
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