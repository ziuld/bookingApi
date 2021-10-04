package com.colibridge.api.reservation.common;

/**
 * <h2>ManageHeader</h2>
 * <p>
 * header repsonse
 * </p>
 *
 * @author Luis Hernandez
 * @version 1.0
 * @since 2021-01-09
 */
public class ManageHeader {
	// ManageHeader parameters
	private String result;

	/**
	 * default constructor
	 */
	public ManageHeader() {
		// default
	}

	public ManageHeader(String result) {
		this.result = result;
	}

	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}
}
