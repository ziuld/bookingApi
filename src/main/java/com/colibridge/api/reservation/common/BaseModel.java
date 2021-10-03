package com.colibridge.api.reservation.common;

/**
 * <h2>BaseModel</h2>
 * <p>
 * Base model repsonse
 * </p>
 *
 * @author Luis Hernandez
 * @version 1.0
 * @since 2021-01-09
 */
public class BaseModel {
	private ManageHeader header;
	private ManageError error;

	/**
	 * @return the header
	 */
	public ManageHeader getHeader() {
		return header;
	}

	/**
	 * @param header the header to set
	 */
	public void setHeader(ManageHeader header) {
		this.header = header;
	}

	/**
	 * @return the error
	 */
	public ManageError getError() {
		return error;
	}

	/**
	 * @param error the error to set
	 */
	public void setError(ManageError error) {
		this.error = error;
	}

}
