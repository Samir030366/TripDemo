package com.example.proymvc01.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.proymvc01.model.Trip;
import com.example.proymvc01.service.ICategoriaService;
import com.example.proymvc01.service.db.TripServiceJpa;

@Controller
@RequestMapping("/trips")
public class TripController {

    @Autowired
    private TripServiceJpa servicesTrip;

    @Autowired
    private ICategoriaService serviceCategoria;

    @GetMapping("/index")
    public String mostrarIndex(Model model) {
        List<Trip> lista = servicesTrip.buscarTodos();
        model.addAttribute("trips", lista);
        return "trips/listTrips";     
    }

    @GetMapping("/create")
    public String crear(Trip trip, Model model) {
        model.addAttribute("categorias", serviceCategoria.buscarTodos());
        return "trips/formTrip";
    }

    @PostMapping("/save")
    public String guardar(Trip trip, BindingResult result, RedirectAttributes flash) {
        if (result.hasErrors()) {
            return "trips/formTrip";
        }
        servicesTrip.guardar(trip);
        flash.addFlashAttribute("msg", "¡Trip guardado con éxito!");
        return "redirect:/trips/index";
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") Integer idTrip, Model model) {
        Trip trip = servicesTrip.buscarPorId(idTrip);
        model.addAttribute("trip", trip);
        model.addAttribute("categorias", serviceCategoria.buscarTodos());
        return "trips/formTrip";
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") Integer idTrip, RedirectAttributes flash) {
        servicesTrip.eliminar(idTrip); 
        flash.addFlashAttribute("msg", "¡Trip eliminado correctamente!");
        return "redirect:/trips/index";
    }
    
    
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(java.sql.Date.class, new CustomDateEditor(dateFormat, true));
    }
}