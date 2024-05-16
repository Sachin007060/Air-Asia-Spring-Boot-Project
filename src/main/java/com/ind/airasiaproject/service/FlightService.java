package com.ind.airasiaproject.service;

import java.util.List;

import com.ind.airasiaproject.dto.Flight;
import com.ind.airasiaproject.response.ApplicationResponse;

public interface FlightService {

	public ApplicationResponse<Flight> saveFlightDetailsService(Flight flight);

	public ApplicationResponse<List<Flight>> getFlightWithSourceAndDestinationService(String source,
			String destination);
}
