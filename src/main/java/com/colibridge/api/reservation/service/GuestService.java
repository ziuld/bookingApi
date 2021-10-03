package com.colibridge.api.reservation.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colibridge.api.reservation.common.ManageError;
import com.colibridge.api.reservation.common.ManageHeader;
import com.colibridge.api.reservation.common.ModelMapper;
import com.colibridge.api.reservation.common.ReservationConstants;
import com.colibridge.api.reservation.model.GuestDto;
import com.colibridge.api.reservation.model.GuestEntity;
import com.colibridge.api.reservation.model.ReservationDto;
import com.colibridge.api.reservation.model.ReservationEntity;
import com.colibridge.api.reservation.repository.GuestRepository;
import com.colibridge.api.reservation.response.GuestResponseView;
import com.colibridge.api.reservation.response.ReservationsResponseView;

/**
 * <h2>GuestService</h2>
 * <p>
 * Guest Services
 * </p>
 *
 * @author Luis Hernandez
 * @version 1.0
 * @since 2021-01-09
 */
@Service
public class GuestService {

	@Autowired
	private GuestRepository guestRepository;
	@Autowired
	private ModelMapper modelMapper;

	/**
	 * Find all guests.
	 * 
	 * @return Iterable<GuestEntity>
	 */
	public GuestResponseView getAllGuests() {
		GuestResponseView response = new GuestResponseView();
		ManageHeader header = new ManageHeader(ReservationConstants.SUCCESS);
		try {
			List<GuestEntity> result = guestRepository.findAll();
			List<GuestDto> listDto = result.stream().map(entity -> modelMapper.entityToDto(entity))
					.collect(Collectors.toList());
			response.setData(listDto);
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
	 * Find all Guests Containing the name .
	 * 
	 * @param name
	 * @return Iterable<GuestEntity>
	 */
	public GuestResponseView getGuestByNameContaining(String name) {
		GuestResponseView response = new GuestResponseView();
		ManageHeader header = new ManageHeader(ReservationConstants.SUCCESS);
		try {
			List<GuestEntity> result = guestRepository.findByFirstNameContainingOrLastNameContaining(name, name);
			List<GuestDto> listDto = result.stream().map(entity -> modelMapper.entityToDto(entity))
					.collect(Collectors.toList());
			response.setData(listDto);
			response.setHeader(header);
		} catch (Exception e) {
			header.setResult(ReservationConstants.FAILD);
			ManageError error = new ManageError(ReservationConstants.ERROR_REPOSITORY_CODE,
					ReservationConstants.ERROR_REPOSITORY_DETAILL);
			response.setError(error);
		}

		return response;
	}

}
