package com.ind.airasiaproject.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ind.airasiaproject.dao.FlightDao;
import com.ind.airasiaproject.dto.Flight;
import com.ind.airasiaproject.response.ApplicationResponse;
import com.ind.airasiaproject.service.FlightService;

import jakarta.servlet.http.HttpSession;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightDao flightDao;

	@Autowired
	private ApplicationResponse<Flight> applicationResponse;

	@Autowired
	private ApplicationResponse<List<Flight>> response;

	@Autowired
	private HttpSession httpSession;

	@Override
	public ApplicationResponse<Flight> saveFlightDetailsService(Flight flight) {

		if (httpSession.getAttribute("admin") != null) {

			Flight flight1 = flightDao.saveFlightDetailsDao(flight);

			if (flight1 != null) {
				applicationResponse.setStatusCode(HttpStatus.ACCEPTED.value());
				applicationResponse.setMessage("Flight--Details--Added");
				applicationResponse.setDescription("You can follow below data what is addeded inside table");
				applicationResponse.setData(flight1);
				return applicationResponse;
			} else {
				applicationResponse.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
				applicationResponse.setMessage("You are logged in with admin");
				applicationResponse.setDescription("But there might be problem with database or json file..");
				applicationResponse.setData(null);
				return applicationResponse;
			}

		} else {

			applicationResponse.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			applicationResponse.setMessage("You are not logged in with admin");
			applicationResponse
					.setDescription("Please logged in with admin and then add flight details inside table..");
			applicationResponse.setData(null);
			return applicationResponse;

		}
	}

	@Override
	public ApplicationResponse<List<Flight>> getFlightWithSourceAndDestinationService(String source,
			String destination) {
		List<Flight> flights = flightDao.getFlightWithSourceAndDestinationDao(source, destination);

		if (httpSession.getAttribute("userSession") != null) {
			if (!flights.isEmpty()) {
				response.setStatusCode(HttpStatus.FOUND.value());
				response.setMessage(source+" to "+destination);
				response.setDescription("Given source to destination flight are");
				response.setData(flights);
				return response;
			} else {
				response.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
				response.setMessage("There are no flight avilable on this source and destination");
				response.setDescription("Please search again with another source and destination");
				response.setData(null);
				return response;
			}
		} else {
				response.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
				response.setMessage("User not logged in..");
				response.setDescription("Please logged in with user credentials");
				response.setData(null);
				return response;
		}
	}

	
}
