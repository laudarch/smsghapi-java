// $Id: ApiContactsResource.java 0 1970-01-01 00:00:00Z mkwayisi $
package com.smsgh;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Represents an API contacts resource.
 * 
 * @author Michael Kwayisi
 */
public class ApiContactsResource {
	private SmsghApi apiHost;
	/**
	 * Initializes a new instance of this class.
	 */
	public ApiContactsResource(SmsghApi apiHost) {
		this.apiHost = apiHost;
	}

	/**
	 * Retrieves all contacts.
	 * 
	 * @return API list of contacts.
	 * @throws ApiException if an error occurs.
	 */
	public ApiList<ApiContact> get() throws ApiException {
		return get(-1, -1, -1, null);
	}

	/**
	 * Retrieves contacts by group ID and filter.
	 * 
	 * @param groupId the ID of the group to search within.
	 * @param filter name filter to apply to contacts.
	 * @return API list of contacts.
	 * @throws ApiException if an error occurs.
	 */
	public ApiList<ApiContact> get(long groupId, String filter) throws ApiException {
		return get(-1, -1, groupId, filter);
	}

	/**
	 * Retrieves contacts by page and page size.
	 * 
	 * @param page one-based index of the page to query.
	 * @param pageSize maximum number of entries in a page.
	 * @return API list of contacts.
	 * @throws ApiException if an error occurs.
	 */
	public ApiList<ApiContact> get(int page, int pageSize) throws ApiException {
		return get(page, pageSize, -1, null);
	}

	/**
	 * Retrieves contacts by page, page size, group ID and filter.
	 * 
	 * @param page one-based index of the page to query.
	 * @param pageSize maximum number of entries in a page.
	 * @param groupId the ID of contact group to search within.
	 * @param filter name filter to apply to contacts.
	 * @return API list of contacts.
	 * @throws ApiException if an error occurs.
	 */
	public ApiList<ApiContact> get(int page, int pageSize, long groupId, String filter) throws ApiException {
		String uri = "/" + this.apiHost.getContextPath() + "/contacts/";
		if(apiHost.getContextPath() == null || apiHost.getContextPath().length() == 0)
			uri = "/contacts/";
		if (groupId > 0)
			uri += "?GroupId=" + groupId;
		try {
			if (filter != null)
				uri += (groupId > 0 ? "&" : "?") + "Filter=" + URLEncoder.encode(filter, "utf-8");
		} catch (UnsupportedEncodingException e) {
			throw new ApiException(e.getMessage());
		}
		return ApiHelper.getApiList(ApiContact.class, this.apiHost, uri, page, pageSize, uri.indexOf("?") > 0);
	}

