package com.example.DoraAmeiAtualizado.service;

import java.util.List;

import com.example.DoraAmeiAtualizado.dominio.Pessoa;

public interface CodepessoaService {
    List<Pessoa> findAll();

    Pessoa findById(long id);

    Pessoa save(Pessoa pessoa);

}