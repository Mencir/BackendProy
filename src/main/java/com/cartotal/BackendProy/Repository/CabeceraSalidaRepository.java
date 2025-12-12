package com.cartotal.BackendProy.Repository;

import com.cartotal.BackendProy.Model.CabeceraSalida;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CabeceraSalidaRepository extends JpaRepository<CabeceraSalida, Long> {
    @EntityGraph(attributePaths = {"detalles", "detalles.producto"})
    List<CabeceraSalida> findAll();
    @EntityGraph(attributePaths = {"detalles", "detalles.producto"})
    CabeceraSalida findByIdSalida(Long id);
}
