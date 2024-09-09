package com.sergiocamejo.curso.service;

import com.sergiocamejo.curso.repository.ITemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemaService implements ITemaService{

    @Autowired
    private ITemaRepository temaRepo;

}
