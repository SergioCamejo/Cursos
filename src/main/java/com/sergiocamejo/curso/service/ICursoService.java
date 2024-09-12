package com.sergiocamejo.curso.service;

import com.sergiocamejo.curso.dto.CursoDTO;
import com.sergiocamejo.curso.model.Curso;
import com.sergiocamejo.curso.model.Tema;

import java.util.List;

public interface ICursoService {

    public List<Curso> getCursos();
    public void saveCurso(Curso curso);
    public void createCurso(CursoDTO cursoDTO);
    public void deleteCurso(Long id);
    public Curso findCurso(Long id);
    public void editCurso(Long id, CursoDTO cursoDTO);
    List<Tema> traerTemasDeUnCurso(Long id);
    List<Curso> getCursosEspecificos(String palabraBuscada);
}
