package com.colibridge.api.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.colibridge.api.reservation.common.ManageHeader;
import com.colibridge.api.reservation.common.ReservationConstants;
import com.colibridge.api.reservation.model.ReservationEntity;
import com.colibridge.api.reservation.response.CheckReservationResponseView;
import com.colibridge.api.reservation.response.ReservationsResponseView;
import com.colibridge.api.reservation.service.ReservationService;

/**
 * <h2>ReservationController</h2>
 * <p>
 * All methods to manage the reservations
 * </p>
 *
 * @author Luis Hernandez
 * @version 1.0
 * @since 2021-01-09
 */
@RestController
@RequestMapping(path = "/reservation")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;

	/**
	 * Find all reservations.
	 * 
	 * @return Iterable<ReservationEntity>
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ReservationsResponseView getAllReservation() {
		return reservationService.getAllReservation();
	}

	/**
	 * Consult if the dates are available.
	 * 
	 * @return Iterable<ReservationEntity>
	 */
	@RequestMapping(value = "/reserve/{start}/{end}", method = RequestMethod.GET)
	public CheckReservationResponseView validate(@PathVariable String start, @PathVariable String end) {
		return reservationService.checkReservationDates(start, end);
	}
}
