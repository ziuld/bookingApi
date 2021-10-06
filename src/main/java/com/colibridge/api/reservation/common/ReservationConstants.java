package com.colibridge.api.reservation.common;

/**
 * <h2>ReservationConstants</h2>
 * <p>
 * Constants
 * </p>
 *
 * @author Luis Hernandez
 * @version 1.0
 * @since 2021-01-09
 */
public class ReservationConstants {
	/**
	 * default constructor
	 */
	public ReservationConstants() {
		// default
	}

	// General constants
	public static final String SUCCESS = "SUCCESS";
	public static final String FAILD = "FAILD";
	public static final String ERROR_REPOSITORY_DETAILL = "reservationRepositoryError";
	public static final String ERROR_CRONTROLLER = "GuestController.getGuest";
	public static final String GENERAL_ERROR_CODE = "01";
	public static final String MESSAGE_FALSE = "I am sorry, there is a reservation between: ";
	public static final String MESSAGE_TRUE = "It's avaiable.";
	public static final String MESSAGE_OUT_OF_RANGE = "Reservations can only be made the day after the request or 30 days in advance and no more than 3 days.";
	public static final String AND = " and ";
	public static final String DOT = ".";
	public static final String INVALID_RANGE = "The date range is invalid";
	public static final String BOOKING_OK = "You are booked already.";
	public static final String MESSAGE_GUEST_DFF = "You can't change Guest.";
	public static final String MESSAGE_RESERVATION_NO_EXIST = "The reservation does not exist.";
	public static final String MESSAGE_GUEST_EXIST = "The guest already exists.";

}
