package com.nordnet.vente.exception;

import com.nordnet.common.valueObject.exception.InfoErreur;

/**
 * La classe d exception pour opale.
 *
 * @author anisselmane.
 *
 */
public class VenteException extends Exception {

	/**
	 * Serialization token.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Code d'erreur enum.
	 */
	private final VenteErrorCode venteErrorCode;

	/**
	 * Code d'erreur.
	 */
	private final InfoErreur infoErreur;

	/**
	 * Cause d'erreur.
	 */
	private final Throwable errorCause;

	/**
	 * @return code d'erreur.
	 */

	/**
	 * @return cause d'erreur.
	 */
	public Throwable getErrorCause() {
		return errorCause;
	}

	/**
	 * Constructor with {@link VenteErrorCode}.
	 *
	 * @param venteErrorCode
	 *            Opale error code.
	 * @param parameters
	 *            Parameters.
	 */
	public VenteException(final VenteErrorCode venteErrorCode, final Object... parameters) {

		this(null, venteErrorCode, null, parameters);
	}

	public VenteException(final VenteErrorCode venteErrorCode, final Throwable errorCause, final Object... parameters) {

		this(null, venteErrorCode, errorCause, parameters);
	}

	/**
	 *
	 * @param infoErreur
	 *            .
	 */
	public VenteException(final InfoErreur infoErreur, final VenteErrorCode venteErrorCode, final Throwable errorCause,
			final Object... parameters) {
		super(venteErrorCode.getMessage(parameters));
		this.infoErreur = infoErreur;
		this.venteErrorCode = venteErrorCode;
		this.errorCause = errorCause;
	}

	/**
	 *
	 * @return {@link VenteErrorCode}.
	 */
	public VenteErrorCode getOpaleErrorCode() {
		return venteErrorCode;
	}

	/**
	 *
	 * @return {@link InfoErreur}.
	 */
	public InfoErreur getInfoErreur() {
		return infoErreur;
	}

}
