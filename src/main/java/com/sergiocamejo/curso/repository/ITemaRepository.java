package com.sergiocamejo.curso.repository;

import com.sergiocamejo.curso.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITemaRepository extends JpaRepository<Tema, Long> {
}
