package com.cartotal.BackendProy.Service;

import com.cartotal.BackendProy.Model.Producto;
import com.cartotal.BackendProy.Repository.CategoriaRepository;
import com.cartotal.BackendProy.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private CategoriaService categoriaService;

    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    public Optional<Producto> findbyId(Long id) {
        return productoRepository.findById(id);
    }
    public Optional<Producto> findbyCodBar(String codBar) {
        return productoRepository.findByCodBar(codBar);
    }
    public Producto guardar(Producto producto) {
        if (producto.getCategoria() != null && producto.getCategoria().getIdCategoria() != null) {
            var categoriaExistente = categoriaService.findById(producto.getCategoria().getIdCategoria())
                    .orElseThrow(() -> new RuntimeException("Categoría no encontrada con ID: " + producto.getCategoria().getIdCategoria()));
            producto.setCategoria(categoriaExistente);
        }
        return productoRepository.save(producto);
    }
    public void eliminar(Long id) {
        productoRepository.deleteById(id);
    }
    public boolean existe(String cod_bar) {
        return productoRepository.existsByCodBar(cod_bar);
    }
}
