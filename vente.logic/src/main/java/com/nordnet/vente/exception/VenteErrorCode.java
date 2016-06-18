package com.nordnet.vente.exception;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * This enum contains all the error code the <strong>Topaze</strong> project need.
 * 
 * @author mazemzemi
 * 
 */
public enum VenteErrorCode {

	/**
	 * Cannot delete user with id = %s
	 */
	CANNOT_DELETE_USER_ID("1.0.1"), CONVERTION_ERROR("1.0.2"), USERNAME_NOT_FOUND("1.0.3"), CANNOT_UPDATE_USER_BY_USERNAME(
			"1.0.4"), OVER_LIMIT_NBR_USER("1.0.5");

	/**
	 * The error code.
	 */
	private final String errorCode;

	/**
	 * The error message.
	 */
	private final String message;

	/**
	 * Declaration du log.
	 */
	private final Log LOGGER = LogFactory.getLog(VenteErrorCode.class);

	/**
	 * Default constructor.
	 * 
	 * @param errorCode
	 *            the error code.
	 */
	private VenteErrorCode(final String errorCode) {
		this.errorCode = errorCode;

		Properties prop = new Properties();
		try (InputStream input = getClass().getClassLoader().getResourceAsStream("vente-exceptions.properties")) {
			prop.load(input);

		} catch (IOException e) {
			LOGGER.error(e);
		}
		message = prop.getProperty(errorCode);
	}

	/**
	 * Return the error code.
	 * 
	 * @return the error code.
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * Return the error message.
	 * 
	 * @return the error message.
	 */
	public String getMessage(final Object... parameters) {
		return String.format(message, parameters);
	}

	@Override
	public String toString() {
		return super.toString() + "[errorCode=" + errorCode + "]";
	}

}