	/**
	 * Retrieves a contact by ID.
	 * 
	 * @param contactId ID of the contact to query.
	 * @return instance of ApiContact representing the queried contact.
	 * @throws ApiException if an error occurs.
	 */
	public ApiContact get(long contactId) throws ApiException {
		String uri = "/" + this.apiHost.getContextPath() + "/contacts/";
		if(apiHost.getContextPath() == null || apiHost.getContextPath().length() == 0)
			uri = "/contacts/";
		
		try {
			return new ApiContact(ApiHelper.getJson(this.apiHost, "GET", uri + contactId, null));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}

	/**
	 * Retrieves a contact by phone number.
	 * 
	 * @param number phone number of the contact to query.
	 * @return instance of ApiContact representing the queried contact.
	 * @throws ApiException if an error occurs.
	 */
/*	public ApiContact get(String number) throws ApiException {
		try {
			if (number == null)
				throw new NullPointerException("number");
			//return new ApiContact(ApiHelper.getJson(this.apiHost, "GET", "/v3/contacts/" + number.replaceAll("[^\\d]", ""), null));
			String uri = "/" + this.apiHost.getVersion() + "/contacts/";
			if(apiHost.getVersion() == null || apiHost.getVersion().length() == 0)
				uri = "/contacts/";
			
			return new ApiContact(ApiHelper.getJson(this.apiHost, "GET", uri + number.trim(), null));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}*/

	/**
	 * Creates a new contact.
	 * 
	 * @param apiContact the contact to create.
	 * @return instance of ApiContact representing the created contact.
	 * @throws ApiException if an error occurs.
	 */
	public ApiContact create(ApiContact apiContact) throws ApiException {
		try {
			if (apiContact == null)
				throw new NullPointerException("apiContact");
			
			String uri = "/" + this.apiHost.getContextPath() + "/contacts/";
			if(apiHost.getContextPath() == null || apiHost.getContextPath().length() == 0)
				uri = "/contacts/";
			
			return new ApiContact(ApiHelper.getJson(this.apiHost, "POST", uri, apiContact.toJson()));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}

	/**
	 * Updates details of a contact.
	 * 
	 * @param apiContact instace of the API contact to update.
	 * @throws ApiException if an error occurs.
	 */
	public void update(ApiContact apiContact) throws ApiException {
		try {
			if (apiContact == null)
				throw new NullPointerException("apiContact");
			String uri = "/" + this.apiHost.getContextPath() + "/contacts/";
			if(apiHost.getContextPath() == null || apiHost.getContextPath().length() == 0)
				uri = "/contacts/";
			
			ApiHelper.getJson(this.apiHost, "PUT", uri + apiContact.getContactId(), apiContact.toJson());
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}

	/**
	 * Deletes an API contact.
	 * 
	 * @param contactId ID of the contact to delete.
	 * @throws ApiException if an error occurs.
	 */
	public void deleteContact(long contactId) throws ApiException {
		String uri = "/" + this.apiHost.getContextPath() + "/contacts/";
		if(apiHost.getContextPath() == null || apiHost.getContextPath().length() == 0)
			uri = "/contacts/";
		
		ApiHelper.getData(this.apiHost, "DELETE", uri + contactId, null);
	}

	/**
	 * Retrieves all contact groups.
	 * 
	 * @return an API list of contact groups.
	 * @throws ApiException if an error occurs.
	 */
	public ApiList<ApiContactGroup> getGroups() throws ApiException {
		return getGroups(-1, -1);
	}

	/**
	 * Retrieves contact groups by page and page size.
	 * 
	 * @param page one-based index of the page to query.
	 * @param pageSize maximum number of entries in a page.
	 * @return an API list of contact groups.
	 * @throws ApiException if an error occurs.
	 */
	public ApiList<ApiContactGroup> getGroups(int page, int pageSize) throws ApiException {
		String uri = "/" + this.apiHost.getContextPath() + "/contacts/";
		if(apiHost.getContextPath() == null || apiHost.getContextPath().length() == 0)
			uri = "/contacts/";
		
		return ApiHelper.getApiList(ApiContactGroup.class, this.apiHost,  uri + "groups/", page, pageSize);
	}

	/**
	 * Retrieves details of a contact group by ID.
	 * 
	 * @param groupId ID of the contact group to query.
	 * @return an instance of ApiContactGroup representing the queried group.
	 * @throws ApiException if an error occurs.
	 */
	public ApiContactGroup getGroup(long groupId) throws ApiException {
		try {
			String uri = "/" + this.apiHost.getContextPath() + "/contacts/";
			if(apiHost.getContextPath() == null || apiHost.getContextPath().length() == 0)
				uri = "/contacts/";
			
			return new ApiContactGroup(ApiHelper.getJson(this.apiHost, "GET",  uri + "groups/" + groupId, null));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}

	/**
	 * Creates a new contact group.
	 * 
	 * @param apiContactGroup the API contact group to create.
	 * @return instance of ApiContactGroup representing the created group.
	 * @throws ApiException if an error occurs.
	 */
	public ApiContactGroup create(ApiContactGroup apiContactGroup) throws ApiException {
		try {
			if (apiContactGroup == null)
				throw new NullPointerException("apiContactGroup");
			String uri = "/" + this.apiHost.getContextPath() + "/contacts/";
			if(apiHost.getContextPath() == null || apiHost.getContextPath().length() == 0)
				uri = "/contacts/";
			
			return new ApiContactGroup(ApiHelper.getJson(this.apiHost, "POST",  uri+ "groups/", apiContactGroup.toJson()));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}

	/**
	 * Updates the details of a contact group.
	 * 
	 * @param apiContactGroup the API contact group to update.
	 * @throws ApiException if an error occurs.
	 */
	public void update(ApiContactGroup apiContactGroup) throws ApiException {
		try {
			if (apiContactGroup == null)
				throw new NullPointerException("apiContactGroup");
			String uri = "/" + this.apiHost.getContextPath() + "/contacts/";
			if(apiHost.getContextPath() == null || apiHost.getContextPath().length() == 0)
				uri = "/contacts/";
			
			ApiHelper.getJson(this.apiHost, "PUT", uri + "groups/" + apiContactGroup.getGroupId(), apiContactGroup.toJson());
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}

	/**
	 * Deletes a contact group.
	 * 
	 * @param groupId ID of the contact group to delete.
	 * @throws ApiException if an error occurs.
	 */
	public void deleteGroup(long groupId) throws ApiException {
		String uri = "/" + this.apiHost.getContextPath() + "/contacts/";
		if(apiHost.getContextPath() == null || apiHost.getContextPath().length() == 0)
			uri = "/contacts/";
		
		ApiHelper.getData(this.apiHost, "DELETE",  uri + "groups/" + groupId, null);
	}
}
