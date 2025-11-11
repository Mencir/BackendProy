package com.cartotal.BackendProy.Repository;

import com.cartotal.BackendProy.Model.DetalleSalida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DetalleSalidaRepository extends JpaRepository<DetalleSalida, Integer> {
    List<DetalleSalida> findBySalida_IdSalida(int idSalida);
}