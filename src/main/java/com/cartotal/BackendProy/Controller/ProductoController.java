package com.cartotal.BackendProy.Controller;

import com.cartotal.BackendProy.Model.Producto;
import com.cartotal.BackendProy.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> findAll() {
        return productoService.listarProductos();
    }
    @GetMapping("/{id}")
    public Optional<Producto> findById(@PathVariable Long id) {
        return productoService.findbyId(id);
    }
    @GetMapping("/codigo/{cod_bar}")
    public Optional<Producto> findByCodBar(@PathVariable String cod_bar) {
        return productoService.findbyCodBar(cod_bar);
    }
    @PostMapping
    public Producto addProducto(@RequestBody Producto producto) {
        return productoService.guardar(producto);
    }
    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable Long id, @RequestBody Producto producto) {
        producto.setId_producto(id);
        return productoService.guardar(producto);
    }
    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable Long id) {
        productoService.eliminar(id);
    }
}
