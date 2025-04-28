package com.ejercicio1.criss.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name = "libro")
public class libro {
//@id = PK
    @Id
// Valores Auto Incremental
    @GeneratedValue(strategy = generationType.IDENTITY)
    @Column(name = "id_libro")
    private int id_libro;

}
