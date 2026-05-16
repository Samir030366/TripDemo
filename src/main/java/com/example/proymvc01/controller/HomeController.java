package com.example.proymvc01.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.proymvc01.model.Trip;
import com.example.proymvc01.service.ITripService;

@Controller
public class HomeController {

    @Autowired
    private ITripService tripService;

    // Método para mostrar detalle 
    public String mostrarDetalle(Model model) {
        Trip trip = new Trip();
        trip.setNombre("Rapel en Volcanetango");
        trip.setDescripcion("Aventura rapel en un circuito conectado en la...");
        trip.setFecha(new java.sql.Date(System.currentTimeMillis()));
        trip.setCosto(10.0);

        model.addAttribute("trip", trip);

        return "tabla";
    }

    // Método para mostrar la tabla (usando el servicio inyectado)
    @GetMapping("/")
    public String mostrarTabla(Model model) {
        List<Trip> lista = tripService.buscarTodos();
        model.addAttribute("trips", lista);
        return "home";
    }
}