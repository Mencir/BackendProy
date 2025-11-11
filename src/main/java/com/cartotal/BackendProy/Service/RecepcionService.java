package com.cartotal.BackendProy.Service;

import com.cartotal.BackendProy.Model.CabeceraRecepcion;
import com.cartotal.BackendProy.Model.DetalleRecepcion;
import com.cartotal.BackendProy.Model.Kardex;
import com.cartotal.BackendProy.Model.Producto;
import com.cartotal.BackendProy.Repository.CabeceraRecepcionRepository;
import com.cartotal.BackendProy.Repository.DetalleRecepcionRepository;
import com.cartotal.BackendProy.Repository.KardexRepository;
import com.cartotal.BackendProy.Repository.ProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class RecepcionService {
    @Autowired
    private CabeceraRecepcionRepository cabeceraRecepcionRepository;

    @Autowired
    private DetalleRecepcionRepository detalleRecepcionRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private KardexRepository kardexRepository;
    @Transactional
    public CabeceraRecepcion registrarRecepcion(CabeceraRecepcion cabecera, List<DetalleRecepcion> detalles) {
        cabecera.setFecha_recepcion(LocalDate.now());
        CabeceraRecepcion savedCabecera = cabeceraRecepcionRepository.save(cabecera);

        for (DetalleRecepcion detalle : detalles) {
            detalle.setCabeceraRecepcion(savedCabecera);

            // Verificar producto existente
            Producto producto = productoRepository.findByCodBar(detalle.getProducto().getCodBar())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado: " + detalle.getProducto().getCodBar()));

            detalle.setProducto(producto);
            detalleRecepcionRepository.save(detalle);

            // Registrar en Kardex
            Kardex kardex = new Kardex();
            kardex.setFecha(LocalDateTime.now());
            kardex.setTipo_movimiento("ENTRADA");
            kardex.setProducto(producto);
            kardex.setCantidad(detalle.getCantidad());
            kardex.setPrecio_unitario(detalle.getPrecio_unitario().floatValue());
            kardex.setId_referencia((long) savedCabecera.getId_recepcion());
            kardex.setObservacion("Recepción N° " + savedCabecera.getNumero_guia());
            kardexRepository.save(kardex);
        }

        return savedCabecera;
    }
    public List<CabeceraRecepcion> listarRecepciones() {
        return cabeceraRecepcionRepository.findAll();
    }

    public CabeceraRecepcion obtenerPorId(Long id) {
        return cabeceraRecepcionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recepción no encontrada con ID: " + id));
    }

    public void eliminar(Long id) {
        cabeceraRecepcionRepository.deleteById(id);
    }

}
