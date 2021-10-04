package com.colibridge.api.reservation.request;

/**
 * <h2>ReservationUpdateDetailsRequestView</h2>
 * <p>
 * Request of reservation
 * </p>
 *
 * @author Luis Hernandez
 * @version 1.0
 * @since 2021-01-09
 */
public class ReservationUpdateDetailRequestView {
	// ReservationUpdateDetailRequestView parameters
	ReservationUpdateDataRequestView data;

	/**
	 * default constructor
	 */
	public ReservationUpdateDetailRequestView() {
		// default
	}

	/**
	 * @return the data
	 */
	public ReservationUpdateDataRequestView getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(ReservationUpdateDataRequestView data) {
		this.data = data;
	}
}
