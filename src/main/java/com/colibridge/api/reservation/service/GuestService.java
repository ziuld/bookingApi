package com.colibridge.api.reservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colibridge.api.reservation.model.GuestEntity;
import com.colibridge.api.reservation.repository.GuestRepository;

@Service
public class GuestService {

	@Autowired
	private GuestRepository guestRepository;

	public Iterable<GuestEntity> getAllGuests() {
		return guestRepository.findAll();
	}


}
