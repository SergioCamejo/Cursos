package com.sergiocamejo.curso.controller;

import com.sergiocamejo.curso.dto.CursoDTO;
import com.sergiocamejo.curso.model.Curso;
import com.sergiocamejo.curso.repository.ICursoRepository;
import com.sergiocamejo.curso.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private ICursoService cursoServ;

    @GetMapping("/traer")
    public List<Curso> getCursos(){
        return this.cursoServ.getCursos();
    }

    @PostMapping("/crear")
    public void createCurso(@RequestBody CursoDTO cursoDTO){
        this.cursoServ.createCurso(cursoDTO);
    }

    @PutMapping("/editar/{id}")
    public void edirCurso(@PathVariable Long id, @RequestBody CursoDTO cursoDTO){
        this.cursoServ.editCurso(id,cursoDTO);
    }

    @DeleteMapping("/borrar/{id}")
    public void deleteCurso(@PathVariable Long id){
        this.cursoServ.deleteCurso(id);
    }

}
