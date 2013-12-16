// $Id: ApiAccountResource.java 0 1970-01-01 00:00:00Z mkwayisi $
package com.smsgh;

import java.util.ArrayList;
import java.util.List;

import com.smsgh.json.JsonValue;

/**
 * Represents an API account resource.
 * 
 * @author Michael Kwayisi
 */
public class ApiAccountResource {
	private SmsghApi smsghApi;

	/**
	 * Initializes a new instance of the ApiAccountResource class.
	 * 
	 * @param smsghApi an SMSGH API host.
	 */
	public ApiAccountResource(SmsghApi smsghApi) {
		this.smsghApi = smsghApi;
	}

	/**
	 * Retrieves account profile.
	 * 
	 * @return the API account profile.
	 * @throws ApiException if an error occurs.
	 */
	public ApiAccountProfile getProfile() throws ApiException {
		String uri = "/" + this.smsghApi.getContextPath() + "/account/profile";
		if(smsghApi.getContextPath() == null || smsghApi.getContextPath().length() == 0)
			uri = "/account/profile";
		try {
			return new ApiAccountProfile(ApiHelper.getJson(this.smsghApi, "GET", uri, null));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}

	/**
	 * Retrieves primary contact.
	 * 
	 * @return an API account contact.
	 * @throws ApiException if an error occurs.
	 */
	public ApiAccountContact getPrimaryContact() throws ApiException {
		String uri = "/" + this.smsghApi.getContextPath() + "/account/primary_contact";
		if(smsghApi.getContextPath() == null || smsghApi.getContextPath().length() == 0)
			uri = "/account/primary_contact";
		try {
			return new ApiAccountContact(ApiHelper.getJson(this.smsghApi, "GET", uri, null));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}

	/**
	 * Retrieves billing contact.
	 * 
	 * @return an API account contact.
	 * @throws ApiException if an error occurs.
	 */
	public ApiAccountContact getBillingContact() throws ApiException {
		String uri = "/" + this.smsghApi.getContextPath() + "/account/billing_contact";
		if(smsghApi.getContextPath() == null || smsghApi.getContextPath().length() == 0)
			uri = "/account/billing_contact";
		
		try {
			return new ApiAccountContact(ApiHelper.getJson(this.smsghApi, "GET", uri, null));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}

	/**
	 * Retrieves technical contact.
	 * 
	 * @return an API account contact.
	 * @throws ApiException if an error occurs.
	 */
	public ApiAccountContact getTechnicalContact() throws ApiException {
		String uri = "/" + this.smsghApi.getContextPath() + "/account/technical_contact";
		if(smsghApi.getContextPath() == null || smsghApi.getContextPath().length() == 0)
			uri = "/account/technical_contact";
		
		try {
			return new ApiAccountContact(ApiHelper.getJson(this.smsghApi, "GET", uri, null));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}

	/**
	 * Retrieves all account contacts.
	 * 
	 * @return a list of API account contacts.
	 * @throws ApiException if an error occurs.
	 */
	public List<ApiAccountContact> getContacts() throws ApiException {
		List<ApiAccountContact> aacs = new ArrayList<ApiAccountContact>(3);
		String uri = "/" + this.smsghApi.getContextPath() + "/account/contacts";
		if(smsghApi.getContextPath() == null || smsghApi.getContextPath().length() == 0)
			uri = "/account/contacts";
		
		try {
			for (JsonValue val : ApiHelper.getJsonArray(this.smsghApi, "GET", uri, null))
				aacs.add(new ApiAccountContact(val.asObject()));
			return aacs;
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}

	/**
	 * Updates an API account contact.
	 * 
	 * @param apiAccountContact the account contact to update.
	 * @throws ApiException if an error occurs.
	 */
	public void update(ApiAccountContact apiAccountContact) throws ApiException {
		try {
			if (apiAccountContact == null)
				throw new NullPointerException("apiAccountContact");
			
			String uri =  "/" + this.smsghApi.getContextPath() + "/account/contacts/" + apiAccountContact.getAccountContactId();
			if(smsghApi.getContextPath() == null || smsghApi.getContextPath().length() == 0)
				uri = "/account/contacts/" + apiAccountContact.getAccountContactId();
			ApiHelper.getData(this.smsghApi, "PUT", uri, apiAccountContact.toJson());
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}

	/**
	 * Retrieves all account services.
	 * 
	 * @return an API list of API services.
	 * @throws ApiException if an error occurs.
	 */
	public ApiList<ApiService> getServices() throws ApiException {
		return getServices(-1, -1);
	}

	/**
	 * Retrieves account services by page and page size.
	 * 
	 * @param page one-based index of the page to query.
	 * @param pageSize maximum number of entries in a page.
	 * @return an API list of API services.
	 * @throws ApiException if an error occurs.
	 */
	public ApiList<ApiService> getServices(int page, int pageSize) throws ApiException {
		String uri = "/" + this.smsghApi.getContextPath() + "/account/services";
		if(smsghApi.getContextPath() == null || smsghApi.getContextPath().length() == 0)
			uri = "/account/services";

		return ApiHelper.getApiList(ApiService.class, this.smsghApi, uri, page, pageSize);
	}

	/**
	 * Retrieves account settings.
	 * 
	 * @return API account settings.
	 * @throws ApiException if an error occurs.
	 */
	public ApiSettings getSettings() throws ApiException {
		String uri = "/" + this.smsghApi.getContextPath() + "/account/settings";
		if(smsghApi.getContextPath() == null || smsghApi.getContextPath().length() == 0)
			uri = "/account/settings";
		
		try {
			return new ApiSettings(ApiHelper.getJson(this.smsghApi, "GET", uri, null));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}

	/**
	 * Updates an API account settings.
	 * 
	 * @param apiSettings the API account settings to update.
	 * @return API account settings.
	 * @throws ApiException if an error occurs.
	 */
	public ApiSettings update(ApiSettings apiSettings) throws ApiException {
		String uri = "/" + this.smsghApi.getContextPath() + "/account/settings";
		if(smsghApi.getContextPath() == null || smsghApi.getContextPath().length() == 0)
			uri = "/account/settings";
		
		try {
			if (apiSettings == null)
				throw new NullPointerException("apiSettings");
			return new ApiSettings(ApiHelper.getJson(this.smsghApi, "PUT", uri, apiSettings.toJson()));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}

/*	*//**
	 * Retrieves all API child accounts.
	 * 
	 * @return an API list of API child account.
	 * @throws ApiException if an error occurs.
	 *//*
	public ApiList<ApiChildAccount> getChildAccounts() throws ApiException {
		return getChildAccounts(-1, -1);
	}*/

/*	*//**
	 * Retrieves API child accounts by page and page size.
	 * 
	 * @param page one-based index of the page to query.
	 * @param pageSize maximum number of entries in a page.
	 * @return an API list of API child accounts.
	 * @throws ApiException if an error occurs.
	 *//*
	public ApiList<ApiChildAccount> getChildAccounts(int page, int pageSize) throws ApiException {
		return ApiHelper.getApiList(ApiChildAccount.class, this.smsghApi, "/v3/account/childaccounts", page, pageSize);
	}*/

	/**
	 * Retrieves all API account invoices.
	 * 
	 * @return an API list of API invoices.
	 * @throws ApiException if an error occurs.
	 */
	public ApiList<ApiInvoice> getInvoices() throws ApiException {
		return getInvoices(-1, -1);
	}

	/**
	 * Retrieves account invoices by page and page size.
	 * 
	 * @param page one-based index of the page to query.
	 * @param pageSize maximum number of entries in a page.
	 * @return an API list of account invoices.
	 * @throws ApiException if an error occurs.
	 */
	public ApiList<ApiInvoice> getInvoices(int page, int pageSize) throws ApiException {
		String uri = "/" + this.smsghApi.getContextPath() + "/account/invoices";
		if(smsghApi.getContextPath() == null || smsghApi.getContextPath().length() == 0)
			uri = "/account/invoices";
		
		return ApiHelper.getApiList(ApiInvoice.class, this.smsghApi, uri, page, pageSize);
	}
}
