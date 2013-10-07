// $Id: ApiBulkMessagingResource.java 0 1970-01-01 00:00:00Z mkwayisi $
package com.smsgh;

public class ApiBulkMessagingResource {
	/**
	 * Data fields.
	 */
	private SmsghApi apiHost;
	
	/**
	 * Primary constructor.
	 */
	public ApiBulkMessagingResource(SmsghApi apiHost) {
		this.apiHost = apiHost;
	}
	
	/**
	 * Gets all senders.
	 */
	public ApiList<ApiSender> getSenders
		() throws ApiException {
		return getSenders(-1, -1);
	}
	
	/**
	 * Gets senders by page and pageSize.
	 */
	public ApiList<ApiSender> getSenders
		(int page, int pageSize) throws ApiException {
		return ApiHelper.getApiList(ApiSender.class,
			this.apiHost, "/v3/senders", page, pageSize);
	}
	
	/**
	 * Gets sender by ID.
	 */
	public ApiSender getSender
		(long senderId) throws ApiException {
		try {
			return new ApiSender(ApiHelper.getJson(this.apiHost,
				"GET", "/v3/senders/" + senderId, null));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}
	
	/**
	 * Creates new sender.
	 */
	public ApiSender create
		(ApiSender apiSender) throws ApiException {
		try {
			if (apiSender == null)
				throw new NullPointerException("apiSender");
			return new ApiSender(ApiHelper.getJson(this.apiHost,
				"POST", "/v3/senders", apiSender.toJson()));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}
	
	/**
	 * Updates a sender.
	 */
	public ApiSender update
		(ApiSender apiSender) throws ApiException {
		try {
			if (apiSender == null)
				throw new NullPointerException("apiSender");
			return new ApiSender(ApiHelper.getJson(this.apiHost,
				"PUT", "/v3/senders/" + apiSender.getId(),
					apiSender.toJson()));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}
	
	/**
	 * Deletes sender by ID.
	 */
	public void deleteSender
		(long senderId) throws ApiException {
		ApiHelper.getData(this.apiHost,
			"DELETE", "/v3/senders/" + senderId, null);
	}
	
	/**
	 * Gets all templates.
	 */
	public ApiList<ApiTemplate> getTemplates
		() throws ApiException {
		return getTemplates(-1, -1);
	}
	
	/**
	 * Gets templates by page and pageSize.
	 */
	public ApiList<ApiTemplate> getTemplates
		(int page, int pageSize) throws ApiException {
		return ApiHelper.getApiList(ApiTemplate.class,
			this.apiHost, "/v3/templates", page, pageSize);
	}
	
	/**
	 * Gets template by ID.
	 */
	public ApiTemplate getTemplate
		(long templateId) throws ApiException {
		try {
			return new ApiTemplate(ApiHelper.getJson
				(this.apiHost, "GET", "/v3/templates/" + templateId, null));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}
	
	/**
	 * Creates new template.
	 */
	public ApiTemplate create
		(ApiTemplate apiTemplate) throws ApiException {
		try {
			if (apiTemplate == null)
				throw new NullPointerException("apiTemplate");
			return new ApiTemplate(ApiHelper.getJson(this.apiHost,
				"POST", "/v3/templates", apiTemplate.toJson()));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}
	
	/**
	 * Updates message template.
	 */
	public ApiTemplate update
		(ApiTemplate apiTemplate) throws ApiException {
		try {
			if (apiTemplate == null)
				throw new NullPointerException("apiTemplate");
			return new ApiTemplate(ApiHelper.getJson
				(this.apiHost, "PUT", "/v3/templates/"
					+ apiTemplate.getId(), apiTemplate.toJson()));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}
	
	/**
	 * Deletes message template.
	 */
	public void deleteTemplate
		(long templateId) throws ApiException {
		ApiHelper.getData(this.apiHost,
			"DELETE", "/v3/templates/" + templateId, null);
	}
}
