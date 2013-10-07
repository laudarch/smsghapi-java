// $Id: ApiContactsResource.java 0 1970-01-01 00:00:00Z mkwayisi $
package com.smsgh;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class ApiContactsResource {
	/**
	 * Data fields.
	 */
	private SmsghApi apiHost;
	
	/**
	 * Primary constructor.
	 */
	public ApiContactsResource(SmsghApi apiHost) {
		this.apiHost = apiHost;
	}
	
	/**
	 * Gets all contacts.
	 */
	public ApiList<ApiContact> get()
		throws ApiException {
		return get(-1, -1, -1, null);
	}
	
	/**
	 * Gets contacts by groupId and filter.
	 */
	public ApiList<ApiContact> get(long groupId, String filter)
		throws ApiException {
		return get(-1, -1, groupId, filter);
	}
	
	/**
	 * Gets contacts by page and pageSize.
	 */
	public ApiList<ApiContact> get(int page, int pageSize)
		throws ApiException {
		return get(page, pageSize, -1, null);
	}
	
	/**
	 * Gets contacts by page, pagesize, groupId and filter.
	 */
	public ApiList<ApiContact> get
		(int page, int pageSize, long groupId, String filter)
		throws ApiException {
		String uri = "/v3/contacts";
		if (groupId > 0)
			uri += "?GroupId=" + groupId;
		try {
			if (filter != null)
				uri += (groupId > 0 ? "&" : "?") + "Filter="
					+ URLEncoder.encode(filter, "utf-8");
		} catch (UnsupportedEncodingException e) {
			throw new ApiException(e.getMessage());
		}
		return ApiHelper.getApiList(ApiContact.class,
			this.apiHost, uri, page, pageSize, uri.indexOf("?") > 0);
	}
	
	/**
	 * Gets contact by ID.
	 */
	public ApiContact get(long contactId)
		throws ApiException {
		try {
			return new ApiContact(ApiHelper.getJson
				(this.apiHost, "GET", "/v3/contacts/" + contactId, null));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}
	
	/**
	 * Gets contact by number.
	 */
	public ApiContact get(String number)
		throws ApiException {
		try {
			if (number == null)
				throw new NullPointerException("number");
			return new ApiContact(ApiHelper.getJson(this.apiHost,
				"GET", "/v3/contacts/" + number.replaceAll("[^\\d]", ""), null));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}
	
	/**
	 * Creates new contact.
	 */
	public ApiContact create(ApiContact apiContact)
		throws ApiException {
		try {
			if (apiContact == null)
				throw new NullPointerException("apiContact");
			return new ApiContact(ApiHelper.getJson(this.apiHost,
				"POST", "/v3/contacts", apiContact.toJson()));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}
	
	/**
	 * Updates contact.
	 */
	public void update(ApiContact apiContact)
		throws ApiException {
		try {
			if (apiContact == null)
				throw new NullPointerException("apiContact");
			ApiHelper.getJson(this.apiHost,
				"PUT", "/v3/contacts/" + apiContact.getContactId(),
					apiContact.toJson());
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}
	
	/**
	 * Deletes contact.
	 */
	public void deleteContact(long contactId)
		throws ApiException {
		ApiHelper.getData(this.apiHost,
			"DELETE", "/v3/contacts/" + contactId, null);
	}
	
	/**
	 * Get all contact groups.
	 */
	public ApiList<ApiContactGroup> getGroups()
		throws ApiException {
		return getGroups(-1, -1);
	}
	
	/**
	 * Gets contact groups by page and pageSize.
	 */
	public ApiList<ApiContactGroup> getGroups(int page, int pageSize)
		throws ApiException {
		return ApiHelper.getApiList
			(ApiContactGroup.class, this.apiHost, "/v3/contacts/groups", page, pageSize);
	}
	
	/**
	 * Gets contact group by ID.
	 */
	public ApiContactGroup getGroup(long groupId)
		throws ApiException {
		try {
			return new ApiContactGroup(ApiHelper.getJson
				(this.apiHost, "GET", "/v3/contacts/groups/" + groupId, null));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}
	
	/**
	 * Creates a new contact group.
	 */
	public ApiContactGroup create(ApiContactGroup apiContactGroup)
		throws ApiException {
		try {
			if (apiContactGroup == null)
				throw new NullPointerException("apiContactGroup");
			return new ApiContactGroup(ApiHelper.getJson(this.apiHost,
				"POST", "/v3/contacts/groups", apiContactGroup.toJson()));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}
	
	/**
	 * Updates contact group.
	 */
	public void update(ApiContactGroup apiContactGroup)
		throws ApiException {
		try {
			if (apiContactGroup == null)
				throw new NullPointerException("apiContactGroup");
			ApiHelper.getJson(this.apiHost, "PUT",
				"/v3/contacts/groups/" + apiContactGroup.getGroupId(),
					apiContactGroup.toJson());
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}
	
	/**
	 * Deletes contact group by ID.
	 */
	public void deleteGroup(long groupId)
		throws ApiException {
		ApiHelper.getData(this.apiHost,
			"DELETE", "/v3/contacts/groups/" + groupId, null);
	}
}
