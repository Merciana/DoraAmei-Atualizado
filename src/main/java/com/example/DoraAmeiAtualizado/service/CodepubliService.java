package com.example.DoraAmeiAtualizado.service;

import com.example.DoraAmeiAtualizado.model.Publicacao;

import java.util.List;

public interface CodepubliService {

    List<Publicacao> findAll();

    Publicacao findById(long id);

    Publicacao save(Publicacao publicacao);

}
