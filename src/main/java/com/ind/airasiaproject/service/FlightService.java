package com.ind.airasiaproject.service;

import com.ind.airasiaproject.dto.Flight;
import com.ind.airasiaproject.response.ApplicationResponse;

public interface FlightService {

	public ApplicationResponse<Flight> saveFlightDetailsService(Flight flight);
	
}
