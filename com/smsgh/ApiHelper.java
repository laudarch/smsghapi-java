// $Id: ApiHelper.java 0 1970-01-01 00:00:00Z mkwayisi $
package com.smsgh;

import com.smsgh.json.JsonArray;
import com.smsgh.json.JsonObject;

public class ApiHelper {
	/**
	 * Constructor.
	 */
	private ApiHelper() {}

	/**
	 * getData
	 */
	public static String getData(SmsghApi apiHost, String method, String uri, String data) throws ApiException {
		ApiResponse apiResponse = new ApiRequest(apiHost.getHostname(), apiHost.getPort(), apiHost.isHttps() ? "ssl" : "tcp", apiHost.getTimeout(), apiHost.getClientId(), apiHost.getClientSecret()).setMethod(method).setUri(uri).setHeader("Accept", "application/json").setHeader("Content-Type", "application/json").send(data);
		if (apiResponse.getStatus() > 199 && apiResponse.getStatus() < 300)
			return apiResponse.getBody();
		throw new ApiException("Request failed: " + apiResponse.getStatus() + " " + apiResponse.getReason());
	}

	/**
	 * getJson
	 */
	public static JsonObject getJson(SmsghApi apiHost, String method, String uri, String data) throws ApiException {
		return JsonObject.readFrom(getData(apiHost, method, uri, data));
	}

	/**
	 * getJsonArray
	 */
	public static JsonArray getJsonArray(SmsghApi apiHost, String method, String uri, String data) throws ApiException {
		return JsonArray.readFrom(getData(apiHost, method, uri, data));
	}

	/**
	 * getApiList
	 */
	public static <T> ApiList<T> getApiList(Class<T> clazz, SmsghApi apiHost, String uri, int page, int pageSize) throws ApiException {
		return getApiList(clazz, apiHost, uri, page, pageSize, false);
	}

	/**
	 * getApiList
	 */
	public static <T> ApiList<T> getApiList(Class<T> clazz, SmsghApi apiHost, String uri, int page, int pageSize, boolean hasQ) throws ApiException {
		if (page > 0) {
			uri += (hasQ ? "&" : "?") + "Page=" + page;
			if (!hasQ)
				hasQ = true;
		}
		if (pageSize > 0)
			uri += (hasQ ? "&" : "?") + "PageSize=" + pageSize;
		try {
			return new ApiList<T>(getJson(apiHost, "GET", uri, null));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}	
}
