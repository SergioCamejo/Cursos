package com.sergiocamejo.curso.service;

import com.sergiocamejo.curso.dto.CursoDTO;
import com.sergiocamejo.curso.model.Curso;
import com.sergiocamejo.curso.repository.ICursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CursoService implements ICursoService {

    @Autowired
    private ICursoRepository cursoRepo;

    @Override
    public List<Curso> getCursos() {
        return this.cursoRepo.findAll();
    }

    @Override
    public Curso saveCurso(Curso curso) {
        return this.cursoRepo.save(curso);
    }

    @Override
    public Curso createCurso(CursoDTO cursoDTO) {
        Curso nuevoCurso = new Curso();
        nuevoCurso.setNombre(cursoDTO.getNombre());
        nuevoCurso.setModalidad(cursoDTO.getModalidad());
        nuevoCurso.setFechaFinalizacion(cursoDTO.getFechaFinalizacion());
        return this.cursoRepo.save(nuevoCurso);
    }

    @Override
    public void deleteCurso(Long id) {
        this.cursoRepo.deleteById(id);
    }

    @Override
    public Curso findCurso(Long id) {
        return this.cursoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el curso con el Id " + id));
    }

    @Override
    public Curso editCurso(Long id, CursoDTO cursoDTO) {
        Curso cursoEditado = this.findCurso(id);
        if (cursoDTO.getNombre() != null) {
            cursoEditado.setNombre(cursoDTO.getNombre());
        }
        if (cursoDTO.getModalidad() != null) {
            cursoEditado.setModalidad(cursoDTO.getModalidad());
        }
        if (cursoDTO.getFechaFinalizacion() != null) {
            cursoEditado.setFechaFinalizacion(cursoDTO.getFechaFinalizacion());
        }
        return this.saveCurso(cursoEditado);
    }
}
