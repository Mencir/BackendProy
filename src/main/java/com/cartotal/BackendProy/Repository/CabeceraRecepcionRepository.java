package com.cartotal.BackendProy.Repository;

import com.cartotal.BackendProy.Model.CabeceraRecepcion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CabeceraRecepcionRepository extends JpaRepository<CabeceraRecepcion, Long> {
    CabeceraRecepcion findByNumeroGuia(String numeroGuia);
}
