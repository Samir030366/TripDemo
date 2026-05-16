package com.example.proymvc01.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.proymvc01.model.Categoria;
import com.example.proymvc01.service.ICategoriaService;

@Controller
@RequestMapping(value="/categorias")
public class CategoriaTripController {

	@Autowired
	private ICategoriaService serviceCategoria;

	@GetMapping("/index")
	public String mostrarIndex(Model model)	{
		List<Categoria> lista = serviceCategoria.buscarTodos();
		model.addAttribute("categorias", lista);
		return "categoriasTrip/listCategoria";
	}
	
	@GetMapping("/create")
	public String crear(Model model) {        
	    
	    model.addAttribute("categoria", new Categoria());

	    return "categoriasTrip/formCategoria";
	}
	
	@PostMapping("/save")
	public String guardar (Categoria categoria, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			for (ObjectError error: result.getAllErrors()) {
				System.out.println(error.getDefaultMessage());
			}
			
			return "trips/formCategoria";
		}
		
		System.out.println("Objeto Categoria: " + categoria);
		serviceCategoria.guardar(categoria);
		attributes.addFlashAttribute("msg", "Registro Guardado");
		
		return "redirect:/categorias/index";
	}

}