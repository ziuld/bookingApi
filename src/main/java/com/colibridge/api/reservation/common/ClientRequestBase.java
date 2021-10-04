package com.colibridge.api.reservation.common;

/**
 * <h2>ClientRequestBase</h2>
 * <p>
 * Base model request
 * </p>
 *
 * @author Luis Hernandez
 * @version 1.0
 * @since 2021-01-09
 */
public class ClientRequestBase {
	// ClientRequestBase parameters
	private ManageHeader header;

	/**
	 * default constructor
	 */
	public ClientRequestBase() {
		// default
	}

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
}
