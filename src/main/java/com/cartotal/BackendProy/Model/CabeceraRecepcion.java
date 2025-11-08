package com.cartotal.BackendProy.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "cabecera_recepcion")
public class CabeceraRecepcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_recepcion;
    @Column(nullable = false, unique = true)
    private String numero_guia;

    private LocalDate fecha_recepcion;
    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private Proveedor proveedor;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public int getId_recepcion() {
        return id_recepcion;
    }

    public void setId_recepcion(int id_recepcion) {
        this.id_recepcion = id_recepcion;
    }

    public String getNumero_guia() {
        return numero_guia;
    }

    public void setNumero_guia(String numero_guia) {
        this.numero_guia = numero_guia;
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
