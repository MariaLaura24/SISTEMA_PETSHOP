package com.petshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.petshop.model.Estoque;
import com.petshop.services.EstoqueService;




@Controller
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    @GetMapping("/estoques")
    public String listarEstoque(Model model) {
        model.addAttribute("estoques", estoqueService.buscarTodosOsEstoques());
        return "estoques/lista";
    }

    @GetMapping("/estoques/cadastro")
    public String exibirFormularioRealizarEstoque() {
        return "estoques/cadastro";
    }

    @PostMapping("/estoques")
    public String salvarEstoque(Estoque estoque) {
        estoqueService.salvarEstoque(estoque);
        return "redirect:/estoques";
    }

    @GetMapping("/estoques/editar/{id}")
    public String editarEstoque(@PathVariable Long id, Model model) {
        Estoque estoque = estoqueService.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("estoques", estoque);
        return "estoques/editar";
    }

    @PostMapping("/estoques/editar/{id}")
    public String atualizarEstoque(@PathVariable Long id, @ModelAttribute Estoque estoqueAtualizado) {
        Estoque estoque = estoqueService.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        estoque.setId(id);
        estoqueAtualizado.getId();
        estoque.setQuantidade(id);
        estoqueAtualizado.getQuantidade();
        estoque.setData_entrada(null);
        estoqueAtualizado.getData_entrada();
        estoque.setNota_de_entrada(id);
        estoqueAtualizado.getNota_de_entrada();
        estoque.getValor_de_entrada();
        estoqueAtualizado.getValor_de_entrada();
    
        return "redirect:/estoques";
    }

    @GetMapping("/estoques/deletar/{id}")
    public String deletarEstoque(@PathVariable Long id) {
        estoqueService.excluirEstoquePorId(id);
        return "redirect:/estoques";
    }
}