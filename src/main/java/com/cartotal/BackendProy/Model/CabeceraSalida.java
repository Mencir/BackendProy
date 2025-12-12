package com.cartotal.BackendProy.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "cabecera_salida")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CabeceraSalida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_salida")
    private int idSalida;

    @Column(name = "fecha_salida", nullable = false)
    private LocalDate fechaSalida;

    @Column(name = "motivo", length = 255)
    private String motivo;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    // YA NO IGNORADO → ASÍ SE MOSTRARÁ EN EL GET
    @OneToMany(mappedBy = "salida", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DetalleSalida> detalles;

    // Getters y Setters
    public int getIdSalida() { return idSalida; }
    public void setIdSalida(int idSalida) { this.idSalida = idSalida; }

    public LocalDate getFechaSalida() { return fechaSalida; }
    public void setFechaSalida(LocalDate fechaSalida) { this.fechaSalida = fechaSalida; }

    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public List<DetalleSalida> getDetalles() { return detalles; }
    public void setDetalles(List<DetalleSalida> detalles) { this.detalles = detalles; }
}
