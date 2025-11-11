package com.cartotal.BackendProy.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

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

    public int getId_recepcion() {
        return idRecepcion;
    }

    public void setId_recepcion(int id_recepcion) {
        this.idRecepcion = id_recepcion;
    }

    public String getNumero_guia() {
        return numeroGuia;
    }

    public void setNumero_guia(String numero_guia) {
        this.numeroGuia = numero_guia;
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
}
