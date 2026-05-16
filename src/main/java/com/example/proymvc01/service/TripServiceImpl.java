package com.example.proymvc01.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.proymvc01.model.Trip;
import com.example.proymvc01.repository.ITripRepository;

@Service
public class TripServiceImpl implements ITripService {

    @Autowired
    private ITripRepository tripRepository;

    @Override
    public List<Trip> buscarTodos() {
        return tripRepository.findAll();
    }

    @Override
    public Trip buscarPorId(Integer idTrip) {
        return tripRepository.findById(idTrip).orElse(null);
    }

    @Override
    public void guardar(Trip trip) {
        tripRepository.save(trip);
    }
}