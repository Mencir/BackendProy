package com.cartotal.BackendProy.Controller;

import com.cartotal.BackendProy.Model.VistaStock;
import com.cartotal.BackendProy.Service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stock")
@CrossOrigin(origins = "*")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping
    public List<VistaStock> listarStock() {
        return stockService.listarStock();
    }
}
