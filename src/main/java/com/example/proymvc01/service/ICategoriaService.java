package com.example.proymvc01.service;

import java.util.List;
import com.example.proymvc01.model.Categoria;

public interface ICategoriaService {
	
    
    List<Categoria> buscarTodos();
    
    Categoria buscarPorId(Integer idCategoria);
    
    void guardar(ICategoriaService categoria);

	void guardar(Categoria categoria);
}