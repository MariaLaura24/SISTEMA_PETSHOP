package com.petshop.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petshop.model.Estoque;
import com.petshop.repository.EstoqueRepository;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    // Listar todos os estoques
    public List<Estoque> buscarTodosOsEstoque() {
        return estoqueRepository.findAll();
    }

    public void salvarEstoque(Estoque estoque) {
        estoqueRepository.save(estoque);
    }

    // Buscar um estoque por ID
    public Optional<Estoque> buscarPorId(Long id) {
        return estoqueRepository.findById(id);
    }

    // Deletar um estoque
    public void excluirEstoquePorId(Long id) {
        estoqueRepository.deleteById(id);
    }

    // Editar estoque (atualizar suas informações)
    public Estoque atualizarEstoque(Estoque estoque) {
        if (estoque.getId() != null) {
            return estoqueRepository.save(estoque);  // aqui chamamos o método save acima
        }
        return null;
    }

    public Object buscarTodosOsEstoques() {
        return estoqueRepository.findAll();
    }
}