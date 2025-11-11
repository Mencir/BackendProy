package com.cartotal.BackendProy.Repository;

import com.cartotal.BackendProy.Model.VistaStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VistaStockRepository extends JpaRepository<VistaStock, Integer> {
}
