package com.example.DoraAmeiAtualizado.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.DoraAmeiAtualizado.model.Publicacao;
import com.example.DoraAmeiAtualizado.repository.Repository;

@Component
public class DemmyData {

    @Autowired
    Repository repository;

    @PostConstruct
    public void savePublicacoes() {

        List<Publicacao> publicacaoList = new ArrayList<>();
        Publicacao publicacao1 = new Publicacao();
        publicacao1.setAutor("Merciana Gonçalves");
        publicacao1.setData(LocalDate.now());
        publicacao1.setTitulo("The descendest of sun");
        publicacao1.setTexto(
                "Romance entre uma médica de emergia e um Capitão do exercito que vive tendo missões, Maravilhoso!!");

        Publicacao publicacao2 = new Publicacao();
        publicacao2.setAutor("Merciana Gonçalves");
        publicacao2.setData(LocalDate.now());
        publicacao2.setTitulo("Cara de Lula");
        publicacao2.setTexto(
                "Ela é uma mulher que trabalha em uma locadora e ele é um treinador de uma equipe de jogadores profissionais, ele vai até a locadora para desestressar e encontra ela e para ela sendo um amor a primeira vista, ela corre atrás dele e assim começa uma aventura romântica");

        publicacaoList.add(publicacao1);
        publicacaoList.add(publicacao2);

        for (Publicacao publicacao : publicacaoList) {
            Publicacao publicacaoSaved = repository.save(publicacao);
            System.out.println(publicacaoSaved.getId());
        }
    }
}
