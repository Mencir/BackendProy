package com.cartotal.BackendProy.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "detalle_salida")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class DetalleSalida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_salida")
    private Long idDetalleSalida;

    @ManyToOne
    @JoinColumn(name = "id_salida")
    @JsonIgnore
    private CabeceraSalida salida;


    @ManyToOne
    @JoinColumn(name = "cod_bar", referencedColumnName = "cod_bar", nullable = false)
    private Producto producto;

    @Column(nullable = false)
    private Integer cantidad;

    // ===== GETTERS & SETTERS =====

    public Long getIdDetalleSalida() {
        return idDetalleSalida;
    }

    public void setIdDetalleSalida(Long idDetalleSalida) {
        this.idDetalleSalida = idDetalleSalida;
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

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
