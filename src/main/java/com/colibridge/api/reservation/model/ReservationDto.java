package com.colibridge.api.reservation.model;

/**
* <h2>ReservationDto</h2>
* <p>DTO of reservation</p>
*
* @author  Luis Hernandez
* @version 1.0
* @since   2021-01-09
*/
public class ReservationDto {
	
	private String code;
	private String from;
	private String To;
	private String Updated;
	private String comment;
	
	public ReservationDto(){
		//contructor
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
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
		return To;
	}

	/**
	 * @param to the to to set
	 */
	public void setTo(String to) {
		To = to;
	}

	/**
	 * @return the updated
	 */
	public String getUpdated() {
		return Updated;
	}

	/**
	 * @param updated the updated to set
	 */
	public void setUpdated(String updated) {
		Updated = updated;
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
