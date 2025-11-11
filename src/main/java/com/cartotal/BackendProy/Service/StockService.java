package com.cartotal.BackendProy.Service;

import com.cartotal.BackendProy.Model.VistaStock;
import com.cartotal.BackendProy.Repository.VistaStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    @Autowired
    private VistaStockRepository vistaStockRepository;

    public List<VistaStock> listarStock() {
        return vistaStockRepository.findAll();
    }
}
