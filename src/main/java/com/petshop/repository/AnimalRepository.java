package com.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petshop.model.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
}