package com.colibridge.api.reservation.response;

import java.util.List;

import com.colibridge.api.reservation.common.BaseModel;
import com.colibridge.api.reservation.model.GuestDto;

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
public class GuestResponseView extends BaseModel{

	private List<GuestDto> data;

	/**
	 * default constructor
	 */
	public GuestResponseView() {
		// default
	}

	/**
	 * @return the data
	 */
	public List<GuestDto> getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(List<GuestDto> data) {
		this.data = data;
	}

}
