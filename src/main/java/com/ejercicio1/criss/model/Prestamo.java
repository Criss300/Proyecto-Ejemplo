package com.ejercicio1.criss.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "prestamo")
public class Prestamo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_prestamo;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fechaPrestamo;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fechaDevolucion;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_ejemplar", nullable = false)
    private Ejemplar ejemplar;

    public Prestamo() {
        // Constructor vacío requerido por JPA
    }

    // Getters y Setters
    public Integer getId_prestamo() {
        return id_prestamo;
    }

    public void setId_prestamo(Integer id_prestamo) { 
        this.id_prestamo = id_prestamo; 
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Ejemplar getEjemplar() {
        return ejemplar;
    }

    public void setEjemplar(Ejemplar ejemplar) {
        this.ejemplar = ejemplar;
    }
}
