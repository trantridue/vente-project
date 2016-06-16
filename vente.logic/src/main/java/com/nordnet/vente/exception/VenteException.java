package com.nordnet.vente.exception;

/**
 * Exception contenant les inforamtions des problems de vente.
 * 
 * @author Due
 * 
 */
public class VenteException extends Exception {

	/**
	 * serial Version UID.
	 */
	private static final long serialVersionUID = 1L;

	private int errorCode;

	private String errorMessage;

	/**
	 * Constructeur par default.
	 */
	public VenteException(int errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	/**
	 * @return the errorCode
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode
	 *            the errorCode to set
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage
	 *            the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
