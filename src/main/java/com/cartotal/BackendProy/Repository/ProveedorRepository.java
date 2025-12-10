package com.cartotal.BackendProy.Repository;

import com.cartotal.BackendProy.Model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository  extends JpaRepository<Proveedor,Long> {

    // Opcional: buscar por RUC
    Proveedor findByRuc(String ruc);

    // Opcional: buscar por nombre
    Proveedor findByNombre(String nombre);
}
