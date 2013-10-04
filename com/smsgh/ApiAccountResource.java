// $Id: ApiAccountResource.java 0 1970-01-01 00:00:00Z mkwayisi $
package com.smsgh;

public class ApiAccountResource {
	/**
	 * Data fields.
	 */
	private SmsghApi smsghApi;
	
	/**
	 * Primary constructor.
	 */
	public ApiAccountResource(SmsghApi smsghApi) {
		this.smsghApi = smsghApi;
	}
	
	/**
	 * Gets account profile.
	 */
	public ApiAccountProfile getProfile() throws ApiException {
		try {
			return null;
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}
}
