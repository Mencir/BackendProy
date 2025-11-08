package com.cartotal.BackendProy.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "detalle_recepcion")
public class DetalleRecepcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_detalle_recepcion;
    @ManyToOne
    @JoinColumn(name = "id_recepcion", nullable = false)
    private CabeceraRecepcion cabeceraRecepcion;
    @ManyToOne
    @JoinColumn(name = "cod_bar", referencedColumnName = "cod_bar", nullable = false)
    private Producto producto;

    private int cantidad;

    public int getId_detalle_recepcion() {
        return id_detalle_recepcion;
    }

    public void setId_detalle_recepcion(int id_detalle_recepcion) {
        this.id_detalle_recepcion = id_detalle_recepcion;
    }

    public CabeceraRecepcion getCabeceraRecepcion() {
        return cabeceraRecepcion;
    }

    public void setCabeceraRecepcion(CabeceraRecepcion cabeceraRecepcion) {
        this.cabeceraRecepcion = cabeceraRecepcion;
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

    public Float getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(Float precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    private Float precio_unitario;
}
