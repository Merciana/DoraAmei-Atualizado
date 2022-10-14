package com.example.DoraAmeiAtualizado.usuario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.DoraAmeiAtualizado.usuario.dominio.PessoaRepositorio;

@Controller
public class PessoaController {

    private PessoaRepositorio pessoaRepo;

    public PessoaController(PessoaRepositorio pessoaRepo) {
        this.pessoaRepo = pessoaRepo;
    }

    @GetMapping("/templates/pessoas")
    public String pessoas(Model model) {

        model.addAttribute("listaPessoas", pessoaRepo.findAll());
        return "/pessoas/index";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/Principal")
    public String publicar() {
        return "Principal";
    }

    @GetMapping("/Cadastro")
    public String cadastro() {
        return "Cadastro";
    }

}
