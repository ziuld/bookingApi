package com.colibridge.api.reservation.response;

import java.util.List;

import com.colibridge.api.reservation.common.BaseModel;

/**
 * <h2>GuestResponseView</h2>
 * <p>
 * Response a guest detail
 * </p>
 *
 * @author Luis Hernandez
 * @version 1.0
 * @since 2021-01-09
 */
public class GuestsResponseView extends BaseModel {
	// GuestsResponseView parameters
	private List<GuestDataResponseView> data;

	/**
	 * default constructor
	 */
	public GuestsResponseView() {
		// default
	}

	/**
	 * @return the data
	 */
	public List<GuestDataResponseView> getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(List<GuestDataResponseView> data) {
		this.data = data;
	}

}
