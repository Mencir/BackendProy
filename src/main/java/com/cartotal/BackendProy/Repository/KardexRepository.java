package com.cartotal.BackendProy.Repository;

import com.cartotal.BackendProy.Model.Kardex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KardexRepository extends JpaRepository<Kardex,Long> {
}
