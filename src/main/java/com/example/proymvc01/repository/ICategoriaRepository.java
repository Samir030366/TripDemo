package com.example.proymvc01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.proymvc01.model.Categoria;

public interface ICategoriaRepository extends JpaRepository<Categoria, Integer> {
}