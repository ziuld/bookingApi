package com.colibridge.api.reservation.response;

/**
 * <h2>ReservationDetails</h2>
 * <p>
 * Response a reservation detail
 * </p>
 *
 * @author Luis Hernandez
 * @version 1.0
 * @since 2021-01-09
 */
public class ReservationDetails {
	// ReservationDetails parameters
	private boolean available;
	private String from;
	private String to;

	/**
	 * default constructor
	 */
	public ReservationDetails() {
		// default
	}

	/**
	 * @return the available
	 */
	public boolean getAvailable() {
		return available;
	}

	/**
	 * @param available the available to set
	 */
	public void setAvailable(boolean available) {
		this.available = available;
	}

	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * @return the to
	 */
	public String getTo() {
		return to;
	}

	/**
	 * @param to the to to set
	 */
	public void setTo(String to) {
		this.to = to;
	}


}
