package com.colibridge.api.reservation.response;

import java.util.List;

import com.colibridge.api.reservation.common.BaseModel;

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
public class ReservationsResponseView extends BaseModel {
	// ReservationsResponseView parameters
	private List<ReservationDataResponseView> data;

	/**
	 * default constructor
	 */
	public ReservationsResponseView() {
		// default
	}

	/**
	 * @return the reservations
	 */
	public List<ReservationDataResponseView> getReservations() {
		return data;
	}

	/**
	 * @param data the reservations to set
	 */
	public void setReservations(List<ReservationDataResponseView> data) {
		this.data = data;
	}
}
