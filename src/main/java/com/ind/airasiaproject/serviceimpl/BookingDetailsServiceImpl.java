package com.ind.airasiaproject.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ind.airasiaproject.dao.BookingDetailsDao;
import com.ind.airasiaproject.dto.BookingDetails;
import com.ind.airasiaproject.dto.User;
import com.ind.airasiaproject.repository.UserRepository;
import com.ind.airasiaproject.response.ApplicationResponse;
import com.ind.airasiaproject.service.BookingDetailsService;

import jakarta.servlet.http.HttpSession;

@Service
public class BookingDetailsServiceImpl implements BookingDetailsService {

	@Autowired
	private BookingDetailsDao bookingDetailsDao;
	
	@Autowired
	private ApplicationResponse<BookingDetails> response;
	
	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	private UserRepository repository;
	
	@Override
	public ApplicationResponse<BookingDetails> bookFlightService(BookingDetails bookingDetails, String flightNumber) {
		
		String email =(String) httpSession.getAttribute("userSession");
		
		if(email!=null) {
			User user =repository.findByUserEmail(email);
			bookingDetails.setUser(user);
			BookingDetails bookingDetails2=bookingDetailsDao.BookFlightDao(bookingDetails, flightNumber);
			
			if(bookingDetails2!=null) {
				response.setStatusCode(HttpStatus.ACCEPTED.value());
				response.setMessage("Your ticket is successfully booked");
				response.setDescription("Ticket has been send to your email id and can find ticket details below");
				response.setData(bookingDetails2);
				return response;
			}else {
				response.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
				response.setMessage("Flight number is incorrect");
				response.setDescription("flight number is not valid please pass correct flight number");
				response.setData(bookingDetails2);
				return response;
			}
			
		}else {
			response.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			response.setMessage("You are not logged in");
			response.setDescription("Please logged in and then book your ticket");
			response.setData(null);
			return response;
		}
		
	}
	
}
