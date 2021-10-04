package com.colibridge.api.reservation.service;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colibridge.api.reservation.common.ModelMapper;
import com.colibridge.api.reservation.common.ReservationConstants;
import com.colibridge.api.reservation.model.ReservationEntity;
import com.colibridge.api.reservation.repository.ReservationRepository;
import com.colibridge.api.reservation.request.GuestDataRequestView;
import com.colibridge.api.reservation.request.GuestDetailRequestView;
import com.colibridge.api.reservation.request.ReservationDataRequestView;
import com.colibridge.api.reservation.request.ReservationDetailRequestView;
import com.colibridge.api.reservation.request.ReservationNewGuestDetailRequestView;
import com.colibridge.api.reservation.request.ReservationUpdateDetailRequestView;
import com.colibridge.api.reservation.response.CheckReservationResponseView;
import com.colibridge.api.reservation.response.GuestDetailResponseView;
import com.colibridge.api.reservation.response.ReservationDataResponseView;
import com.colibridge.api.reservation.response.ReservationDetails;
import com.colibridge.api.reservation.response.ReservationDetailResponseView;
import com.colibridge.api.reservation.response.ReservationsResponseView;

/**
 * <h2>ReservationService</h2>
 * <p>
 * Reservation Services
 * </p>
 *
 * @author Luis Hernandez
 * @version 1.0
 * @since 2021-01-09
 */
@Service
public class ReservationService {
	// ReservationService parameters
	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private GuestService guestService;
	
	/**
	 * default constructor
	 */
	public ReservationService() {
		// default
	}
	/**
	 * Find all reservations.
	 * 
	 * @return ReservationsResponseView
	 * @throws Exception
	 */
	public ReservationsResponseView getAllReservation() throws Exception {
		ReservationsResponseView response = new ReservationsResponseView();
		List<ReservationEntity> result = reservationRepository.findAll();
		List<ReservationDataResponseView> listDto = result.stream().map(entity -> modelMapper.toDto(entity))
				.collect(Collectors.toList());
		response.setReservations(listDto);
		return response;
	}

	/**
	 * Validate if the dates are available.
	 * 
	 * @return CheckReservationResponseView
	 * @throws Exception
	 */
	public CheckReservationResponseView checkReservationDates(String start, String end) throws Exception {
		CheckReservationResponseView response = new CheckReservationResponseView();
		List<ReservationEntity> result = null;
		ReservationDetails data = new ReservationDetails();
		data.setFrom(start);
		data.setTo(end);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String today = format.format(new Date());

		if (!validateDates(start, end)) {
			data.setAvailable(false);
			data.setComment(ReservationConstants.MESSAGE_OUT_OF_RANGE);
			response.setData(data);
			return response;
		} else {
			result = reservationRepository
					.findAllByStartDateLessThanEqualAndEndDateGreaterThanEqualAndStartDateIsAfter(end, start, today);
		}
		if (!result.isEmpty()) {
			data.setAvailable(false);
			data.setComment(ReservationConstants.MESSAGE_FALSE + start + ReservationConstants.AND + end
					+ ReservationConstants.DOT);
		} else {
			data.setComment(ReservationConstants.MESSAGE_TRUE);
		}
		response.setData(data);

		return response;
	}

	/**
	 * create reservation from an existing user
	 * 
	 * @param booking
	 * @return ReservationDetailResponseView
	 */
	public ReservationDetailResponseView createReservationFromAnExistingUser(ReservationDetailRequestView request)
			throws Exception {
		ReservationDetailResponseView response = new ReservationDetailResponseView();
		ReservationDataRequestView data = request.getData();
		ReservationEntity result = new ReservationEntity();
		ReservationDataResponseView dataResponse = new ReservationDataResponseView();
		dataResponse.setGuestId(data.getGuestId());
		String starDate = data.getFrom();
		String endDate = data.getTo();
		dataResponse.setFrom(starDate);
		dataResponse.setTo(endDate);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String today = format.format(new Date());
		List<ReservationEntity> isAvaiable = null;

		if (!validateDates(starDate, endDate)) {
			dataResponse.setComment(ReservationConstants.MESSAGE_OUT_OF_RANGE);
			response.setData(dataResponse);
			return response;
		} else {
			isAvaiable = reservationRepository
					.findAllByStartDateLessThanEqualAndEndDateGreaterThanEqualAndStartDateIsAfter(endDate, starDate,
							today);
		}
		if (!isAvaiable.isEmpty()) {
			dataResponse.setComment(ReservationConstants.MESSAGE_FALSE + starDate + ReservationConstants.AND + endDate
					+ ReservationConstants.DOT);
		} else {
			ReservationEntity reservationEntity = modelMapper.toEntity(data);
			result = reservationRepository.save(reservationEntity);
			dataResponse.setId(result.getId());
			dataResponse.setComment(ReservationConstants.BOOKING_OK);
		}
		response.setData(dataResponse);
		return response;
	}

	/**
	 * Validate dates ranges.
	 * 
	 * @param start
	 * @param end
	 * @return boolean
	 * @throws Exception
	 */
	private boolean validateDates(String start, String end) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Instant date1 = null;
		Instant date2 = null;
		Date today = new Date();
		Instant minLimitReservation = today.toInstant();
		Instant maxLimitReservation = today.toInstant().plus(31, ChronoUnit.DAYS);
		date1 = format.parse(start).toInstant();
		date2 = format.parse(end).toInstant();
		long daysBetween = ChronoUnit.DAYS.between(date1, date2);

