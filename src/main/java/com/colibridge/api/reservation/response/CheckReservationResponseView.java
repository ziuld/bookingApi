package com.colibridge.api.reservation.response;

import com.colibridge.api.reservation.common.BaseModel;

/**
 * <h2>CheckReservationResponseView</h2>
 * <p>
 * Response if the date are valid
 * </p>
 *
 * @author Luis Hernandez
 * @version 1.0
 * @since 2021-01-09
 */
public class CheckReservationResponseView extends BaseModel {
	// CheckReservationResponseView parameters
	private ReservationDetails data;

	/**
	 * default constructor
	 */
	public CheckReservationResponseView() {
		// default
	}

	/**
	 * @return the data
	 */
	public ReservationDetails getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(ReservationDetails data) {
		this.data = data;
	}

}
