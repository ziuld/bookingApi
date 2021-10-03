package com.colibridge.api.reservation.common;

/**
 * <h2>ManageError</h2>
 * <p>
 * error repsonse
 * </p>
 *
 * @author Luis Hernandez
 * @version 1.0
 * @since 2021-01-09
 */
public class ManageError {
	private String code;
	private String detail;

	public ManageError() {
		// constructor base
	}

	public ManageError(String code, String detail) {
		this.code = code;
		this.detail = detail;
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
	 * @return the detail
	 */
	public String getDetail() {
		return detail;
	}

	/**
	 * @param detail the detail to set
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}

}
