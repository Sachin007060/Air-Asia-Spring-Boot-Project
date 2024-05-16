package com.ind.airasiaproject.dao;

import java.util.List;

import com.ind.airasiaproject.dto.Flight;

public interface FlightDao {

	public Flight saveFlightDetailsDao(Flight flight);

	public List<Flight> getFlightWithSourceAndDestinationDao(String source, String destination);
}
