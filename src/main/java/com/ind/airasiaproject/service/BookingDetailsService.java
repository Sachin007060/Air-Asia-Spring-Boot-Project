package com.ind.airasiaproject.service;

import com.ind.airasiaproject.dto.BookingDetails;
import com.ind.airasiaproject.response.ApplicationResponse;

public interface BookingDetailsService {
	public ApplicationResponse<BookingDetails> bookFlightService(BookingDetails bookingDetails, String flightNumber);
}
