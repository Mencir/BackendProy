package com.cartotal.BackendProy.Repository;

import com.cartotal.BackendProy.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    boolean existsByCodBar(String codBar);
    Optional<Producto> findByCodBar(String codBar);
}
