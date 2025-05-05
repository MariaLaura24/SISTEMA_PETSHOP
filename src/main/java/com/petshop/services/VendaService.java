package com.petshop.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.model.Venda;
import com.petshop.repository.VendaRepository;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendasRepository;

    // Listar todas as vendas
    public List<Venda> buscarTodosAsVendas() {
        return vendasRepository.findAll();
    }

    public void salvarVendas(Venda vendas) {
        vendasRepository.save(vendas);
    }

    // Buscar uma venda por ID
    public Optional<Venda> buscarPorId(Long id) {
        return vendasRepository.findById(id);
    }

    // Deletar uma venda
    public void excluirVendasPorId(Long id) {
        vendasRepository.deleteById(id);
    }

    // Editar venda (atualizar suas informações)
    public Venda atualizarVendas(Venda vendas) {
        if (vendas.getId() != null) {
            return vendasRepository.save(vendas);  // aqui chamamos o método save acima
        }
        return null;
    }
}
