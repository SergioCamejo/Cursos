package com.sergiocamejo.curso.service;

import com.sergiocamejo.curso.dto.TemaDTO;
import com.sergiocamejo.curso.model.Tema;
import java.util.List;

public interface ITemaService {

    public List<Tema> getTemas();
    public void saveTema(Tema tema);
    public void createTema(TemaDTO temaDTO);
    public void deleteTema(Long id);
    public Tema findTema(Long id);
    public void editTema(Long id, TemaDTO temaDTO);

}
