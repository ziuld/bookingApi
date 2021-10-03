package com.colibridge.api.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.colibridge.api.reservation.common.ManageError;
import com.colibridge.api.reservation.common.ManageHeader;
import com.colibridge.api.reservation.common.ReservationConstants;
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
		ReservationsResponseView response = new ReservationsResponseView();
		ManageHeader header = new ManageHeader(ReservationConstants.SUCCESS);
		try {
			response = reservationService.getAllReservation();
		} catch (Exception e) {
			header.setResult(ReservationConstants.FAILD);
			ManageError error = new ManageError(ReservationConstants.GENERAL_ERROR_CODE,
					ReservationConstants.ERROR_REPOSITORY_DETAILL);
			response.setError(error);
		}

		response.setHeader(header);
		return response;
	}

	/**
	 * Consult if the dates are available.
	 * 
	 * @return Iterable<ReservationEntity>
	 */
	@RequestMapping(value = "/check/{start}/{end}", method = RequestMethod.GET)
	public CheckReservationResponseView validate(@PathVariable String start, @PathVariable String end) {
		CheckReservationResponseView response = new CheckReservationResponseView();
		ManageHeader header = new ManageHeader(ReservationConstants.SUCCESS);
		try {
			response = reservationService.checkReservationDates(start, end);
		} catch (Exception e) {
			header = new ManageHeader(ReservationConstants.FAILD);
			ManageError error = new ManageError(ReservationConstants.GENERAL_ERROR_CODE, e.getMessage());
			response.setError(error);
			e.printStackTrace();
		}
		response.setHeader(header);
		return response;
	}
}
