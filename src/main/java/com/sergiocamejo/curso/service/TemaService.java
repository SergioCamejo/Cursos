package com.sergiocamejo.curso.service;

import com.sergiocamejo.curso.dto.TemaDTO;
import com.sergiocamejo.curso.model.Tema;
import com.sergiocamejo.curso.repository.ITemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemaService implements ITemaService{

    @Autowired
    private ITemaRepository temaRepo;

    @Override
    public List<Tema> getTemas() {
        return this.temaRepo.findAll();
    }

    @Override
    public void saveTema(Tema tema) {
        this.temaRepo.save(tema);
    }

    @Override
    public void createTema(TemaDTO temaDTO) {
        Tema temaNuevo = new Tema();
        temaNuevo.setNombre(temaDTO.getNombre());
        temaNuevo.setDescripcion(temaDTO.getDescripcion());
        this.temaRepo.save(temaNuevo);
    }

    @Override
    public void deleteTema(Long id) {
        this.temaRepo.deleteById(id);
    }

    @Override
    public Tema findTema(Long id) {
        return this.temaRepo.findById(id).orElseThrow(() -> new RuntimeException("No se encontró el curso con el Id " + id));
    }

    @Override
    public void editTema(Long id, TemaDTO temaDTO) {
        Tema temaEditado = this.findTema(id);
        if (temaDTO.getNombre() != null){
            temaEditado.setNombre(temaDTO.getNombre());
        }
        if (temaDTO.getDescripcion() != null){
            temaEditado.setDescripcion(temaDTO.getDescripcion());
        }
        this.saveTema(temaEditado);
    }
}
