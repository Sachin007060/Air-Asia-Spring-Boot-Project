package com.ind.airasiaproject.dto;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDetails {
	@Id
	private String pnr;
	@CreationTimestamp
	private LocalDate bookingDate;
	private LocalDate journeyData;
	private String customerName;
	private String customerEmail;
	private long customerPhone;
	private String passportNumber;
	private double totalprice;
	@Column(name = "conveniencefee")
	final private double CONVENIENCEFEE=300;
	private String cancel = "yes";
	@OneToOne
	private User user;
	@OneToOne
	private Flight flight;
}
