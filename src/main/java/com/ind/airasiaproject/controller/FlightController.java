package com.ind.airasiaproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ind.airasiaproject.dto.Flight;
import com.ind.airasiaproject.response.ApplicationResponse;
import com.ind.airasiaproject.service.FlightService;

@RestController
@RequestMapping("/flight")
public class FlightController {

	@Autowired
	private FlightService flightService;

	@PostMapping("/saveFlightDetails")
	public ApplicationResponse<Flight> saveFlightDetailsContoller(@RequestBody Flight flight) {
		return flightService.saveFlightDetailsService(flight);
	}
	
	@GetMapping("/getFlightSourceAndDestinationDetails/{source}/{destination}")
	public ApplicationResponse<List<Flight>> getFlightWithSourceAndDestinationService(@PathVariable String source,
			@PathVariable String destination) {
		return flightService.getFlightWithSourceAndDestinationService(source, destination);
	}

}
