package com.petshop.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "estoque")
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long quantidade;
    private Calendar data_entrada;
    private Long nota_de_entrada;
    private Double valor_de_entrada;

    @OneToMany
    @JoinColumn(name = "fk_produtos_id")
    private List<Produto> produto = new ArrayList<>();

    public Estoque(Long quantidade, Calendar data_entrada, Long nota_de_entrada, Double valor_de_entrada) {
        this.quantidade = quantidade;
        this.data_entrada = data_entrada;
        this.nota_de_entrada = nota_de_entrada;
        this.valor_de_entrada = valor_de_entrada;
    }

    public Estoque() {
    }

    public Long Quantidade() {
        return quantidade;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public Calendar getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(Calendar data_entrada) {
        this.data_entrada = data_entrada;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNota_de_entrada() {
        return nota_de_entrada;
    }

    public void setNota_de_entrada(Long nota_de_entrada) {
        this.nota_de_entrada = nota_de_entrada;
    }

    public Double getValor_de_entrada() {
        return valor_de_entrada;
    }

    public void setValor_de_entrada(Double valor_de_entrada) {
        this.valor_de_entrada = valor_de_entrada;
    }

    public List<Produto> getProduto() {
        return produto;
    }

    public void setProduto(List<Produto> produto) {
        this.produto = produto;
    }

}