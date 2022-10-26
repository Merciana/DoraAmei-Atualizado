package com.example.DoraAmeiAtualizado.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.DoraAmeiAtualizado.dominio.Pessoa;

@Controller
public class PessoaController {

    @PostMapping(value = "/salvar")
    public ResponseEntity<String> salvar(@RequestBody @Valid Pessoa pessoa) {

        return ResponseEntity.ok("");
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/principal")
    public String publicar() {
        return "principal";
    }

    @GetMapping("/cadastro")
    public String cadastro() {
        return "cadastro";
    }

}
