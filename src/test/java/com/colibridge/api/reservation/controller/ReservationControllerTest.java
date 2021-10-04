package com.colibridge.api.reservation.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.colibridge.api.reservation.request.ReservationDetailRequestView;
import com.colibridge.api.reservation.request.ReservationNewGuestDetailRequestView;
import com.colibridge.api.reservation.request.ReservationUpdateDetailRequestView;
import com.colibridge.api.reservation.response.CheckReservationResponseView;
import com.colibridge.api.reservation.response.ReservationDetailResponseView;
import com.colibridge.api.reservation.response.ReservationsResponseView;
import com.colibridge.api.reservation.service.ReservationService;

@ExtendWith(MockitoExtension.class)
public class ReservationControllerTest {

	/**
	 * variables
	 */
	// private static final long serialVersionUID = 1L;
	private ReservationsResponseView reservationsResponseView;
	private ReservationDetailResponseView reservationDetailResponseView;
	private CheckReservationResponseView checkReservationResponseView;
	private ReservationDetailRequestView reservationDetailRequestView;
	private ReservationNewGuestDetailRequestView reservationNewGuestDetailRequestView;
	private ReservationUpdateDetailRequestView reservationUpdateDetailRequestView;

	@InjectMocks
	private ReservationController reservationController;
	@Mock
	private ReservationService reservationService;

	@BeforeEach
	void setup() {
		reservationsResponseView = new ReservationsResponseView();
		reservationDetailResponseView = new ReservationDetailResponseView();
		checkReservationResponseView = new CheckReservationResponseView();
		reservationDetailRequestView = new ReservationDetailRequestView();
		reservationNewGuestDetailRequestView = new ReservationNewGuestDetailRequestView();
		reservationUpdateDetailRequestView = new ReservationUpdateDetailRequestView();
	}

	@Test
	void getAllReservationTest() throws Exception {
		when(reservationService.getAllReservation()).thenReturn(reservationsResponseView);
		ReservationsResponseView result = reservationController.getAllReservation();
		assertEquals(result, reservationsResponseView);
	}

	@Test
	void getReservationTest() throws Exception {
		when(reservationService.getReservationById(0)).thenReturn(reservationDetailResponseView);
		ReservationDetailResponseView result = reservationController.getReservation(0);
		assertEquals(result, reservationDetailResponseView);
	}

	@Test
	void validateTest() throws Exception {
		when(reservationService.checkReservationDates(null, null)).thenReturn(checkReservationResponseView);
		CheckReservationResponseView result = reservationController.validate(null, null);
		assertEquals(result, checkReservationResponseView);
	}

	@Test
	void createReservationFromAnExistingUserTest() throws Exception {
		when(reservationService.createReservationFromAnExistingUser(reservationDetailRequestView))
				.thenReturn(reservationDetailResponseView);
		ReservationDetailResponseView result = reservationController
				.createReservationFromAnExistingUser(reservationDetailRequestView);
		assertEquals(result, reservationDetailResponseView);
	}

	@Test
	void createReservationForNewUserTest() throws Exception {
		when(reservationService.createReservationForNewUser(reservationNewGuestDetailRequestView))
				.thenReturn(reservationDetailResponseView);
		ReservationDetailResponseView result = reservationController
				.createReservationForNewUser(reservationNewGuestDetailRequestView);
		assertEquals(result, reservationDetailResponseView);
	}

	@Test
	void deleteReservationTest() throws Exception {
		when(reservationService.deleteById(0)).thenReturn(reservationDetailResponseView);
		ReservationDetailResponseView result = reservationController.deleteReservation(0);
		assertEquals(result, reservationDetailResponseView);
	}

	@Test
	void updateReservationTest() throws Exception {
		when(reservationService.updateReservation(reservationUpdateDetailRequestView))
				.thenReturn(reservationDetailResponseView);
		ReservationDetailResponseView result = reservationController
				.updateReservation(reservationUpdateDetailRequestView);
		assertEquals(result, reservationDetailResponseView);
	}

}
