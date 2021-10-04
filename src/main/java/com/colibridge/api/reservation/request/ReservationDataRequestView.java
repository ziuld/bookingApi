package com.colibridge.api.reservation.request;

/**
 * <h2>ReservationDataRequestView</h2>
 * <p>
 * Request of reservation
 * </p>
 *
 * @author Luis Hernandez
 * @version 1.0
 * @since 2021-01-09
 */
public class ReservationDataRequestView {
	// ReservationDataRequestView parameters
	private Integer guestId;
	private String from;
	private String to;
	private String comment;

	/**
	 * default constructor
	 */
	public ReservationDataRequestView() {
		// default
	}

	/**
	 * @return the guestId
	 */
	public Integer getGuestId() {
		return guestId;
	}

	/**
	 * @param guestId the guestId to set
	 */
	public void setGuestId(Integer guestId) {
		this.guestId = guestId;
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

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
}
