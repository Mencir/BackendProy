package com.cartotal.BackendProy.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "detalle_salida")
public class DetalleSalida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_detalle_salida;

    @ManyToOne
    @JoinColumn(name = "id_salida", nullable = false)
    private CabeceraSalida salida;

    @ManyToOne
    @JoinColumn(name = "cod_bar", referencedColumnName = "cod_bar", nullable = false)
    private Producto producto;

    private int cantidad;

    public int getId_detalle_salida() {
        return id_detalle_salida;
    }

    public void setId_detalle_salida(int id_detalle_salida) {
        this.id_detalle_salida = id_detalle_salida;
    }

    public CabeceraSalida getSalida() {
        return salida;
    }

    public void setSalida(CabeceraSalida salida) {
        this.salida = salida;
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
}
