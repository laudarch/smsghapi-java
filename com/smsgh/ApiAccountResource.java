// $Id: ApiAccountResource.java 0 1970-01-01 00:00:00Z mkwayisi $
package com.smsgh;
import java.util.List;
import java.util.ArrayList;
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
	 * @param  smsghApi  an SMSGH API host.
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
	public ApiAccountProfile getProfile()
		throws ApiException {
		try {
			return new ApiAccountProfile(ApiHelper.getJson
				(this.smsghApi, "GET", "/v3/account/profile", null));
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
	public ApiAccountContact getPrimaryContact()
		throws ApiException {
		try {
			return new ApiAccountContact(ApiHelper.getJson
				(this.smsghApi, "GET", "/v3/account/primary_contact", null));
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
	public ApiAccountContact getBillingContact()
		throws ApiException {
		try {
			return new ApiAccountContact(ApiHelper.getJson
				(this.smsghApi, "GET", "/v3/account/billing_contact", null));
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
	public ApiAccountContact getTechnicalContact()
		throws ApiException {
		try {
			return new ApiAccountContact(ApiHelper.getJson
				(this.smsghApi, "GET", "/v3/account/technical_contact", null));
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
	 * Updates an API account contact.
	 *
	 * @param  apiAccountContact the account contact to update.
	 * @throws ApiException if an error occurs.
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
	 * Retrieves all account services.
	 *
	 * @return an API list of API services.
	 * @throws ApiException if an error occurs.
	 */
	public ApiList<ApiService> getServices()
		throws ApiException {
		return getServices(-1, -1);
	}
	
	/**
	 * Retrieves account services by page and page size.
	 *
	 * @param  page     one-based index of the page to query.
	 * @param  pageSize maximum number of entries in a page.
	 * @return an API list of API services.
	 * @throws ApiException if an error occurs.
	 */
	public ApiList<ApiService> getServices(int page, int pageSize)
		throws ApiException {
		return ApiHelper.getApiList
			(ApiService.class, this.smsghApi, "/v3/account/services", page, pageSize);
	}
	
	/**
	 * Retrieves account settings.
	 *
	 * @return API account settings.
	 * @throws ApiException if an error occurs.
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
	 * Updates an API account settings.
	 *
	 * @param  apiSettings  the API account settings to update.
	 * @return API account settings.
	 * @throws ApiException if an error occurs.
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
	
	/**
	 * Retrieves all API child accounts.
	 *
	 * @return an API list of API child account.
	 * @throws ApiException if an error occurs.
	 */
	public ApiList<ApiChildAccount> getChildAccounts()
		throws ApiException {
		return getChildAccounts(-1, -1);
	}
	
	/**
	 * Retrieves API child accounts by page and page size.
	 *
	 * @param  page     one-based index of the page to query.
	 * @param  pageSize maximum number of entries in a page.
	 * @return an API list of API child accounts.
	 * @throws ApiException if an error occurs.
	 */
	public ApiList<ApiChildAccount> getChildAccounts
		(int page, int pageSize) throws ApiException {
		return ApiHelper.getApiList(ApiChildAccount.class,
			this.smsghApi, "/v3/account/childaccounts", page, pageSize);
	}
	
	/**
	 * Retrieves all API account invoices.
	 *
	 * @return an API list of API invoices.
	 * @throws ApiException if an error occurs.
	 */
	public ApiList<ApiInvoice> getInvoices()
		throws ApiException {
		return getInvoices(-1, -1);
	}
	
	/**
	 * Retrieves account invoices by page and page size.
	 *
	 * @param  page     one-based index of the page to query.
	 * @param  pageSize maximum number of entries in a page.
	 * @return an API list of account invoices.
	 * @throws ApiException if an error occurs.
	 */
	public ApiList<ApiInvoice> getInvoices(int page, int pageSize)
		throws ApiException {
		return ApiHelper.getApiList(ApiInvoice.class,
			this.smsghApi, "/v3/account/invoices", page, pageSize);
	}
}
