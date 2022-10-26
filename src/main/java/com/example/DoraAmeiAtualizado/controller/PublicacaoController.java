package com.example.DoraAmeiAtualizado.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.DoraAmeiAtualizado.model.Publicacao;
import com.example.DoraAmeiAtualizado.service.CodepubliService;

@Controller
public class PublicacaoController {

    @Autowired
    CodepubliService codepubliService;

    @RequestMapping(value = "/publicacoes", method = RequestMethod.GET)
    public ModelAndView getPublicacoes() {
        ModelAndView mv = new ModelAndView("publicacoes");
        List<Publicacao> publicacoes = codepubliService.findAll();
        mv.addObject("publicacoes", publicacoes);
        return mv;
    }

    @RequestMapping(value = "/publicacoes/{id}", method = RequestMethod.GET)
    public ModelAndView getPublicaDetails(@PathVariable("id") long id) {
        ModelAndView mv = new ModelAndView("publicaDetails");
        Publicacao publicacao = codepubliService.findById(id);
        mv.addObject("publicacao", publicacao);
        return mv;
    }

    @RequestMapping(value = "/newpubli", method = RequestMethod.GET)
    public String getPubliForm() {
        return "publiForm";
    }

    @RequestMapping(value = "/newpubli", method = RequestMethod.POST)
    public String savePubli(@Valid Publicacao publicacao, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "redirect:/newpubli";
        }
        publicacao.setData(LocalDate.now());
        codepubliService.save(publicacao);
        return "redirect:/publicacoes";
    }

}
