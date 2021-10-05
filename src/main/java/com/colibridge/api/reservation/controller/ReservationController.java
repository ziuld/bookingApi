package com.colibridge.api.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.colibridge.api.reservation.common.ManageError;
import com.colibridge.api.reservation.common.ManageHeader;
import com.colibridge.api.reservation.common.ReservationConstants;
import com.colibridge.api.reservation.request.ReservationDetailRequestView;
import com.colibridge.api.reservation.request.ReservationNewGuestDetailRequestView;
import com.colibridge.api.reservation.request.ReservationUpdateDetailRequestView;
import com.colibridge.api.reservation.response.CheckReservationResponseView;
import com.colibridge.api.reservation.response.ReservationDetailResponseView;
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
	// ReservationController parameters
	@Autowired
	private ReservationService reservationService;

	/**
	 * default constructor
	 */
	public ReservationController() {
		// default
	}

	/**
	 * Find all reservations.
	 * 
	 * @return ReservationsResponseView
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
	 * Find a reservation.
	 * 
	 * @return ReservationDetailResponseView
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ReservationDetailResponseView getReservation(@PathVariable int id) {
		ReservationDetailResponseView response = new ReservationDetailResponseView();
		ManageHeader header = new ManageHeader(ReservationConstants.SUCCESS);
		try {
			response = reservationService.getReservationById(id);
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
	 * @return CheckReservationResponseView
	 */
	@RequestMapping(value = "/check/{start}/{end}", method = RequestMethod.GET)
	public CheckReservationResponseView validate(@PathVariable String start, @PathVariable String end) {
		CheckReservationResponseView response = new CheckReservationResponseView();
		ManageHeader header;
		try {
			response = reservationService.checkReservationDates(start, end);
		} catch (Exception e) {
			header = new ManageHeader(ReservationConstants.FAILD);
			ManageError error = new ManageError(ReservationConstants.GENERAL_ERROR_CODE, e.getMessage());
			response.setHeader(header);
			response.setError(error);
			e.printStackTrace();
		}
		return response;
	}

	/**
	 * Create reservation from an existing guest
	 * 
	 * @return ReservationDetailResponseView
	 */
	@PostMapping(value = "/create")
	public ReservationDetailResponseView createReservationFromAnExistingUser(
			@RequestBody ReservationDetailRequestView request) {
		ReservationDetailResponseView response = new ReservationDetailResponseView();
		try {
			response = reservationService.createReservationFromAnExistingUser(request);
		} catch (Exception e) {
			ManageHeader header = new ManageHeader(ReservationConstants.FAILD);
			ManageError error = new ManageError(ReservationConstants.GENERAL_ERROR_CODE, e.getMessage());
			response.setHeader(header);
			response.setError(error);
			e.printStackTrace();
		}
		return response;
	}

	/**
	 * Create reservation from an existing guest
	 * 
	 * @return ReservationDetailResponseView
	 */
	@PostMapping(value = "/create-new-guest")
	public ReservationDetailResponseView createReservationForNewUser(
			@RequestBody ReservationNewGuestDetailRequestView request) {
		ReservationDetailResponseView response = new ReservationDetailResponseView();
		try {
			response = reservationService.createReservationForNewUser(request);
		} catch (Exception e) {
			ManageHeader header = new ManageHeader(ReservationConstants.FAILD);
			ManageError error = new ManageError(ReservationConstants.GENERAL_ERROR_CODE, e.getMessage());
			response.setHeader(header);
			response.setError(error);
			e.printStackTrace();
		}
		return response;
	}

	/**
	 * delete a reservation
	 * 
	 * @param id
	 * @return ReservationDetailResponseView
	 */
	@DeleteMapping(value = "/delete/{id}")
	public ReservationDetailResponseView deleteReservation(@PathVariable int id) {
		ReservationDetailResponseView response = new ReservationDetailResponseView();
		ManageHeader header = new ManageHeader(ReservationConstants.SUCCESS);
		try {
			response = reservationService.deleteById(id);
		} catch (Exception e) {
			header = new ManageHeader(ReservationConstants.FAILD);
			ManageError error = new ManageError(ReservationConstants.GENERAL_ERROR_CODE, e.getMessage());
			response.setError(error);
			e.printStackTrace();
		}
		response.setHeader(header);
		return response;
	}

	/**
	 * Update a reservaton
	 * 
	 * @param request
	 * @return ReservationDetailResponseView
	 */
	@PutMapping(value = "/update")
	public ReservationDetailResponseView updateReservation(@RequestBody ReservationUpdateDetailRequestView request) {
		ReservationDetailResponseView response = new ReservationDetailResponseView();
		try {
			response = reservationService.updateReservation(request);
		} catch (Exception e) {
			ManageHeader header = new ManageHeader(ReservationConstants.FAILD);
			ManageError error = new ManageError(ReservationConstants.GENERAL_ERROR_CODE, e.getMessage());
			response.setError(error);
			response.setHeader(header);
			e.printStackTrace();
		}
		return response;
	}
}
