package com.sergiocamejo.curso.repository;

import com.sergiocamejo.curso.dto.CursoDTO;
import com.sergiocamejo.curso.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICursoRepository extends JpaRepository<Curso, Long> {
}
