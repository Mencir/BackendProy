package com.cartotal.BackendProy.Service;

import com.cartotal.BackendProy.Model.*;
import com.cartotal.BackendProy.Repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SalidaService {

    @Autowired
    private CabeceraSalidaRepository cabeceraSalidaRepository;

    @Autowired
    private DetalleSalidaRepository detalleSalidaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private KardexRepository kardexRepository;

    @Autowired
    private UsuarioRepository usuarioRepository; // ✅ agregado

    @Transactional
    public CabeceraSalida registrarSalida(CabeceraSalida cabecera, List<DetalleSalida> detalles) {

        // ✅ Cargar usuario existente antes de guardar
        if (cabecera.getUsuario() != null && cabecera.getUsuario().getId_usuario() != 0) {
            Usuario usuario = usuarioRepository.findById(cabecera.getUsuario().getId_usuario())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + cabecera.getUsuario().getId_usuario()));
            cabecera.setUsuario(usuario);
        } else {
            throw new RuntimeException("Debe indicar un usuario válido en la cabecera.");
        }

        cabecera.setFechaSalida(LocalDate.now());
        CabeceraSalida savedCabecera = cabeceraSalidaRepository.save(cabecera);

        for (DetalleSalida detalle : detalles) {
            detalle.setSalida(savedCabecera);

            Producto producto = productoRepository.findByCodBar(detalle.getProducto().getCodBar())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado: " + detalle.getProducto().getCodBar()));

            detalle.setProducto(producto);
            detalleSalidaRepository.save(detalle);

            // Registrar en Kardex
            Kardex kardex = new Kardex();
            kardex.setFecha(LocalDateTime.now());
            kardex.setTipo_movimiento("SALIDA");
            kardex.setProducto(producto);
            kardex.setCantidad(detalle.getCantidad());
            kardex.setPrecio_unitario(producto.getPrecio_unitario().floatValue());
            kardex.setId_referencia((long) savedCabecera.getIdSalida());
            kardex.setObservacion("Salida por " + cabecera.getMotivo());
            kardexRepository.save(kardex);
        }

        return savedCabecera;
    }

    public List<CabeceraSalida> listarSalidas() {
        return cabeceraSalidaRepository.findAll();
    }

    public CabeceraSalida obtenerPorId(Long id) {
        return cabeceraSalidaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Salida no encontrada con ID: " + id));
    }

    public void eliminar(Long id) {
        cabeceraSalidaRepository.deleteById(id);
    }
}
