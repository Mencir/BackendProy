package com.cartotal.BackendProy.Controller;

import com.cartotal.BackendProy.Model.CabeceraSalida;
import com.cartotal.BackendProy.Model.DetalleSalida;
import com.cartotal.BackendProy.Service.SalidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salidas")
@CrossOrigin(origins = "*")
public class SalidaController {

    @Autowired
    private SalidaService salidaService;

    // Registrar una nueva salida
    @PostMapping
    public CabeceraSalida registrarSalida(@RequestBody SalidaRequest request) {
        return salidaService.registrarSalida(request.getCabecera(), request.getDetalles());
    }

    // Listar todas las salidas
    @GetMapping
    public List<CabeceraSalida> listarSalidas() {
        return salidaService.listarSalidas();
    }

    // Obtener salida por ID
    @GetMapping("/{id}")
    public CabeceraSalida obtenerPorId(@PathVariable Long id) {
        return salidaService.obtenerPorId(id);
    }

    // Eliminar una salida
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        salidaService.eliminar(id);
    }

    // Clase interna para manejar el JSON de entrada
    public static class SalidaRequest {
        private CabeceraSalida cabecera;
        private List<DetalleSalida> detalles;

        public CabeceraSalida getCabecera() {
            return cabecera;
        }

        public void setCabecera(CabeceraSalida cabecera) {
            this.cabecera = cabecera;
        }

        public List<DetalleSalida> getDetalles() {
            return detalles;
        }

        public void setDetalles(List<DetalleSalida> detalles) {
            this.detalles = detalles;
        }
    }
}