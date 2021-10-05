package com.colibridge.api.reservation.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.colibridge.api.reservation.common.ModelMapper;
import com.colibridge.api.reservation.common.ReservationConstants;
import com.colibridge.api.reservation.model.GuestEntity;
import com.colibridge.api.reservation.repository.GuestRepository;
import com.colibridge.api.reservation.request.GuestDataRequestView;
import com.colibridge.api.reservation.request.GuestDetailRequestView;
import com.colibridge.api.reservation.response.GuestDetailResponseView;
import com.colibridge.api.reservation.response.GuestsResponseView;

@ExtendWith(MockitoExtension.class)
public class GuestServiceTest {

	private GuestDetailRequestView guestDetailRequestView;
	private List<GuestEntity> listEntity;
	private GuestEntity guestEntity;



	@InjectMocks
	private GuestService guestService;
	@Mock
	private GuestRepository guestRepository;
	@Mock
	private ModelMapper modelMapper;

	@BeforeEach
	void setup() {
		guestDetailRequestView = new GuestDetailRequestView();
		GuestDataRequestView dataResquest = new GuestDataRequestView();
		guestDetailRequestView.setData(dataResquest );
		listEntity = new ArrayList<GuestEntity>();
		guestEntity = new GuestEntity();

	}
	
	@Test
	void getAllReservationTest() throws Exception {
		when(guestRepository.findAll()).thenReturn(listEntity);
		GuestsResponseView result = guestService.getAllGuests();
		assertEquals(result.getHeader().getResult(), ReservationConstants.SUCCESS);
	}
	
	@Test
	void getGuestByNameContainingTest() throws Exception {
		when(guestRepository.findByFirstNameContainingOrLastNameContaining(null, null)).thenReturn(listEntity);
		GuestsResponseView result = guestService.getGuestByNameContaining(null);
		assertEquals(result.getHeader().getResult(), ReservationConstants.SUCCESS);
	}
	
	@Test
	void createGuestTest() throws Exception {
		when(guestRepository.save(null)).thenReturn(guestEntity);
		GuestDetailResponseView result = guestService.createGuest(guestDetailRequestView);
		assertEquals(result.getHeader().getResult(), ReservationConstants.SUCCESS);
	}
	
	@Test
	void getGuestByIdTest() throws Exception {
		when(guestRepository.findById(0)).thenReturn(guestEntity);
		GuestDetailResponseView result = guestService.getGuestById(0);
		assertEquals(result.getHeader().getResult(), ReservationConstants.SUCCESS);
	}
}
