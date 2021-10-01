package com.colibridge.api.reservation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reservation")
public class ReservationEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private String id;

	@Column(name = "guest_id")
	private String guestId;

	@Column(name = "start_date")
	private String startDate;

	@Column(name = "end_date")
	private String endDate;

	@Column(name = "ts_created")
	private String tsCreated;

	@Column(name = "ts_updated")
	private String tsUpdated;

	@Column(name = "details")
	private String details;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the guestId
	 */
	public String getGuestId() {
		return guestId;
	}

	/**
	 * @param guestId the guestId to set
	 */
	public void setGuestId(String guestId) {
		this.guestId = guestId;
	}

	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the tsCreated
	 */
	public String getTsCreated() {
		return tsCreated;
	}

	/**
	 * @param tsCreated the tsCreated to set
	 */
	public void setTsCreated(String tsCreated) {
		this.tsCreated = tsCreated;
	}

	/**
	 * @return the tsUpdated
	 */
	public String getTsUpdated() {
		return tsUpdated;
	}

	/**
	 * @param tsUpdated the tsUpdated to set
	 */
	public void setTsUpdated(String tsUpdated) {
		this.tsUpdated = tsUpdated;
	}

	/**
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * @param details the details to set
	 */
	public void setDetails(String details) {
		this.details = details;
	}

}
