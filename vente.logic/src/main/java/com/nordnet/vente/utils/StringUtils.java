package com.nordnet.vente.utils;

import com.nordnet.common.valueObject.utils.Null;

public class StringUtils {

	public static String getNotNullString(String source, String dest) {
		return Null.isNullOrEmpty(source) ? dest : source;
	}
}
