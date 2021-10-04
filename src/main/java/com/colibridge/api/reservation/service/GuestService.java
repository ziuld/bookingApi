package com.colibridge.api.reservation.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colibridge.api.reservation.common.ManageError;
import com.colibridge.api.reservation.common.ManageHeader;
import com.colibridge.api.reservation.common.ModelMapper;
import com.colibridge.api.reservation.common.ReservationConstants;
import com.colibridge.api.reservation.model.GuestEntity;
import com.colibridge.api.reservation.repository.GuestRepository;
import com.colibridge.api.reservation.request.GuestDetailRequestView;
import com.colibridge.api.reservation.response.GuestDataResponseView;
import com.colibridge.api.reservation.response.GuestDetailResponseView;
import com.colibridge.api.reservation.response.GuestsResponseView;

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
	// GuestService parameters
	@Autowired
	private GuestRepository guestRepository;
	@Autowired
	private ModelMapper modelMapper;

	/**
	 * default constructor
	 */
	public GuestService() {
		// default
	}

	/**
	 * Find all guests.
	 * 
	 * @return GuestsResponseView
	 */
	public GuestsResponseView getAllGuests() throws Exception {
		GuestsResponseView response = new GuestsResponseView();
		ManageHeader header = new ManageHeader(ReservationConstants.SUCCESS);
		List<GuestEntity> result = guestRepository.findAll();
		List<GuestDataResponseView> listDto = result.stream().map(entity -> modelMapper.toDto(entity))
				.collect(Collectors.toList());
		response.setData(listDto);
		response.setHeader(header);
		return response;
	}

	/**
	 * Find all Guests Containing the name .
	 * 
	 * @param name
	 * @return GuestsResponseView
	 */
	public GuestsResponseView getGuestByNameContaining(String name) throws Exception {
		GuestsResponseView response = new GuestsResponseView();
		ManageHeader header = new ManageHeader(ReservationConstants.SUCCESS);
		response.setHeader(header);
		List<GuestEntity> result = guestRepository.findByFirstNameContainingOrLastNameContaining(name, name);
		List<GuestDataResponseView> listDto = result.stream().map(entity -> modelMapper.toDto(entity))
				.collect(Collectors.toList());
		response.setData(listDto);
		return response;
	}

	/**
	 * Create a Guest.
	 * 
	 * @param request
	 * @return GuestDetailResponseView
	 */
	public GuestDetailResponseView createGuest(GuestDetailRequestView request) throws Exception {
		GuestDetailResponseView response = new GuestDetailResponseView();
		GuestDataResponseView dataResponse = new GuestDataResponseView();
		GuestEntity requestEntity = modelMapper.toEntity(request.getData());
		GuestEntity result = guestRepository.save(requestEntity);
		dataResponse = modelMapper.toDto(result);
		response.setData(dataResponse);
		return response;
	}

	/**
	 * find a Guest.
	 * 
	 * @param id
	 * @return GuestDetailResponseView
	 */
	public GuestDetailResponseView getGuestById(int id) throws Exception {
		GuestDetailResponseView response = new GuestDetailResponseView();
		GuestDataResponseView dataResponse = new GuestDataResponseView();
		GuestEntity result = guestRepository.findById(id);
		dataResponse = modelMapper.toDto(result);
		response.setData(dataResponse);
		return response;
	}

}