		if (date1.compareTo(date2) > 0 && date1.isAfter(today.toInstant())) {
			throw new Exception(ReservationConstants.INVALID_RANGE);
		} else if (daysBetween > 2) {
			return false;
		} else if (!(date1.isAfter(minLimitReservation) && date2.isBefore(maxLimitReservation))) {
			return false;
		}

		return true;
	}

	/**
	 * create reservation with a new user
	 * 
	 * @param request
	 * @return ReservationDetailResponseView
	 * @throws Exception
	 */
	public ReservationDetailResponseView createReservationForNewUser(ReservationNewGuestDetailRequestView request)
			throws Exception {
		// validate dates first
		ReservationDetailResponseView response = new ReservationDetailResponseView();
		ReservationDataResponseView dataResponse = new ReservationDataResponseView();
		ReservationDataRequestView requestData = modelMapper.toReservationData(request.getData());
		String starDate = requestData.getFrom();
		String endDate = requestData.getTo();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String today = format.format(new Date());
		List<ReservationEntity> isAvaiable = null;

		if (!validateDates(starDate, endDate)) {
			dataResponse.setComment(ReservationConstants.MESSAGE_OUT_OF_RANGE);
			response.setData(dataResponse);
			return response;
		} else {
			isAvaiable = reservationRepository
					.findAllByStartDateLessThanEqualAndEndDateGreaterThanEqualAndStartDateIsAfter(endDate, starDate,
							today);
		}
		if (!isAvaiable.isEmpty()) {
			dataResponse.setComment(ReservationConstants.MESSAGE_FALSE + starDate + ReservationConstants.AND + endDate
					+ ReservationConstants.DOT);
		} else {

			// Guest registration
			GuestDetailRequestView guestRequest = new GuestDetailRequestView();
			GuestDataRequestView guestData = modelMapper.toGuestData(request.getData());
			guestRequest.setData(guestData);
			GuestDetailResponseView guestResult = guestService.createGuest(guestRequest);

			// Reservation registration
			ReservationEntity reservationEntity = modelMapper.toEntity(requestData);
			reservationEntity.setGuestId(guestResult.getData().getId());

			ReservationEntity result = reservationRepository.save(reservationEntity);
			dataResponse = modelMapper.toDto(result);
			dataResponse.setComment(ReservationConstants.BOOKING_OK);

		}
		response.setData(dataResponse);
		return response;
	}

	/**
	 * delete reservation
	 * 
	 * @param id
	 * @return ReservationDetailResponseView
	 * @throws Exception
	 */
	public ReservationDetailResponseView deleteById(int id) throws Exception {
		ReservationDetailResponseView response = new ReservationDetailResponseView();
		ReservationDataResponseView dataResponse = new ReservationDataResponseView();
		ReservationEntity entity = new ReservationEntity();
		entity.setId(id);
		reservationRepository.delete(entity);
		dataResponse.setId(id);
		response.setData(dataResponse);
		return response;
	}

	/**
	 * update reservation
	 * 
	 * @param request
	 * @return ReservationDetailResponseView
	 * @throws Exception
	 */
	public ReservationDetailResponseView updateReservation(ReservationUpdateDetailRequestView request) throws Exception {
		// validate dates first
		ReservationDetailResponseView response = new ReservationDetailResponseView();
		ReservationDataResponseView dataResponse = new ReservationDataResponseView();
		String starDate = request.getData().getFrom();
		String endDate = request.getData().getTo();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String today = format.format(new Date());
		List<ReservationEntity> isAvaiable = null;

		if (!validateDates(starDate, endDate)) {
			dataResponse.setComment(ReservationConstants.MESSAGE_OUT_OF_RANGE);
			response.setData(dataResponse);
			return response;
		} else {
			isAvaiable = reservationRepository
					.findAllByStartDateLessThanEqualAndEndDateGreaterThanEqualAndStartDateIsAfter(endDate, starDate,
							today);
		}
		if (!isAvaiable.isEmpty()) {
			dataResponse.setComment(ReservationConstants.MESSAGE_FALSE + starDate + ReservationConstants.AND + endDate
					+ ReservationConstants.DOT);
		} else {
			ReservationEntity entity = modelMapper.toEntity(request.getData());
			ReservationEntity result = reservationRepository.findById(entity.getId());
			if (result == null) {
				dataResponse.setComment(ReservationConstants.MESSAGE_RESERVATION_NO_EXIST);
			} else if (result.getGuestId()!=entity.getGuestId()){
				dataResponse.setComment(ReservationConstants.MESSAGE_GUEST_DFF);
			}else {
				ReservationEntity updated = reservationRepository.save(entity);
				dataResponse = modelMapper.toDto(updated);
			}
			
		}
		
		response.setData(dataResponse);
		return response;
	}

	/**
	 * find a Reservation.
	 * 
	 * @param id
	 * @return ReservationDetailResponseView
	 */
	public ReservationDetailResponseView getReservationById(int id) {
		ReservationDetailResponseView response = new ReservationDetailResponseView();
		ReservationDataResponseView dataResponse = new ReservationDataResponseView();
		ReservationEntity result = reservationRepository.findById(id);
		dataResponse = modelMapper.toDto(result);
		response.setData(dataResponse);
		return response;
	}

}
