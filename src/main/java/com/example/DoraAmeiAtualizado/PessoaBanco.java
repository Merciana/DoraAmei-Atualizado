package com.example.DoraAmeiAtualizado;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.DoraAmeiAtualizado.usuario.dominio.Pessoa;
import com.example.DoraAmeiAtualizado.usuario.dominio.PessoaRepositorio;

@Component
@Transactional
public class PessoaBanco implements CommandLineRunner {

    @Autowired
    private PessoaRepositorio pessoaRepo;

    @Override
    public void run(String... args) throws Exception {

        Pessoa p1 = new Pessoa("Merciana");
        p1.setUsername("Mercy");
        p1.setEmail("merciana@gmail.com");
        p1.setPassword(123);

        Pessoa p2 = new Pessoa("Aylane");
        p2.setUsername("Lane");
        p2.setEmail("aylane@gmail.com");
        p2.setPassword(1234);

        Pessoa p3 = new Pessoa("Ana Paula");
        p3.setUsername("Ana");
        p3.setEmail("anapaula@gmail.com");
        p3.setPassword(1235);

        Pessoa p4 = new Pessoa("Liryel");
        p4.setUsername("Li");
        p4.setEmail("liryel@gmail.com");
        p4.setPassword(123456);

        pessoaRepo.save(p1);
        pessoaRepo.save(p2);
        pessoaRepo.save(p3);
        pessoaRepo.save(p4);

    }
}
