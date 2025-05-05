package com.petshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.petshop.model.FormaDePagamento;
import com.petshop.services.FormaDePagamentoService;





@Controller
public class FormaDePagamentoController {

    @Autowired
    private FormaDePagamentoService formaDePagamentoService;

    @GetMapping("/formasdepagamentos")
    public String listarFormasDePagamento(Model model) {
        model.addAttribute("formasdepagamentos", formaDePagamentoService.buscarTodasAsFormasDePagamento());
        return "formasdepagamentos/lista";
    }

    @GetMapping("/formasdepagamentos/cadastro")
    public String exibirFormularioRealizarFormasDePagamento() {
        return "formasdepagamentos/cadastro";
    }

    @PostMapping("/formasdepagamentos")
    public String salvarFormasDePagamento(FormaDePagamento formasDePagamento) {
        formaDePagamentoService.salvarFormaDePagamento(formasDePagamento);
        return "redirect:/formasdepagamentos";
    }

    @GetMapping("/formasdepagamentos/editar/{id}")
    public String editarFormasDePagamento(@PathVariable Long id, Model model) {
        FormaDePagamento formasDePagamento = formaDePagamentoService.buscarPorId(id);
        model.addAttribute("formasdepagamentos", formasDePagamento);
        return "formasdepagamentos/editar";
    }

    @PostMapping("/formasdepagamentos/editar/{id}")
    public String atualizarFormasDePagamento(@PathVariable Long id, @ModelAttribute FormaDePagamento formasDePagamentoAtualizado) {
        FormaDePagamento formasDePagamento = formaDePagamentoService.buscarPorId(id);
        formasDePagamento.setId(id);
        formasDePagamentoAtualizado.getId();
        formasDePagamento.setDescricao(null);
        formasDePagamentoAtualizado.getDescricao();

        return "redirect:/formasdepagamentos";
    }

    @GetMapping("/formasdepagamentos/deletar/{id}")
    public String deletarFormasDePagamento(@PathVariable Long id) {
        formaDePagamentoService.excluirFormaDePagamentoPorId(id);
        return "redirect:/formasdepagamentos";
    }

}