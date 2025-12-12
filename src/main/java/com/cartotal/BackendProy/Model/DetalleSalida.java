package com.cartotal.BackendProy.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "detalle_salida")
@JsonIgnoreProperties(value = {"salida"}) // evita bucle y reemplaza el @JsonIgnore
public class DetalleSalida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_salida")
    private Long idDetalleSalida;

    @ManyToOne
    @JoinColumn(name = "id_salida")
    private CabeceraSalida salida;

    @ManyToOne
    @JoinColumn(name = "cod_bar", referencedColumnName = "cod_bar", nullable = false)
    private Producto producto;

    @Column(nullable = false)
    private Integer cantidad;

    // Getters y Setters
    public Long getIdDetalleSalida() { return idDetalleSalida; }
    public void setIdDetalleSalida(Long idDetalleSalida) { this.idDetalleSalida = idDetalleSalida; }

    public CabeceraSalida getSalida() { return salida; }
    public void setSalida(CabeceraSalida salida) { this.salida = salida; }

    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) { this.producto = producto; }

    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }
}

