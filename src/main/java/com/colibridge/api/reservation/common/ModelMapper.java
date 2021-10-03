package com.colibridge.api.reservation.common;

import javax.annotation.ManagedBean;

import com.colibridge.api.reservation.model.GuestDto;
import com.colibridge.api.reservation.model.GuestEntity;
import com.colibridge.api.reservation.model.ReservationDto;
import com.colibridge.api.reservation.model.ReservationEntity;

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
		super();
	}

	/**
	 * @param entity
	 * @return ReservationDto
	 */
	public ReservationDto toDto(ReservationEntity entity) {
		ReservationDto dto = new ReservationDto();
		dto.setCode(entity.getId());
		dto.setFrom(entity.getStartDate());
		dto.setTo(entity.getEndDate());
		dto.setComment(entity.getDetails());
		dto.setUpdated(entity.getTsUpdated());
		return dto;
	}

	/**
	 * @param dto
	 * @return ReservationEntity
	 */
	public ReservationEntity toEntity(ReservationDto dto) {
		ReservationEntity entity = new ReservationEntity();
		entity.setId(dto.getCode());
		entity.setStartDate(dto.getFrom());
		entity.setEndDate(dto.getTo());
		entity.setDetails(dto.getComment());
		return entity;
	}

	/**
	 * @param entity
	 * @return GuestDto
	 */
	public GuestDto entityToDto(GuestEntity entity) {
		GuestDto dto = new GuestDto();
		dto.setId(entity.getId());
		dto.setFirstName(entity.getFirstName());
		dto.setLastName(entity.getLastName());
		dto.setEmail(entity.getEmail());
		dto.setAddress(entity.getAddress());
		dto.setComment(entity.getDetails());
		return dto;
	}

	/**
	 * @param dto
	 * @return GuestEntity
	 */
	public GuestEntity toEntity(GuestDto dto) {
		GuestEntity entity = new GuestEntity();
		entity.setId(dto.getId());
		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());
		entity.setEmail(dto.getEmail());
		entity.setAddress(dto.getAddress());
		entity.setDetails(dto.getComment());

		return entity;
	}

}
