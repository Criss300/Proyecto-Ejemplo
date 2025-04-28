package com.ejercicio1.criss.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "prestamo")
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPrestamo;

    @Temporal(TemporalType.DATE)
    private Date fechaPrestamo;

    @Temporal(TemporalType.DATE)
    private Date fechaDevolucion;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    // Getters y Setters
}
