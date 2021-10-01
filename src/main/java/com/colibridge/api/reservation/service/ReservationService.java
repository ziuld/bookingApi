package com.colibridge.api.reservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colibridge.api.reservation.model.ReservationEntity;
import com.colibridge.api.reservation.repository.ReservationRepository;

@Service
public class ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;

	public Iterable<ReservationEntity> getAllReservation() {
		return reservationRepository.findAll();
	}

}
