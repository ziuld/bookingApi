package com.colibridge.api.reservation.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.colibridge.api.reservation.request.GuestDetailRequestView;
import com.colibridge.api.reservation.response.GuestDetailResponseView;
import com.colibridge.api.reservation.response.GuestsResponseView;
import com.colibridge.api.reservation.service.GuestService;

@ExtendWith(MockitoExtension.class)
public class GuestControllerTest {

	/**
	 * variables
	 */
	// private static final long serialVersionUID = 1L;
	private GuestsResponseView guestsResponseView;
	private GuestDetailResponseView guestDetailResponseView;
	private GuestDetailRequestView guestDetailRequestView;

	@InjectMocks
	private GuestController guestController;
	@Mock
	private GuestService guestService;

	@BeforeEach
	void setup() {
		guestsResponseView = new GuestsResponseView();
		guestDetailResponseView = new GuestDetailResponseView();
		guestDetailRequestView = new GuestDetailRequestView();
	}

	@Test
	void getAllReservationTest() throws Exception {
		when(guestService.getAllGuests()).thenReturn(guestsResponseView);
		GuestsResponseView result = guestController.getAllGuests();
		assertEquals(result, guestsResponseView);
	}

	@Test
	void getGuestTest() throws Exception {
		when(guestService.getGuestById(0)).thenReturn(guestDetailResponseView);
		GuestDetailResponseView result = guestController.getGuest(0);
		assertEquals(result, guestDetailResponseView);
	}

	@Test
	void getGuestByNameContainingTest() throws Exception {
		when(guestService.getGuestByNameContaining(null)).thenReturn(guestsResponseView);
		GuestsResponseView result = guestController.getGuestByNameContaining(null);
		assertEquals(result, guestsResponseView);
	}

	@Test
	void createReservationFromAnExistingUserTest() throws Exception {
		when(guestService.createGuest(guestDetailRequestView)).thenReturn(guestDetailResponseView);
		GuestDetailResponseView result = guestController.createReservationFromAnExistingUser(guestDetailRequestView);
		assertEquals(result, guestDetailResponseView);
	}

}
