package com.example.DoraAmeiAtualizado.dominio;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepositorio extends JpaRepository<Pessoa, Long> {
    List<Pessoa> findByNome(String nome);
}
