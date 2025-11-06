package com.cartotal.BackendProy.Controller;

import com.cartotal.BackendProy.Model.Categoria;
import com.cartotal.BackendProy.Service.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
    private final CategoriaService categoriaService;
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }
    @GetMapping
    public ResponseEntity<List<Categoria>>listar(){
        return ResponseEntity.ok(categoriaService.listarCategorias());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id){
        return categoriaService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Categoria> crear(@RequestBody Categoria categoria){
        return ResponseEntity.ok(categoriaService.GuardarCategoria(categoria));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> actualizar(@PathVariable Long id, @RequestBody Categoria categoria){
        return categoriaService.findById(id).map(c ->{
            c.setNombre(categoria.getNombre());
            c.setDescripcion(categoria.getDescripcion());
            return ResponseEntity.ok(categoriaService.GuardarCategoria(c));
        }).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Categoria> eliminar(@PathVariable Long id){
        categoriaService.EliminarCategoria(id);
        return ResponseEntity.noContent().build();
    }
}
