package com.example.proymvc01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.proymvc01.model.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
}