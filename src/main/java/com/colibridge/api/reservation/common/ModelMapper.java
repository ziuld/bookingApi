package com.colibridge.api.reservation.common;

import javax.annotation.ManagedBean;

import com.colibridge.api.reservation.model.GuestEntity;
import com.colibridge.api.reservation.model.ReservationEntity;
import com.colibridge.api.reservation.request.GuestDataRequestView;
import com.colibridge.api.reservation.request.ReservationDataRequestView;
import com.colibridge.api.reservation.request.ReservationNewGuestDataRequestView;
import com.colibridge.api.reservation.request.ReservationUpdateDataRequestView;
import com.colibridge.api.reservation.response.GuestDataResponseView;
import com.colibridge.api.reservation.response.ReservationDataResponseView;

/**
 * <h2>ModelMapper</h2>
 * <p>
 * ModelMapper of dto and entity
 * </p>
 *
 * @author Luis Hernandez
 * @version 1.0
 * @since 2021-01-09
 */
@ManagedBean
public class ModelMapper {

	/**
	 * default constructor
	 */
	public ModelMapper() {
		// default
	}

	/**
	 * from GuestEntity to GuestDataResponseView
	 * 
	 * @param entity
	 * @return GuestDto
	 */
	public GuestDataResponseView toDto(GuestEntity entity) {
		GuestDataResponseView dto = new GuestDataResponseView();
		if (entity != null) {
			dto.setId(entity.getId());
			dto.setFirstName(entity.getFirstName());
			dto.setLastName(entity.getLastName());
			dto.setEmail(entity.getEmail());
			dto.setPhone(entity.getPhone());
			dto.setAddress(entity.getAddress());
			dto.setComment(entity.getDetails());
		}
		return dto;
	}

	/**
	 * from GuestDataResponseView to GuestEntity
	 * 
	 * @param dto
	 * @return GuestEntity
	 */
	public GuestEntity toEntity(GuestDataResponseView dto) {
		GuestEntity entity = new GuestEntity();
		if (dto != null) {

			entity.setFirstName(dto.getFirstName());
			entity.setLastName(dto.getLastName());
			entity.setEmail(dto.getEmail());
			entity.setAddress(dto.getAddress());
			entity.setDetails(dto.getComment());
		}
		return entity;
	}

	/**
	 * from ReservationEntity to ReservationDataResponseView
	 * 
	 * @param entity
	 * @return ReservationDto
	 */
	public ReservationDataResponseView toDto(ReservationEntity entity) {
		ReservationDataResponseView dto = new ReservationDataResponseView();
		if (entity != null) {
			dto.setId(entity.getId());
			dto.setGuestId(entity.getGuestId());
			dto.setFrom(entity.getStartDate());
			dto.setTo(entity.getEndDate());
			dto.setComment(entity.getDetails());
		}
		return dto;
	}

	/**
	 * from ReservationDataRequestView to ReservationEntity
	 * 
	 * @param dto
	 * @return ReservationEntity
	 */
	public ReservationEntity toEntity(ReservationDataRequestView dto) {
		ReservationEntity entity = new ReservationEntity();
		if (dto != null) {

			entity.setGuestId(dto.getGuestId());
			entity.setStartDate(dto.getFrom());
			entity.setEndDate(dto.getTo());
			entity.setDetails(dto.getComment());
		}
		return entity;
	}

	/**
	 * from ReservationDataResponseView to ReservationEntity
	 * 
	 * @param dto
	 * @return ReservationEntity
	 */
	public ReservationEntity toEntity(ReservationDataResponseView dto) {
		ReservationEntity entity = new ReservationEntity();
		if (dto != null) {

			entity.setId(dto.getId());
			entity.setGuestId(dto.getGuestId());
			entity.setStartDate(dto.getFrom());
			entity.setEndDate(dto.getTo());
			entity.setDetails(dto.getComment());
		}
		return entity;
	}

	/**
	 * from GuestDataRequestView to GuestEntity
	 * 
	 * @param dto
	 * @return ReservationEntity
	 */
	public GuestEntity toEntity(GuestDataRequestView dto) {
		GuestEntity entity = new GuestEntity();
		if (dto != null) {

			entity.setFirstName(dto.getFirstName());
			entity.setLastName(dto.getLastName());
			entity.setEmail(dto.getEmail());
			entity.setPhone(dto.getPhone());
			entity.setAddress(dto.getAddress());
			entity.setDetails(dto.getComment());
		}
		return entity;
	}

	/**
	 * from ReservationNewGuestDataRequestView to GuestDataRequestView
	 * 
	 * @param dto
	 * @return ReservationEntity
	 */
	public GuestDataRequestView toGuestData(ReservationNewGuestDataRequestView data) {
		GuestDataRequestView guest = new GuestDataRequestView();
		if (data != null) {

			guest.setFirstName(data.getFirstName());
			guest.setLastName(data.getLastName());
			guest.setEmail(data.getEmail());
			guest.setPhone(data.getPhone());
			guest.setAddress(data.getAddress());
		}
		return guest;
	}

	/**
	 * from ReservationNewGuestDataRequestView to ReservationDataRequestView
	 * 
	 * @param dto
	 * @return ReservationEntity
	 */
	public ReservationDataRequestView toReservationData(ReservationNewGuestDataRequestView data) {
		ReservationDataRequestView reservation = new ReservationDataRequestView();
		if (data != null) {
			reservation.setGuestId(null);
			reservation.setFrom(data.getFrom());
			reservation.setTo(data.getTo());
			reservation.setComment(data.getComment());
		}
		return reservation;
	}

	/**
	 * from ReservationUpdateDataRequestView to ReservationEntity
	 * 
	 * @param dto
	 * @return ReservationEntity
	 */
	public ReservationEntity toEntity(ReservationUpdateDataRequestView dto) {
		ReservationEntity entity = new ReservationEntity();
		if (dto != null) {

			entity.setId(dto.getId());
			entity.setGuestId(dto.getGuestId());
			entity.setStartDate(dto.getFrom());
			entity.setEndDate(dto.getTo());
			entity.setDetails(dto.getComment());
		}
		return entity;
	}

}
