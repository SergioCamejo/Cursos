package com.sergiocamejo.curso.controller;

import com.sergiocamejo.curso.dto.CursoDTO;
import com.sergiocamejo.curso.dto.TemaDTO;
import com.sergiocamejo.curso.model.Curso;
import com.sergiocamejo.curso.model.Tema;
import com.sergiocamejo.curso.service.ITemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/temas")
public class TemaController {

    @Autowired
    private ITemaService temaServ;

    @GetMapping("/traer")
    public List<Tema> getTemas(){
        return this.temaServ.getTemas();
    }

    @PostMapping("/crear")
    public void createTema(@RequestBody TemaDTO temaDTO){
        this.temaServ.createTema(temaDTO);
    }

    @PutMapping("/editar/{id}")
    public void edirtema(@PathVariable Long id, @RequestBody TemaDTO temaDTO){
        this.temaServ.editTema(id, temaDTO);
    }

    @DeleteMapping("/borrar/{id}")
    public void deleteTema(@PathVariable Long id){
        this.temaServ.deleteTema(id);
    }


}
