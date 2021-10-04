package com.colibridge.api.reservation.response;

import com.colibridge.api.reservation.common.BaseModel;

/**
 * <h2>ReservationDetailsResponseView</h2>
 * <p>
 * Response a reservation detail
 * </p>
 *
 * @author Luis Hernandez
 * @version 1.0
 * @since 2021-01-09
 */
public class ReservationDetailResponseView extends BaseModel {
	// ReservationDetailResponseView parameters
	private ReservationDataResponseView data;

	/**
	 * default constructor
	 */
	public ReservationDetailResponseView() {
		// default
	}

	/**
	 * @return the data
	 */
	public ReservationDataResponseView getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(ReservationDataResponseView data) {
		this.data = data;
	}

}
