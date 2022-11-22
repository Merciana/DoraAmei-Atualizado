package com.example.DoraAmeiAtualizado.service;

import java.util.List;
import java.util.Optional;

import com.example.DoraAmeiAtualizado.model.Pessoa;

public interface CodepessoaService {

    List<Pessoa> findAll();

    Pessoa findById(long id);

    Pessoa save(Pessoa pessoa);

    Optional<Pessoa> findByUsername(String username);

}
