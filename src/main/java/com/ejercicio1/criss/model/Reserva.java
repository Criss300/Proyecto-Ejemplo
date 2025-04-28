package com.ejercicio1.criss.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReserva;

    @Temporal(TemporalType.DATE)
    private Date fechaReserva;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idEjemplar")
    private Ejemplar ejemplar;

    // Getters y Setters
}