package com.sergiocamejo.curso.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    @Enumerated(EnumType.ORDINAL)
    private Modalidad modalidad;
    private String fechaFinalizacion;
    @OneToMany
    private List<Tema> temas;


    public Curso() {
    }

    public Curso(Long id, String nombre, Modalidad modalidad, String fechaFinalizacion, List<Tema> temas) {
        this.id = id;
        this.nombre = nombre;
        this.modalidad = modalidad;
        this.fechaFinalizacion = fechaFinalizacion;
        this.temas = temas;
    }
}
