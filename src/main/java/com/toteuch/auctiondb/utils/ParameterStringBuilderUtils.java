package com.toteuch.auctiondb.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

public class ParameterStringBuilderUtils {
	public static String getParamsString(Map<String, String> params) {
		StringBuilder result = new StringBuilder();
		if (params.size() > 0) {
			result.append("?");
		}
		for (Map.Entry<String, String> entry : params.entrySet()) {
			try {
				result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
				result.append("=");
				result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
				result.append("&");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		String resultString = result.toString();
		return resultString.length() > 0 ? resultString.substring(0, resultString.length() - 1) : resultString;
	}
}
