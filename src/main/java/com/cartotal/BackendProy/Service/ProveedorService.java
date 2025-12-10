package com.cartotal.BackendProy.Service;

import com.cartotal.BackendProy.Model.Proveedor;
import com.cartotal.BackendProy.Repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorService {
    @Autowired
    private ProveedorRepository proveedorRepository;

    public List<Proveedor> listar() {
        return proveedorRepository.findAll();
    }

    public Proveedor obtenerPorId(Long id) {
        return proveedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado con ID: " + id));
    }

    public Proveedor registrar(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    public Proveedor actualizar(Long id, Proveedor proveedor) {
        Proveedor existente = obtenerPorId(id);

        existente.setNombre(proveedor.getNombre());
        existente.setRuc(proveedor.getRuc());
        existente.setTelefono(proveedor.getTelefono());

        return proveedorRepository.save(existente);
    }

    public void eliminar(Long id) {
        proveedorRepository.deleteById(id);
    }
}
