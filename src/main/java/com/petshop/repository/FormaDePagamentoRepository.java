package com.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petshop.model.FormaDePagamento;


@Repository
public interface FormaDePagamentoRepository extends JpaRepository<FormaDePagamento, Long>{}

