package com.cartotal.BackendProy.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "cabecera_salida")
public class CabeceraSalida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_salida;

    private LocalDate fecha_salida;
    private String motivo;

    public int getId_salida() {
        return id_salida;
    }

    public void setId_salida(int id_salida) {
        this.id_salida = id_salida;
    }

    public LocalDate getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(LocalDate fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
