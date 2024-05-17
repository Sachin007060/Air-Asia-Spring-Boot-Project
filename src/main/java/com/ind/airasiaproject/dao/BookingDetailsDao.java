package com.ind.airasiaproject.dao;

import com.ind.airasiaproject.dto.BookingDetails;

public interface BookingDetailsDao {
	public BookingDetails BookFlightDao(BookingDetails bookingDetails, String flightNumber);
}
