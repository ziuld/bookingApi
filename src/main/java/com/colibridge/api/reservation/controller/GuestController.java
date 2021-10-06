package com.colibridge.api.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.colibridge.api.reservation.common.ManageError;
import com.colibridge.api.reservation.common.ManageHeader;
import com.colibridge.api.reservation.common.ReservationConstants;
import com.colibridge.api.reservation.request.GuestDetailRequestView;
import com.colibridge.api.reservation.response.GuestDetailResponseView;
import com.colibridge.api.reservation.response.GuestsResponseView;
import com.colibridge.api.reservation.service.GuestService;

/**
 * <h2>GuestController</h2>
 * <p>
 * All methods to manage the reservations
 * </p>
 *
 * @author Luis Hernandez
 * @version 1.0
 * @since 2021-01-09
 */
@RestController
@RequestMapping(path = "/guest")
public class GuestController {
	// GuestController parameters
	@Autowired
	private GuestService guestService;

	/**
	 * default constructor
	 */
	public GuestController() {
		// default
	}

	/**
	 * Find all guest.
	 * 
	 * @return GuestResponseView
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public GuestsResponseView getAllGuests() {
		GuestsResponseView response = null;
		ManageHeader header = new ManageHeader(ReservationConstants.SUCCESS);
		try {
			response = guestService.getAllGuests();
		} catch (Exception e) {
			header.setResult(ReservationConstants.FAILD);
			ManageError error = new ManageError(ReservationConstants.GENERAL_ERROR_CODE, e.getMessage());
			response.setError(error);
		}

		response.setHeader(header);
		return response;
	}

	/**
	 * Find a guest.
	 * 
	 * @return GuestDetailResponseView
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public GuestDetailResponseView getGuest(@PathVariable int id) {
		GuestDetailResponseView response = new GuestDetailResponseView();
		ManageHeader header = new ManageHeader(ReservationConstants.SUCCESS);
		try {
			response = guestService.getGuestById(id);
		} catch (Exception e) {
			header.setResult(ReservationConstants.FAILD);
			ManageError error = new ManageError(ReservationConstants.GENERAL_ERROR_CODE, e.getMessage());
			response.setError(error);
		}

		response.setHeader(header);
		return response;
	}

	/**
	 * Find all Guests Containing the name.
	 * 
	 * @return GuestResponseView
	 */
	@RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
	public GuestsResponseView getGuestByNameContaining(@PathVariable String name) {
		GuestsResponseView response = new GuestsResponseView();
		ManageHeader header = new ManageHeader(ReservationConstants.SUCCESS);
		try {
			response = guestService.getGuestByNameContaining(name);
		} catch (Exception e) {
			header.setResult(ReservationConstants.FAILD);
			ManageError error = new ManageError(ReservationConstants.GENERAL_ERROR_CODE, e.getMessage());
			response.setError(error);
		}

		response.setHeader(header);
		return response;
	}

	/**
	 * Create reservation from an existing guest
	 * 
	 * @return ReservationDetailResponseView
	 */
	@PostMapping(value = "/create")
	public GuestDetailResponseView createReservationFromAnExistingUser(@RequestBody GuestDetailRequestView request) {
		GuestDetailResponseView response = new GuestDetailResponseView();
		try {
			response = guestService.createGuest(request);
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
