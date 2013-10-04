// $Id: ApiHelper.java 0 1970-01-01 00:00:00Z mkwayisi $
package com.smsgh;
import com.smsgh.json.JsonObject;
import com.smsgh.json.JsonArray;

public class ApiHelper {
	/**
	 * getData
	 */
	public static String getData
		(SmsghApi apiHost, String method, String uri, String data)
		throws ApiException {
		ApiResponse apiResponse = new ApiRequest
			(apiHost.getHostname(), apiHost.getPort(),
				apiHost.isHttps() ? "ssl" : "tcp", apiHost.getTimeout(),
					apiHost.getClientId(), apiHost.getClientSecret())
			.setMethod(method)
			.setUri(uri)
			.setHeader("accept", "application/json")
			.send(data);
		if (apiResponse.getStatus() > 199 && apiResponse.getStatus() < 300)
			return apiResponse.getBody();
		throw new ApiException("Request failed: "
			+ apiResponse.getStatus() + " " + apiResponse.getReason());
	}
	
	/**
	 * getJson
	 */
	public static JsonObject getJson
		(SmsghApi apiHost, String method, String uri, String data)
		throws ApiException {
		return JsonObject.readFrom(getData(apiHost, method, uri, data));
	}
	
	/**
	 * getJsonArray
	 */
	public static JsonArray getJsonArray
		(SmsghApi apiHost, String method, String uri, String data)
		throws ApiException {
		return JsonArray.readFrom(getData(apiHost, method, uri, data));
	}
	
	/**
	 * getApiList
	 */
	public static <T> ApiList<T> getApiList
		(Class<T> clazz, SmsghApi apiHost, String uri, int page, int pageSize)
		throws ApiException {
		if (page > 0)
			uri += "?Page=" + page;
		if (pageSize > 0)
			uri += (page > 0 ? "&" : "?") + "PageSize=" + pageSize;
		try {
			return new ApiList<T>(getJson(apiHost, "GET", uri, null));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}
}
