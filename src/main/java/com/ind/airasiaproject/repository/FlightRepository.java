package com.ind.airasiaproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ind.airasiaproject.dto.Flight;

public interface FlightRepository extends JpaRepository<Flight, String>{
	
	public Flight findByFlightNumber(String flightNumber);
	
}
