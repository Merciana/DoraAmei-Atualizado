package com.example.DoraAmeiAtualizado.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.DoraAmeiAtualizado.model.Pessoa;

public interface PessoaRepositorio extends JpaRepository<Pessoa, Long> {
    List<Pessoa> findByNome(String nome);

    Optional<Pessoa> findByUsername(String username);
}
