package com.example.DoraAmeiAtualizado.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.DoraAmeiAtualizado.model.Pessoa;
import com.example.DoraAmeiAtualizado.service.serviceImpl.CodebuscarServiceImpl;

@Controller
public class BuscarController {

    CodebuscarServiceImpl service;

    public BuscarController(CodebuscarServiceImpl service) {
        this.service = service;
    }

    @RequestMapping(value = "/buscarpessoas", method = RequestMethod.GET)
    public List<Pessoa> buscar_pessoas() {
        return service.buscar_pessoas();
    }
}
