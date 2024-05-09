package com.ind.airasiaproject.serviceimpl;

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
			applicationResponse.setDescription("Please logged in with admin and then add flight details inside table..");
			applicationResponse.setData(null);
			return applicationResponse;

		}
	}
}
