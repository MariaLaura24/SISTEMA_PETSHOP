package com.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petshop.model.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {}