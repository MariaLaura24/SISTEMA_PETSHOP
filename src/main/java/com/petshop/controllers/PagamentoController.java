package com.petshop.controllers;

import java.util.List;
import com.petshop.services.PedidoService;
import com.petshop.services.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.petshop.model.Pagamento;
import com.petshop.services.FormaDePagamentoService;
import com.petshop.services.PagamentoService;

@Controller
public class PagamentoController {

    private final VendaService vendaService;

    private final PedidoService pedidoService;

    @Autowired
    private PagamentoService pagamentoService;

    @Autowired
    private FormaDePagamentoService formaDePagamentoService;

    PagamentoController(PedidoService pedidoService, VendaService vendaService) {
        this.pedidoService = pedidoService;
        this.vendaService = vendaService;
    }

    @GetMapping("/pagamentos")
    public String listarPagamento(Model model) {

        List<Pagamento> pagamentos = pagamentoService.buscarTodosOsPagamentos();

        model.addAttribute("pagamentos", pagamentos);

        return "pagamentos/lista";
    }

    @GetMapping("/pagamentos/pedido/{id}")
    public String pagar(@PathVariable Long id, Model model) {
        model.addAttribute("formasdepagamentos", formaDePagamentoService.buscarTodasAsFormasDePagamento());
        model.addAttribute("pedido", pedidoService.buscarPorId(id));
        model.addAttribute("vendas", vendaService.buscarTodosAsVendas());
        return "redirect:/pagamentos/cadastro";
    }

    @GetMapping("/pagamentos/realizar")
    public String exibirFormularioRealizarPagamento() {
        return "pagamentos/realizar";
    }

    @PostMapping("/pagamentos")
    public String salvarPagamento(Pagamento pagamento) {
        pagamentoService.salvarPagamento(pagamento);
        return "redirect:/pagamentos";
    }

    @GetMapping("/pagamentos/editar/{id}")
    public String editarPagamento(@PathVariable Long id, Model model) {
        Pagamento pagamento = pagamentoService.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("pagamentos", pagamento);
        return "pagamentos/editar";
    }

    @PostMapping("/pagamentos/editar/{id}")
    public String atualizarPagamento(@PathVariable Long id, @ModelAttribute Pagamento pagamentoAtualizado) {
        Pagamento pagamento = pagamentoService.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        pagamento.setId(id);
        pagamentoAtualizado.getId();
        pagamento.setValor_pago(null);
        pagamentoAtualizado.getValor_pago();

        return "redirect:/pagamentos";
    }

    @GetMapping("/pagamentos/deletar/{id}")
    public String deletarPagamento(@PathVariable Long id) {
        pagamentoService.excluirPagamentoPorId(id);
        return "redirect:/pagamentos";
    }

}
