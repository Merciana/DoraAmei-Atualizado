package com.example.DoraAmeiAtualizado.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

import com.example.DoraAmeiAtualizado.model.Pessoa;
import com.example.DoraAmeiAtualizado.service.CodepessoaService;

@Controller
public class PessoaController {

    @Autowired
    CodepessoaService codepessoaService;

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        Pessoa pes = new Pessoa();
        model.addAttribute("pessoa", pes);
        return "login";
    }

    @RequestMapping(value = "/pessoa", method = RequestMethod.POST)
    public String Pessoa(@ModelAttribute @Valid Pessoa pessoa, BindingResult result,
            RedirectAttributes attributes) {

        System.out.println("entrou na validação de lgin");

        Optional<Pessoa> pessoaBanco = codepessoaService.findByUsername(pessoa.getUsername());

        System.out.println("Pessoa:" + pessoa.getUsername() + pessoa.getPassword());

        if (pessoaBanco.isPresent()) {
            System.out.println("PessoaBanco:" + pessoaBanco.get().getUsername() + pessoaBanco.get().getPassword());

            if (pessoaBanco.get().getPassword().equals(pessoa.getPassword())) {
                return "redirect:/publicacoes";
            }
        }

        System.out.println("login teve erroes");
        attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
        return "redirect:/login";

    }

    @RequestMapping(value = "/buscarpessoa", method = RequestMethod.GET)
    public ModelAndView getBuscar(Model model) {
        ModelAndView mvb = new ModelAndView("buscar");
        List<Pessoa> pessoa = codepessoaService.findAll();
        mvb.addObject("pessoa", pessoa);
        return mvb;
    }

    @GetMapping("/cadastro")
    public String cadastro(Model model) {
        Pessoa pe = new Pessoa();
        model.addAttribute("pessoa", pe);
        return "cadastro";
    }

    /*
     * @RequestMapping(value = "/newpessoa", method = RequestMethod.GET)
     * public String getPessoaCadastro(Model model) {
     * Pessoa pe = new Pessoa();
     * model.addAttribute("pessoa", pe);
     * System.out.println("getPessoaCadastro(), entrou no metodo que nao tem nada");
     * return "/login";
     * }
     */

    @RequestMapping(value = "/newpessoa", method = RequestMethod.POST)
    public String savePessoa(@ModelAttribute @Valid Pessoa pessoa, BindingResult result,
            RedirectAttributes attributes) {

        System.out.println("Entrou no método com varios parametros");

        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
            return "redirect:/cadastro";
        }
        codepessoaService.save(pessoa);
        return "redirect:/login";
    }

}
