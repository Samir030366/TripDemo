package com.example.proymvc01.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.example.proymvc01.model.Trip;
import com.example.proymvc01.repository.ITripRepository;
import com.example.proymvc01.service.ITripService;

@Service
@Primary
public class TripServiceJpa implements ITripService {

    @Autowired
    private ITripRepository tripRepository;

    @Override
    public List<Trip> buscarTodos() {
        return tripRepository.findAll();
    }

    @Override
    public Trip buscarPorId(Integer idTrip) {
    	Optional<Trip> optional
    	= tripRepository.findById(idTrip);
    	if (optional.isPresent())
    		return optional.get();
    	else
    		return null;
    }

    @Override
    public void guardar(Trip trip) {
        tripRepository.save(trip);
    }

	public void eliminar(Integer idTrip) {
		tripRepository.deleteById(idTrip);		
	}
}