package com.colibridge.api.reservation.request;

/**
 * <h2>ReservationNewGuestDataRequestView</h2>
 * <p>
 * data of new guest reservation
 * </p>
 *
 * @author Luis Hernandez
 * @version 1.0
 * @since 2021-01-09
 */
public class ReservationNewGuestDataRequestView extends GuestDataRequestView{
	// ReservationNewGuestDataRequestView parameters
	private String from;
	private String to;

	/**
	 * default constructor
	 */
	public ReservationNewGuestDataRequestView() {
		// default
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
