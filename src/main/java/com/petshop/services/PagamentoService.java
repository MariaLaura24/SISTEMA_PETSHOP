package com.petshop.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.model.Pagamento;
import com.petshop.repository.PagamentoRepository;


@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    // Listar todos os pagamentos
    public List<Pagamento> buscarTodosOsPagamento() {
        return pagamentoRepository.findAll();
    }

    public void salvarPagamento(Pagamento pagamento) {
        pagamentoRepository.save(pagamento);
    }

    // Buscar um pagamento por ID
    public Optional<Pagamento> buscarPorId(Long id) {
        return pagamentoRepository.findById(id);
    }

    // Deletar um pagamento
    public void excluirPagamentoPorId(Long id) {
        pagamentoRepository.deleteById(id);
    }

    // Editar pagamento (atualizar suas informações)
    public Pagamento atualizarPagamento(Pagamento pagamento) {
        if (pagamento.getId() != null) {
            return pagamentoRepository.save(pagamento);  // aqui chamamos o método save acima
        }
        return null;
    }

    public Object buscarTodosOsPagamentos() {
        return pagamentoRepository.findAll();
    }
}
