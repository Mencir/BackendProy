package com.cartotal.BackendProy.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "kardex")
public class Kardex {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_kardex;

    private LocalDateTime fecha;

    @Column(nullable = false)
    private String tipo_movimiento; // "ENTRADA" o "SALIDA"

    @ManyToOne
    @JoinColumn(name = "cod_bar", referencedColumnName = "cod_bar", nullable = false)
    private Producto producto;

    private int cantidad;
    private float precio_unitario;

    private Long id_referencia; // Puede ser id_recepcion o id_salida

    @Column(columnDefinition = "text")
    private String observacion;

    // Getters y setters
    public Long getId_kardex() {
        return id_kardex;
    }

    public void setId_kardex(Long id_kardex) {
        this.id_kardex = id_kardex;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getTipo_movimiento() {
        return tipo_movimiento;
    }

    public void setTipo_movimiento(String tipo_movimiento) {
        this.tipo_movimiento = tipo_movimiento;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(float precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public Long getId_referencia() {
        return id_referencia;
    }

    public void setId_referencia(Long id_referencia) {
        this.id_referencia = id_referencia;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}
