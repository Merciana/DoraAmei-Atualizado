package com.example.DoraAmeiAtualizado.utils;

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

        for (Publicacao publicacao : publicacaoList) {
            Publicacao publicacaoSaved = repository.save(publicacao);
            System.out.println(publicacaoSaved.getId());
        }
    }
}
