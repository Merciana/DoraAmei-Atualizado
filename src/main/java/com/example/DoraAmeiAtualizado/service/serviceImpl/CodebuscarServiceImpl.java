package com.example.DoraAmeiAtualizado.service.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.DoraAmeiAtualizado.model.Pessoa;
import com.example.DoraAmeiAtualizado.repository.PessoaRepositorio;

@Service
public class CodebuscarServiceImpl {

    PessoaRepositorio repositorio;

    public CodebuscarServiceImpl(PessoaRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List<Pessoa> buscar_pessoas() {
        return repositorio.findAll();
    }

}
