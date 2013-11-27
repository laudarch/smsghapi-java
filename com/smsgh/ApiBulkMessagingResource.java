// $Id: ApiBulkMessagingResource.java 0 1970-01-01 00:00:00Z mkwayisi $
package com.smsgh;

/**
 * Represents an API bulk messaging resource.
 * 
 * @author Michael Kwayisi
 */
public class ApiBulkMessagingResource {
	private SmsghApi apiHost;

	/**
	 * Initializes a new instance of this class.
	 */
	public ApiBulkMessagingResource(SmsghApi apiHost) {
		this.apiHost = apiHost;
	}

	/**
	 * Retrieves all senders.
	 * 
	 * @return an API list of API senders.
	 * @throws ApiException if an error occurs.
	 */
	public ApiList<ApiSender> getSenders() throws ApiException {
		return getSenders(-1, -1);
	}

	/**
	 * Retrieves senders by page and page size.
	 * 
	 * @param page one-based index of the page to query.
	 * @param pageSize maximum number of entries in a page.
	 * @return an API list of API senders.
	 * @throws ApiException if an error occurs.
	 */
	public ApiList<ApiSender> getSenders(int page, int pageSize) throws ApiException {
		String uri = "/" + this.apiHost.getVersion() + "/senders";
		if (apiHost.getVersion() == null || apiHost.getVersion().length() == 0)
			uri = "/senders";
		return ApiHelper.getApiList(ApiSender.class, this.apiHost, uri, page, pageSize);
	}

	/**
	 * Retrieves a sender by ID.
	 * 
	 * @param senderId unique identifier of the sender.
	 * @return instance of ApiSender.
	 * @throws ApiException if an error occurs.
	 */
	public ApiSender getSender(long senderId) throws ApiException {
		try {
			String uri = "/" + this.apiHost.getVersion() + "/senders/" + senderId;
			if (apiHost.getVersion() == null || apiHost.getVersion().length() == 0)
				uri = "/senders/" + senderId;

			return new ApiSender(ApiHelper.getJson(this.apiHost, "GET", uri, null));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}

	/**
	 * Creates a new sender.
	 * 
	 * @param apiSender API sender to create.
	 * @return instance of ApiSender representing the created sender.
	 * @throws ApiException if an error occurs.
	 */
	public ApiSender create(ApiSender apiSender) throws ApiException {
		try {
			if (apiSender == null)
				throw new NullPointerException("apiSender");

			String uri = "/" + this.apiHost.getVersion() + "/senders";
			if (apiHost.getVersion() == null || apiHost.getVersion().length() == 0)
				uri = "/senders";

			return new ApiSender(ApiHelper.getJson(this.apiHost, "POST", uri, apiSender.toJson()));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}

	/**
	 * Updates details of a sender.
	 * 
	 * @param apiSender the API sender to update.
	 * @return instance of ApiSender representing the updated sender.
	 * @throws ApiException if an error occurs.
	 */
	public ApiSender update(ApiSender apiSender) throws ApiException {
		try {
			if (apiSender == null)
				throw new NullPointerException("apiSender");
			String uri = "/" + this.apiHost.getVersion() + "/senders/" + apiSender.getId();
			if (apiHost.getVersion() == null || apiHost.getVersion().length() == 0)
				uri = "/senders/" + apiSender.getId();

			return new ApiSender(ApiHelper.getJson(this.apiHost, "PUT", uri, apiSender.toJson()));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}

	/**
	 * Deletes a sender by ID.
	 * 
	 * @param senderId the ID of sender to delete.
	 * @throws ApiException if an error occurs.
	 */
	public void deleteSender(long senderId) throws ApiException {
		String uri = "/" + this.apiHost.getVersion() + "/senders/" + senderId;
		if (apiHost.getVersion() == null || apiHost.getVersion().length() == 0)
			uri = "/senders/" + senderId;

		ApiHelper.getData(this.apiHost, "DELETE", uri, null);
	}

	/**
	 * Retrieves all message templates.
	 * 
	 * @return an API list of message templates.
	 * @throws ApiException if an error occurs.
	 */
	public ApiList<ApiTemplate> getTemplates() throws ApiException {
		return getTemplates(-1, -1);
	}

	/**
	 * Retrieves message templates by page and page size.
	 * 
	 * @param page one-based index of the page to query.
	 * @param pageSize maximum number of entries in a page.
	 * @return an API list of message templates.
	 * @throws ApiException if an error occurs.
	 */
	public ApiList<ApiTemplate> getTemplates(int page, int pageSize) throws ApiException {
		String uri = "/" + this.apiHost.getVersion() + "/templates";
		if (apiHost.getVersion() == null || apiHost.getVersion().length() == 0)
			uri = "/templates";

		return ApiHelper.getApiList(ApiTemplate.class, this.apiHost, uri, page, pageSize);
	}

	/**
	 * Retrieves message template by ID.
	 * 
	 * @param templateId the ID of message template to query.
	 * @return instance of ApiTemplate representing the template.
	 * @throws ApiException if an error occurs.
	 */
	public ApiTemplate getTemplate(long templateId) throws ApiException {
		try {
			String uri = "/" + this.apiHost.getVersion() + "/templates/" + templateId;
			if (apiHost.getVersion() == null || apiHost.getVersion().length() == 0)
				uri = "/templates/" + templateId;

			return new ApiTemplate(ApiHelper.getJson(this.apiHost, "GET", uri, null));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}

	/**
	 * Creates a new message template.
	 * 
	 * @param apiTemplate the message template to create.
	 * @return instance of ApiTemplate representing the created template.
	 * @throws ApiException if an error occurs.
	 */
	public ApiTemplate create(ApiTemplate apiTemplate) throws ApiException {
		try {
			if (apiTemplate == null)
				throw new NullPointerException("apiTemplate");

			String uri = "/" + this.apiHost.getVersion() + "/templates";
			if (apiHost.getVersion() == null || apiHost.getVersion().length() == 0)
				uri = "/templates";

			return new ApiTemplate(ApiHelper.getJson(this.apiHost, "POST", uri, apiTemplate.toJson()));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}

	/**
	 * Updates details of a message template.
	 * 
	 * @param apiTemplate the API message template to update.
	 * @return instance of ApiTemplate representing the updated template.
	 * @throws ApiException if an error occurs.
	 */
	public ApiTemplate update(ApiTemplate apiTemplate) throws ApiException {
		try {
			if (apiTemplate == null)
				throw new NullPointerException("apiTemplate");

			String uri = "/" + this.apiHost.getVersion() + "/templates/" + apiTemplate.getId();
			if (apiHost.getVersion() == null || apiHost.getVersion().length() == 0)
				uri = "/templates/" + apiTemplate.getId();
			return new ApiTemplate(ApiHelper.getJson(this.apiHost, "PUT", uri, apiTemplate.toJson()));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}

	/**
	 * Deletes a message template.
	 * 
	 * @param templateId the ID of message template to delete.
	 * @throws ApiException if an error occurs.
	 */
	public void deleteTemplate(long templateId) throws ApiException {
		String uri = "/" + this.apiHost.getVersion() + "/templates/" + templateId;
		if (apiHost.getVersion() == null || apiHost.getVersion().length() == 0)
			uri = "/templates/" + templateId;
		ApiHelper.getData(this.apiHost, "DELETE", uri, null);
	}
}
