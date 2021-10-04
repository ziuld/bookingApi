package com.colibridge.api.reservation.request;

import com.colibridge.api.reservation.common.ClientRequestBase;

/**
 * <h2>GuestDetailRequestView</h2>
 * <p>
 * Request of data guest
 * </p>
 *
 * @author Luis Hernandez
 * @version 1.0
 * @since 2021-01-09
 */
public class GuestDetailRequestView extends ClientRequestBase {
	// GuestDetailRequestView parameters
	private GuestDataRequestView data;

	/**
	 * default constructor
	 */
	public GuestDetailRequestView() {
		// default
	}

	/**
	 * @return the data
	 */
	public GuestDataRequestView getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(GuestDataRequestView data) {
		this.data = data;
	}
}
