package com.cartotal.BackendProy.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "cabecera_recepcion")
public class CabeceraRecepcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recepcion")
    private int idRecepcion;

    @Column(nullable = false, unique = true, name = "numero_guia")
    private String numeroGuia;

    private LocalDate fecha_recepcion;
    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private Proveedor proveedor;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public int getIdRecepcion() {
        return idRecepcion;
    }

    public void setIdRecepcion(int idRecepcion) {
        this.idRecepcion = idRecepcion;
    }

    public String getNumeroGuia() {
        return numeroGuia;
    }

    public void setNumeroGuia(String numeroGuia) {
        this.numeroGuia = numeroGuia;
    }

    public LocalDate getFecha_recepcion() {
        return fecha_recepcion;
    }

    public void setFecha_recepcion(LocalDate fecha_recepcion) {
        this.fecha_recepcion = fecha_recepcion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<DetalleRecepcion> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleRecepcion> detalles) {
        this.detalles = detalles;
    }

    @OneToMany(mappedBy = "cabeceraRecepcion", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<DetalleRecepcion> detalles;

}
