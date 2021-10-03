package com.colibridge.api.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.colibridge.api.reservation.model.GuestDto;
import com.colibridge.api.reservation.model.GuestEntity;
import com.colibridge.api.reservation.response.GuestResponseView;
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

	@Autowired
	private GuestService guestService;

	/**
	 * Find all guest.
	 * 
	 * @return GuestResponseView
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public GuestResponseView getAllGuests() {
		return guestService.getAllGuests();
	}
	
	/**
	 * Find all Guests Containing the name.
	 * 
	 * @return GuestResponseView
	 */
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public GuestResponseView getGuestByNameContaining(@PathVariable String name) {
		return guestService.getGuestByNameContaining(name);
	}

}
