package com.example.proymvc01.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.example.proymvc01.model.Categoria;
import com.example.proymvc01.repository.ICategoriaRepository;
import com.example.proymvc01.service.ICategoriaService;

@Service
@Primary 
public class CategoriaServicesJpa implements ICategoriaService {

    @Autowired
    private ICategoriaRepository categoriaService;

    @Override
    public List<Categoria> buscarTodos() {
        return categoriaService.findAll();
    }

    @Override
    public Categoria buscarPorId(Integer idCategoria) {
    	Optional<Categoria> optional 
    	= categoriaService.findById(idCategoria);
    	if (optional.isPresent())
    		return optional.get();
    	else
    		return null;
    }

    @Override
    public void guardar(Categoria categoria) {
        categoriaService.save(categoria);
   
}

	@Override
	public void guardar(ICategoriaService categoria) {
		// TODO Auto-generated method stub
		
	}

}