package com.petshop.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.model.FormaDePagamento;
import com.petshop.repository.FormaDePagamentoRepository;

import jakarta.persistence.EntityNotFoundException;


@Service
public class FormaDePagamentoService {

    @Autowired
    private FormaDePagamentoRepository formasDePagamentoRepository;


    public List<FormaDePagamento> buscarTodasAsFormasDePagamento() {
        return formasDePagamentoRepository.findAll();
    }

    public void salvarFormaDePagamento(FormaDePagamento formaDePagamento) {
        formasDePagamentoRepository.save(formaDePagamento);
    }

   
    public FormaDePagamento buscarPorId(Long id) {
        return formasDePagamentoRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Forma de pagamento não encontrada com ID: " + id));
    }
    
    public void excluirFormaDePagamentoPorId(Long id) {
        formasDePagamentoRepository.deleteById(id);
    }

    
    public FormaDePagamento atualizarFormaDePagamento(FormaDePagamento formaDePagamento) {
        if (formaDePagamento.getId() != null) {
            return formasDePagamentoRepository.save(formaDePagamento);
        }
        return null;
    }

  

    
}
