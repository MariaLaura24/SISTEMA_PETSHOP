package com.petshop.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "vendas")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long quantidade;
    private Long cliente_id;
    private Long animais_id;
    private Long vendedores_id;
    private Long pedido_id;
    private Long produto_id;

    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "fk_animais_id")
    // private List<Animal> animal = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produto_id")
    private List<Produto> produto = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id")
    private List<Pedido> pedido = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private List<Cliente> cliente = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendedores_id")
    private List<Vendedor> vendedor = new ArrayList<>();

    public List<Pedido> getPedido() {
        return pedido;
    }

    public void setPedido(List<Pedido> pedido) {
        this.pedido = pedido;
    }

    public List<Cliente> getCliente() {
        return cliente;
    }

    public void setCliente(List<Cliente> cliente) {
        this.cliente = cliente;
    }

    public List<Vendedor> getVendedor() {
        return vendedor;
    }

    public void setVendedor(List<Vendedor> vendedor) {
        this.vendedor = vendedor;
    }

    public List<Produto> getProduto() {
        return produto;
    }

    public void setProduto(List<Produto> produto) {
        this.produto = produto;
    }

    public Long getId() {
        return id;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public Long getCliente_id() {
        return cliente_id;
    }

    public Long getAnimais_id() {
        return animais_id;
    }

    public Long getVendedores_id() {
        return vendedores_id;
    }

    public Long getPedido_id() {
        return pedido_id;
    }

    public Long getProduto_id() {
        return produto_id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public void setCliente_id(Long cliente_id) {
        this.cliente_id = cliente_id;
    }

    public void setAnimais_id(Long animais_id) {
        this.animais_id = animais_id;
    }

    public void setVendedores_id(Long vendedores_id) {
        this.vendedores_id = vendedores_id;
    }

    public void setPedido_id(Long pedido_id) {
        this.pedido_id = pedido_id;
    }

    public void setProduto_id(Long produto_id) {
        this.produto_id = produto_id;
    }

    public Venda() {
    }

    public Venda(Long id, Long quantidade, Long cliente_id, Long animais_id, Long vendedores_id, Long pedido_id,
            Long produto_id) {
        this.id = id;
        this.quantidade = quantidade;
        this.cliente_id = cliente_id;
        this.animais_id = animais_id;
        this.vendedores_id = vendedores_id;
        this.pedido_id = pedido_id;
        this.produto_id = produto_id;
    }

}