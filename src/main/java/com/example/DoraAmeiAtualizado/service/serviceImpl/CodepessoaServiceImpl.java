package com.example.DoraAmeiAtualizado.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DoraAmeiAtualizado.model.Pessoa;
import com.example.DoraAmeiAtualizado.repository.PessoaRepositorio;
import com.example.DoraAmeiAtualizado.service.CodepessoaService;

@Service
public class CodepessoaServiceImpl implements CodepessoaService {

    @Autowired
    PessoaRepositorio repositorio;

    @Override
    public List<Pessoa> findAll() {
        return repositorio.findAll();
    }

    @Override
    public Optional<Pessoa> findByUsername(String username) {
        return repositorio.findByUsername(username);
    }

    @Override
    public Pessoa findById(long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public Pessoa save(Pessoa pessoa) {
        return repositorio.save(pessoa);
    }

}
