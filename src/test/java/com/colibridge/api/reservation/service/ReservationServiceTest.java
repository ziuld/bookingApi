package com.colibridge.api.reservation.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.Mockito.when;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.colibridge.api.reservation.common.ModelMapper;
import com.colibridge.api.reservation.common.ReservationConstants;
import com.colibridge.api.reservation.model.ReservationEntity;
import com.colibridge.api.reservation.repository.GuestRepository;
import com.colibridge.api.reservation.repository.ReservationRepository;
import com.colibridge.api.reservation.request.GuestDataRequestView;
import com.colibridge.api.reservation.request.GuestDetailRequestView;
import com.colibridge.api.reservation.request.ReservationDataRequestView;
import com.colibridge.api.reservation.request.ReservationDetailRequestView;
import com.colibridge.api.reservation.request.ReservationNewGuestDataRequestView;
import com.colibridge.api.reservation.request.ReservationNewGuestDetailRequestView;
import com.colibridge.api.reservation.request.ReservationUpdateDataRequestView;
import com.colibridge.api.reservation.request.ReservationUpdateDetailRequestView;
import com.colibridge.api.reservation.response.CheckReservationResponseView;
import com.colibridge.api.reservation.response.GuestDataResponseView;
import com.colibridge.api.reservation.response.GuestDetailResponseView;
import com.colibridge.api.reservation.response.ReservationDetailResponseView;
import com.colibridge.api.reservation.response.ReservationsResponseView;

@ExtendWith(MockitoExtension.class)
public class ReservationServiceTest {

	private ReservationDetailRequestView reservationDetailRequestView;
	private ReservationUpdateDetailRequestView reservationUpdateDetailRequestView;
	private List<ReservationEntity> listEntity;
	private ReservationEntity reservationEntity;
	ReservationNewGuestDataRequestView data;
	ReservationDataRequestView dataRequest;
	private Date today;
	private String DATE_1 = "2021-10-15";
	private String DATE_2 = "2021-10-16";

	@InjectMocks
	private ReservationService reservationService;
	@Mock
	private GuestRepository guestRepository;
	@Mock
	private ReservationRepository reservationRepository;
	@Mock
	private ModelMapper modelMapper;
	@Mock
	private GuestService guestService;

	@BeforeEach
	void setup() {
		reservationDetailRequestView = new ReservationDetailRequestView();
		dataRequest = new ReservationDataRequestView();
		dataRequest.setFrom(DATE_1);
		dataRequest.setTo(DATE_2);
		dataRequest.setGuestId(0);
		reservationDetailRequestView.setData(dataRequest);
		reservationUpdateDetailRequestView = new ReservationUpdateDetailRequestView();
		ReservationUpdateDataRequestView dataRequest1 = new ReservationUpdateDataRequestView();
		dataRequest1.setFrom(DATE_1);
		dataRequest1.setTo(DATE_2);
		dataRequest1.setId(0);
		reservationUpdateDetailRequestView.setData(dataRequest1);
		listEntity = new ArrayList<ReservationEntity>();
		reservationEntity = new ReservationEntity();
		today = new Date();
	}

	@Test
	void getAllReservationTest() throws Exception {
		when(reservationRepository.findAll()).thenReturn(listEntity);
		ReservationsResponseView result = reservationService.getAllReservation();
		assertEquals(result.getHeader(), null);
	}

	@Test
	void checkReservationDatesDontAllowTest() throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String date = format.format(today);
		CheckReservationResponseView result = reservationService.checkReservationDates(date, date);
		assertEquals(result.getHeader().getResult(), ReservationConstants.FAILD);
	}

	@Test
	void checkReservationDatesTest() throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String today = format.format(new Date());
		when(reservationRepository.findAllByStartDateLessThanEqualAndEndDateGreaterThanEqualAndStartDateIsAfter(DATE_2,
				DATE_1, today)).thenReturn(listEntity);
		CheckReservationResponseView result = reservationService.checkReservationDates(DATE_1, DATE_2);
		assertEquals(result.getHeader().getResult(), ReservationConstants.SUCCESS);
	}

	@Test
	void createReservationFromAnExistingUserDataNullTest() throws Exception {
		ReservationDetailResponseView result = reservationService
				.createReservationFromAnExistingUser(new ReservationDetailRequestView());
		assertEquals(result.getHeader().getResult(), ReservationConstants.FAILD);
	}

	@Test
	void createReservationFromAnExistingUserTest() throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String today = format.format(new Date());
		when(reservationRepository.findAllByStartDateLessThanEqualAndEndDateGreaterThanEqualAndStartDateIsAfter(DATE_2,
				DATE_1, today)).thenReturn(listEntity);
		when(reservationRepository.save(null)).thenReturn(reservationEntity);
		ReservationDetailResponseView result = reservationService
				.createReservationFromAnExistingUser(reservationDetailRequestView);
		assertEquals(result.getHeader().getResult(), ReservationConstants.SUCCESS);
	}

	@Test
	void deleteByIdTest() throws Exception {
		ReservationDetailResponseView result = reservationService.deleteById(0);
		assertEquals(result.getHeader(), null);
	}

	@Test
	void updateReservationTest() throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String today = format.format(new Date());
		when(reservationRepository.findAllByStartDateLessThanEqualAndEndDateGreaterThanEqualAndStartDateIsAfter(DATE_2,
				DATE_1, today)).thenReturn(listEntity);
		reservationEntity.setId(0);
		when(modelMapper.toEntity(reservationUpdateDetailRequestView.getData())).thenReturn(reservationEntity);
		when(reservationRepository.findById(0)).thenReturn(reservationEntity);
		when(reservationRepository.save(reservationEntity)).thenReturn(reservationEntity);
		ReservationDetailResponseView result = reservationService.updateReservation(reservationUpdateDetailRequestView);
		assertEquals(result.getHeader().getResult(), ReservationConstants.SUCCESS);
	}

	@Test
	void getReservationByIdTest() throws Exception {
		when(reservationRepository.findById(0)).thenReturn(reservationEntity);
		ReservationDetailResponseView result = reservationService.getReservationById(0);
		assertEquals(result.getHeader(), null);
	}

	@Test
	void createReservationForNewUserFaildTest() throws Exception {
		ReservationNewGuestDetailRequestView request = new ReservationNewGuestDetailRequestView();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String today = format.format(new Date());
		listEntity.add(reservationEntity);
		when(modelMapper.toReservationData(request.getData())).thenReturn(dataRequest);
		when(reservationRepository.findAllByStartDateLessThanEqualAndEndDateGreaterThanEqualAndStartDateIsAfter(DATE_2,
				DATE_1, today)).thenReturn(listEntity);		
		ReservationDetailResponseView result = reservationService.createReservationForNewUser(request);
		assertEquals(result.getHeader().getResult(), ReservationConstants.FAILD);
	}
}
