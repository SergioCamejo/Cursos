package com.sergiocamejo.curso.service;

import com.sergiocamejo.curso.dto.CursoDTO;
import com.sergiocamejo.curso.model.Curso;
import com.sergiocamejo.curso.model.Tema;
import com.sergiocamejo.curso.repository.ICursoRepository;
import com.sergiocamejo.curso.repository.ITemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CursoService implements ICursoService {

    @Autowired
    private ICursoRepository cursoRepo;

    @Autowired
    private ITemaRepository temaRepo;

    @Override
    public List<Curso> getCursos() {
        return this.cursoRepo.findAll();
    }

    @Override
    public List<Tema> traerTemasDeUnCurso(Long id) {
        return this.cursoRepo.findById(id).get().getTemas();
    }

    @Override
    public List<Curso> getCursosEspecificos(String palabraBuscada) {
        String textoABuscar;
        List<Curso> listaCursosEspecificos = new ArrayList<>();
        for (Curso curso : this.getCursos()) {
            textoABuscar = curso.getNombre().trim().toLowerCase();
            boolean contienePalabra = textoABuscar.contains(palabraBuscada);
            if (contienePalabra) {
                listaCursosEspecificos.add(curso);
            }
        }
        return listaCursosEspecificos;
    }

    @Override
    public void saveCurso(Curso curso) {
        this.cursoRepo.save(curso);
    }

    @Override
    public void createCurso(CursoDTO cursoDTO) {
        Curso nuevoCurso = new Curso();
        nuevoCurso.setNombre(cursoDTO.getNombre());
        nuevoCurso.setModalidad(cursoDTO.getModalidad());
        nuevoCurso.setFechaFinalizacion(cursoDTO.getFechaFinalizacion());
        this.cursoRepo.save(nuevoCurso);
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
    public void editCurso(Long id, CursoDTO cursoDTO) {
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

        List<Tema> listaTemas = cursoEditado.getTemas();

        if (cursoDTO.getTemas() != null){
            for (Tema nuevoTema : cursoDTO.getTemas()){
                Tema temaAGuardar = this.temaRepo.save(nuevoTema);
                listaTemas.add(temaAGuardar);
            }
        }
        cursoEditado.setTemas(listaTemas);
        this.saveCurso(cursoEditado);
    }


}
