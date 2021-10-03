package com.colibridge.api.reservation.response;

import java.util.List;

import com.colibridge.api.reservation.common.BaseModel;
import com.colibridge.api.reservation.model.ReservationDto;

/**
 * <h2>ReservationsResponseView</h2>
 * <p>
 * Response all reservations
 * </p>
 *
 * @author Luis Hernandez
 * @version 1.0
 * @since 2021-01-09
 */
public class ReservationsResponseView extends BaseModel{

	private List<ReservationDto> data;
	
	public ReservationsResponseView() {
		//constructor base
	}

	/**
	 * @return the reservations
	 */
	public List<ReservationDto> getReservations() {
		return data;
	}

	/**
	 * @param data the reservations to set
	 */
	public void setReservations(List<ReservationDto> data) {
		this.data = data;
	}
}
