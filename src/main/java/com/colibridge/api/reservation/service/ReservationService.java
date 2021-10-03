package com.colibridge.api.reservation.service;

import java.text.ParseException;
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
import com.colibridge.api.reservation.model.ReservationDto;
import com.colibridge.api.reservation.model.ReservationEntity;
import com.colibridge.api.reservation.repository.ReservationRepository;
import com.colibridge.api.reservation.response.CheckReservationResponseView;
import com.colibridge.api.reservation.response.ReservationDetails;
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

	@Autowired
	private ReservationRepository reservationRepository;
	@Autowired
	private ModelMapper modelMapper;

	/**
	 * Find all reservations.
	 * 
	 * @return ReservationsResponseView
	 * @throws Exception
	 */
	public ReservationsResponseView getAllReservation() throws Exception {
		ReservationsResponseView response = new ReservationsResponseView();
		List<ReservationEntity> result = reservationRepository.findAll();
		List<ReservationDto> listDto = result.stream().map(entity -> modelMapper.toDto(entity))
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

		if (validateDates(start, end)) {
			result = reservationRepository.findAllByStartDateIsAfterOrEndDateIsBefore(end, start);
		} else {
			data.setAvailable(false);
			data.setComment(ReservationConstants.MESSAGE_OUT_OF_RANGE);
			response.setData(data);
			return response;
		}

		if (result.isEmpty()) {
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

		try {
			date1 = format.parse(start).toInstant();
			date2 = format.parse(end).toInstant();
			long daysBetween = ChronoUnit.DAYS.between(date1, date2);

			if (date1.compareTo(date2) > 0) {
				throw new Exception(ReservationConstants.INVALID_RANGE);
			}else if(daysBetween > 2){
				return false;
			}else if (!(date1.isAfter(minLimitReservation) && date2.isBefore(maxLimitReservation))) {
				return false;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

}
