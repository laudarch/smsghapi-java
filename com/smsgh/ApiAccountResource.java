// $Id: ApiAccountResource.java 0 1970-01-01 00:00:00Z mkwayisi $
package com.smsgh;
import java.util.List;
import java.util.ArrayList;
import com.smsgh.json.JsonValue;

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
			return new ApiAccountProfile(ApiHelper.getJson
				(this.smsghApi, "GET", "/v3/account/profile", null));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}
	
	/**
	 * Gets primary contact.
	 */
	public ApiAccountContact getPrimaryContact() throws ApiException {
		try {
			return new ApiAccountContact(ApiHelper.getJson
				(this.smsghApi, "GET", "/v3/account/primary_contact", null));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}
	
	/**
	 * Gets billing contact.
	 */
	public ApiAccountContact getBillingContact() throws ApiException {
		try {
			return new ApiAccountContact(ApiHelper.getJson
				(this.smsghApi, "GET", "/v3/account/billing_contact", null));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}
	
	/**
	 * Gets technical contact.
	 */
	public ApiAccountContact getTechnicalContact() throws ApiException {
		try {
			return new ApiAccountContact(ApiHelper.getJson
				(this.smsghApi, "GET", "/v3/account/technical_contact", null));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}
	
	/**
	 * Gets all account contacts.
	 */
	public List<ApiAccountContact> getContacts() throws ApiException {
		List<ApiAccountContact> aacs = new ArrayList<ApiAccountContact>(3);
		try {
			for (JsonValue val : ApiHelper.getJsonArray
				(this.smsghApi, "GET", "/v3/account/contacts", null))
				aacs.add(new ApiAccountContact(val.asObject()));
			return aacs;
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}
	
	/**
	 * Updates account contact.
	 */
	public void update(ApiAccountContact apiAccountContact)
		throws ApiException {
		try {
			if (apiAccountContact == null)
				throw new NullPointerException("apiAccountContact");
			ApiHelper.getData(this.smsghApi, "PUT", "/v3/account/contacts/"
				+ apiAccountContact.getAccountContactId(), apiAccountContact.toJson());
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}
	
	/**
	 * Gets all account services.
	 */
	public ApiList<ApiService> getServices() throws ApiException {
		return getServices(-1, -1);
	}
	
	/**
	 * Gets account services by page and pageSize.
	 */
	public ApiList<ApiService> getServices(int page, int pageSize)
		throws ApiException {
		return ApiHelper.getApiList
			(ApiService.class, this.smsghApi, "/v3/account/services", page, pageSize);
	}
	
	/**
	 * Gets account settings.
	 */
	public ApiSettings getSettings()
		throws ApiException {
		try {
			return new ApiSettings(ApiHelper.getJson
				(this.smsghApi, "GET", "/v3/account/settings", null));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}
	
	/**
	 * Updates account settings.
	 */
	public ApiSettings update(ApiSettings apiSettings)
		throws ApiException {
		try {
			if (apiSettings == null)
				throw new NullPointerException("apiSettings");
			return new ApiSettings(ApiHelper.getJson
				(this.smsghApi, "PUT", "/v3/account/settings", apiSettings.toJson()));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}
}
