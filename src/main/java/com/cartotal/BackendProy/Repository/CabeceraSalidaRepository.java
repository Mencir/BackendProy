package com.cartotal.BackendProy.Repository;

import com.cartotal.BackendProy.Model.CabeceraSalida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CabeceraSalidaRepository extends JpaRepository<CabeceraSalida, Long> {
}
