package com.colibridge.api.reservation.request;

/**
 * <h2>ReservationNewGuestDetailRequestView</h2>
 * <p>
 * Request of new guest reservation
 * </p>
 *
 * @author Luis Hernandez
 * @version 1.0
 * @since 2021-01-09
 */
public class ReservationNewGuestDetailRequestView {
	// ReservationNewGuestDetailRequestView parameters
	private ReservationNewGuestDataRequestView data;

	/**
	 * default constructor
	 */
	public ReservationNewGuestDetailRequestView() {
		// default
	}

	/**
	 * @return the data
	 */
	public ReservationNewGuestDataRequestView getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(ReservationNewGuestDataRequestView data) {
		this.data = data;
	}

}
