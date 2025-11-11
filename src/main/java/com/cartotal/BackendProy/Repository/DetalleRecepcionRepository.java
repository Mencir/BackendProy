package com.cartotal.BackendProy.Repository;

import com.cartotal.BackendProy.Model.DetalleRecepcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleRecepcionRepository extends JpaRepository<DetalleRecepcion, Integer> {
    List<DetalleRecepcion> findByCabeceraRecepcion_IdRecepcion(int idRecepcion);
}
