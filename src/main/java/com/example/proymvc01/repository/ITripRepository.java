package com.example.proymvc01.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.proymvc01.model.Trip;

public interface ITripRepository extends JpaRepository<Trip, Integer> {

    List<Trip> findByEstatus(String estatus);
}