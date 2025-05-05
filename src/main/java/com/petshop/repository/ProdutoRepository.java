package com.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petshop.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {}