package com.nordnet.vente.exception;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;

import nordnet.tools.converter.exceptions.ConverterException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.nordnet.common.valueObject.exception.InfoErreur;

@ControllerAdvice
public class VenteExceptionHandler {

	/**
	 * 
	 * Gerer le cas ou on a une {@link VenteException}.
	 * 
	 * @param req
	 *            requete HttpServletRequest.
	 * @param ex
	 *            exception
	 * @return {@link InfoErreur}
	 * @throws URISyntaxException
	 */
	@ResponseStatus(value = BAD_REQUEST)
	@ExceptionHandler({ VenteException.class })
	@ResponseBody
	InfoErreur handleVenteException(final HttpServletRequest req, final VenteException ex) {
		InfoErreur infoErreur = ex.getInfoErreur();
		if (infoErreur != null) {
			return infoErreur;
		}
		return InfoErreur.builder().url(req.getRequestURI()).errorCode(ex.getOpaleErrorCode().getErrorCode())
				.errorMessage(ex.getLocalizedMessage()).build();
	}

	@ResponseStatus(value = BAD_REQUEST)
	@ExceptionHandler({ ConverterException.class })
	@ResponseBody
	InfoErreur handleVenteException(final HttpServletRequest req, final ConverterException ex) {

		if (ex.getCause() instanceof VenteException) {
			return handleVenteException(req, (VenteException) ex.getCause());
		}

		return InfoErreur.builder().url(req.getRequestURI()).errorCode(VenteErrorCode.CONVERTION_ERROR.getErrorCode())
				.errorMessage(ex.getLocalizedMessage() + ": " + ex.getCause().getLocalizedMessage()).build();
	}

}
