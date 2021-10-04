package com.colibridge.api.reservation.response;

import com.colibridge.api.reservation.common.BaseModel;

/**
 * <h2>GuestDetailResponseView</h2>
 * <p>
 * Response a guest detail
 * </p>
 *
 * @author Luis Hernandez
 * @version 1.0
 * @since 2021-01-09
 */
public class GuestDetailResponseView extends BaseModel {
	// GuestDetailResponseView parameters
	GuestDataResponseView data;

	/**
	 * default constructor
	 */
	public GuestDetailResponseView() {
		// default
	}

	/**
	 * @return the data
	 */
	public GuestDataResponseView getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(GuestDataResponseView data) {
		this.data = data;
	}
}
