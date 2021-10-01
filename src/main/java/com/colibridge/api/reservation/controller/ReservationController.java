package com.colibridge.api.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.colibridge.api.reservation.model.GuestEntity;
import com.colibridge.api.reservation.model.ReservationEntity;
import com.colibridge.api.reservation.service.GuestService;
import com.colibridge.api.reservation.service.ReservationService;

@RestController
@RequestMapping(path = "/reservation")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	@Autowired
	private GuestService guestService;

	@RequestMapping(value = "/guests", method = RequestMethod.GET)
	public Iterable<GuestEntity> getAllGuests() {
		return guestService.getAllGuests();
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public Iterable<ReservationEntity> getAllReservation() {
		return reservationService.getAllReservation();
	}

}
