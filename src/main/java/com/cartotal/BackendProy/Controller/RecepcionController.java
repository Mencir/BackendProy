package com.cartotal.BackendProy.Controller;

import com.cartotal.BackendProy.Model.CabeceraRecepcion;
import com.cartotal.BackendProy.Model.DetalleRecepcion;
import com.cartotal.BackendProy.Service.RecepcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recepciones")
@CrossOrigin(origins = "http://localhost:5173")
public class RecepcionController {

    @Autowired
    private RecepcionService recepcionService;

    // Registrar una nueva recepción
    @PostMapping
    public CabeceraRecepcion registrarRecepcion(@RequestBody RecepcionRequest request) {
        return recepcionService.registrarRecepcion(request.getCabecera(), request.getDetalles());
    }

    // Listar todas las recepciones
    @GetMapping
    public List<CabeceraRecepcion> listarRecepciones() {
        return recepcionService.listarRecepciones();
    }

    // Obtener una recepción por ID
    @GetMapping("/{id}")
    public CabeceraRecepcion obtenerPorId(@PathVariable Long id) {
        return recepcionService.obtenerPorId(id);
    }

    // Eliminar una recepción
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        recepcionService.eliminar(id);
    }

    // Clase interna para manejar el JSON compuesto (cabecera + detalles)
    public static class RecepcionRequest {
        private CabeceraRecepcion cabecera;
        private List<DetalleRecepcion> detalles;

        public CabeceraRecepcion getCabecera() {
            return cabecera;
        }

        public void setCabecera(CabeceraRecepcion cabecera) {
            this.cabecera = cabecera;
        }

        public List<DetalleRecepcion> getDetalles() {
            return detalles;
        }

        public void setDetalles(List<DetalleRecepcion> detalles) {
            this.detalles = detalles;
        }
    }
}