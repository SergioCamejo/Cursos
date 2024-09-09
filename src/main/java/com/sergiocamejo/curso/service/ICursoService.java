package com.sergiocamejo.curso.service;

import com.sergiocamejo.curso.dto.CursoDTO;
import com.sergiocamejo.curso.model.Curso;

import java.util.List;

public interface ICursoService {

    public List<Curso> getCursos();
    public Curso saveCurso(Curso curso);
    public Curso createCurso(CursoDTO cursoDTO);
    public void deleteCurso(Long id);
    public Curso findCurso(Long id);
    public Curso editCurso(Long id, CursoDTO cursoDTO);

}
