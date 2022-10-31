package com.example.DoraAmeiAtualizado.controller;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.DoraAmeiAtualizado.dominio.Pessoa;
import com.example.DoraAmeiAtualizado.service.CodepessoaService;

@Controller
public class PessoaController {

    CodepessoaService codepessoaService;

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/cadastro")
    public String cadastro() {
        return "cadastro";
    }

    @RequestMapping(value = "/newpessoa", method = RequestMethod.GET)
    public String getPessoaCadastro(Model model) {
        Pessoa pe = new Pessoa();
        model.addAttribute("pessoa", pe);
        System.out.println("getPessoaCadastro(), entrou no metodo que nao tem nada");
        return "/login";
    }

    @RequestMapping(value = "/newpessoa", method = RequestMethod.POST)
    public String savePessoa(@ModelAttribute @Valid Pessoa pessoa, BindingResult result,
            RedirectAttributes attributes) {

        System.out.println("Entrou no método com varios parametros");

        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
            return "redirect:/newpessoa";
        }
        codepessoaService.save(pessoa);
        return "redirect:/login";
    }

}
