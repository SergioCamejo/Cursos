package com.sergiocamejo.curso.dto;

import com.sergiocamejo.curso.model.Modalidad;
import com.sergiocamejo.curso.model.Tema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class CursoDTO {

    private String nombre;
    private Modalidad modalidad;
    private String fechaFinalizacion;
    private List<Tema> temas;
}
