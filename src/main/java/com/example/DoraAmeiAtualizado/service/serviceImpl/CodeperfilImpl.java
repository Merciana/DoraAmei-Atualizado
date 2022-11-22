package com.example.DoraAmeiAtualizado.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.DoraAmeiAtualizado.model.Publicacao;
import com.example.DoraAmeiAtualizado.repository.Repository;
import com.example.DoraAmeiAtualizado.service.CodepubliService;

public class CodeperfilImpl implements CodepubliService {

    @Autowired
    Repository repository;

    @Override
    public List<Publicacao> findAll() {
        return repository.findAll();
    }

    @Override
    public Publicacao findById(long id) {
        return repository.findById(id).get();
    }

    @Override
    public Publicacao save(Publicacao publicacao) {
        return repository.save(publicacao);
    }

}
