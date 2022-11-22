package com.example.DoraAmeiAtualizado.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.DoraAmeiAtualizado.model.Pessoa;
import com.example.DoraAmeiAtualizado.service.serviceImpl.CodebuscarServiceImpl;

@Controller
public class BuscarController {

    CodebuscarServiceImpl service;

    public BuscarController(CodebuscarServiceImpl service) {
        this.service = service;
    }

    @RequestMapping(value = "/buscarpessoas", method = RequestMethod.GET)
    public String buscar_pessoas(@RequestParam(name = "busca") String busca) {
        System.out.println(busca);

        List<Pessoa> pessoas = service.buscar_pessoas();
        for (Pessoa p : pessoas) {
            System.out.println(p.getNome());
        }

        return "perfil";
        // return service.buscar_pessoas();
    }
}
