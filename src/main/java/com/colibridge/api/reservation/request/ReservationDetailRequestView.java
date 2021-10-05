package com.colibridge.api.reservation.request;

import com.colibridge.api.reservation.common.ClientRequestBase;

/**
 * <h2>ReservationDetailRequestView</h2>
 * <p>
 * Request of reservation
 * </p>
 *
 * @author Luis Hernandez
 * @version 1.0
 * @since 2021-01-09
 */
public class ReservationDetailRequestView extends ClientRequestBase {
	// ReservationDetailRequestView parameters
	private ReservationDataRequestView data;

	/**
	 * default constructor
	 */
	public ReservationDetailRequestView() {
		// default
	}

	/**
	 * @return the data
	 */
	public ReservationDataRequestView getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(ReservationDataRequestView data) {
		this.data = data;
	}

}
