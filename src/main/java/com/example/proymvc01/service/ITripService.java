package com.example.proymvc01.service;

import java.util.List;
import com.example.proymvc01.model.Trip;

public interface ITripService {
    List<Trip> buscarTodos();
    Trip buscarPorId(Integer idTrip); 
    
    void guardar(Trip trip);
}