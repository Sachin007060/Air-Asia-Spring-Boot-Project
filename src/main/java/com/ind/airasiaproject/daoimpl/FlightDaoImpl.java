package com.ind.airasiaproject.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ind.airasiaproject.dao.FlightDao;
import com.ind.airasiaproject.dto.Flight;
import com.ind.airasiaproject.repository.FlightRepository;

@Repository
public class FlightDaoImpl implements FlightDao{
	
	@Autowired
	private FlightRepository flightRepository;

	@Override
	public Flight saveFlightDetailsDao(Flight flight) {
		return flightRepository.save(flight);
	}

}
