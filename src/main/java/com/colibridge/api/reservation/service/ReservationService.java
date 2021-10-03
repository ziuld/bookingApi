package com.colibridge.api.reservation.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colibridge.api.reservation.common.ManageError;
import com.colibridge.api.reservation.common.ManageHeader;
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
	 * @return Iterable<ReservationEntity>
	 */
	public ReservationsResponseView getAllReservation() {
		ReservationsResponseView response = new ReservationsResponseView();
		ManageHeader header = new ManageHeader(ReservationConstants.SUCCESS);
		try {
			List<ReservationEntity> result = reservationRepository.findAll();
			List<ReservationDto> listDto = result.stream().map(entity -> modelMapper.toDto(entity))
					.collect(Collectors.toList());
			response.setReservations(listDto);
			response.setHeader(header);

		} catch (Exception e) {
			header.setResult(ReservationConstants.FAILD);
			ManageError error = new ManageError(ReservationConstants.ERROR_REPOSITORY_CODE,
					ReservationConstants.ERROR_REPOSITORY_DETAILL);
			response.setError(error);
		}

		return response;
	}

	/**
	 * Validate if the dates are available.
	 * 
	 * @return Iterable<ReservationEntity>
	 */
	public CheckReservationResponseView checkReservationDates(String start, String end) {
		CheckReservationResponseView response = new CheckReservationResponseView();
		ReservationDetails data = new ReservationDetails();
		data.setFrom(start);
		data.setTo(end);
		ManageHeader header = new ManageHeader(ReservationConstants.SUCCESS);
		try {
			List<ReservationEntity> result = reservationRepository.findAllByStartDateIsAfterOrEndDateIsBefore(end, start);

			if (result.isEmpty()) {
				data.setAvailable(false);
				data.setComment("I am sorry, there is a reservation between: "+start+" and "+""+end+".");
			} else {
				data.setComment("It's avaiable.");
			}
			response.setHeader(header);
			response.setData(data);

		} catch (Exception e) {
			header.setResult(ReservationConstants.FAILD);
			ManageError error = new ManageError(ReservationConstants.ERROR_REPOSITORY_CODE,
					ReservationConstants.ERROR_REPOSITORY_DETAILL);
			response.setError(error);
		}
		return response;
	}

}
