package com.zabuza.vente.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.zabuza.vente.exception.VenteErrorCode;
import com.zabuza.vente.exception.VenteException;

public final class Md5Utils {

	public static String getMd5(String str) throws VenteException {
		MessageDigest mdEnc;
		try {
			mdEnc = MessageDigest.getInstance("MD5");
			mdEnc.update(str.getBytes(), 0, str.length());
			return new BigInteger(1, mdEnc.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			throw new VenteException(VenteErrorCode.CONVERTION_ERROR);
		}

	}
}
