// $Id: ApiPremiumResource.java 0 1970-01-01 00:00:00Z mkwayisi $
package com.smsgh;
import com.smsgh.json.JsonObject;

public class ApiPremiumResource {
	/**
	 * Data fields.
	 */
	private SmsghApi apiHost;
	
	/**
	 * Primary constructor.
	 */
	public ApiPremiumResource(SmsghApi apiHost) {
		this.apiHost = apiHost;
	}
	
	/**
	 * Gets all number plans.
	 */
	public ApiList<ApiNumberPlan> getNumberPlans
		() throws ApiException {
		return getNumberPlans(-1, -1);
	}
	
	/**
	 * Gets number plans by page and pageSize;
	 */
	public ApiList<ApiNumberPlan> getNumberPlans
		(int page, int pageSize) throws ApiException {
		return ApiHelper.getApiList(ApiNumberPlan.class,
			this.apiHost, "/v3/numberplans", page, pageSize);
	}
	
	/**
	 * Gets all shared number plans.
	 */
	public ApiList<ApiNumberPlan> getSharedNumberPlans
		() throws ApiException {
		return getSharedNumberPlans(-1, -1);
	}
	
	/**
	 * Gets shared number plans by page and pageSize.
	 */
	public ApiList<ApiNumberPlan> getSharedNumberPlans
		(int page, int pageSize) throws ApiException {
		return ApiHelper.getApiList(ApiNumberPlan.class,
			this.apiHost, "/v3/numberplans/shared", page, pageSize);
	}
	
	/**
	 * Gets all not-shared number plans.
	 */
	public ApiList<ApiNumberPlan> getNotSharedNumberPlans
		() throws ApiException {
		return getNotSharedNumberPlans(-1, -1);
	}
	
	/**
	 * Gets not-shared number plans by page and pageSize.
	 */
	public ApiList<ApiNumberPlan> getNotSharedNumberPlans
		(int page, int pageSize) throws ApiException {
		return ApiHelper.getApiList(ApiNumberPlan.class,
			this.apiHost, "/v3/numberplans/notshared", page, pageSize);
	}
	
	/**
	 * Gets all keywords for a number plan.
	 */
	public ApiList<ApiMoKeyword> getNumberPlanKeywords
		(long numberPlanId) throws ApiException {
		return getNumberPlanKeywords(numberPlanId, -1, -1);
	}
	
	/**
	 * Gets keywords for a number plan by page and pageSize.
	 */
	public ApiList<ApiMoKeyword> getNumberPlanKeywords
		(long numberPlanId, int page, int pageSize) throws ApiException {
		return ApiHelper.getApiList(ApiMoKeyword.class, this.apiHost,
			"/v3/numberplans/" + numberPlanId + "/keywords", page, pageSize);
	}
	
	/**
	 * Gets all campaigns.
	 */
	public ApiList<ApiCampaign> getCampaigns
		() throws ApiException {
		return getCampaigns(-1, -1);
	}
	
	/**
	 * Gets campaigns by page and pageSize.
	 */
	public ApiList<ApiCampaign> getCampaigns
		(int page, int pageSize) throws ApiException {
		return ApiHelper.getApiList(ApiCampaign.class,
			this.apiHost, "/v3/campaigns", page, pageSize);
	}
	
	/**
	 * Get campaign by ID.
	 */
	public ApiCampaign getCampaign
		(long campaignId) throws ApiException {
		try {
			return new ApiCampaign(ApiHelper.getJson
				(this.apiHost, "GET", "/v3/campaigns/" + campaignId, null));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}
	
	/**
	 * Creates new campaign.
	 */
	public ApiCampaign create
		(ApiCampaign apiCampaign) throws ApiException {
		try {
			if (apiCampaign == null)
				throw new NullPointerException("apiCampaign");
			return new ApiCampaign(ApiHelper.getJson
				(this.apiHost, "POST", "/v3/campaigns", apiCampaign.toJson()));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}
	
	/**
	 * Updates campaign.
	 */
	public ApiCampaign update
		(ApiCampaign apiCampaign) throws ApiException {
		try {
			if (apiCampaign == null)
				throw new NullPointerException("apiCampaign");
			return new ApiCampaign(ApiHelper.getJson(this.apiHost,
				"PUT", "/v3/campaigns/" + apiCampaign.getCampaignId(),
					apiCampaign.toJson()));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}
	
	/**
	 * Deletes a campaign by ID.
	 */
	public void deleteCampaign
		(long campaignId) throws ApiException {
		ApiHelper.getData(this.apiHost,
			"DELETE", "/v3/campaigns/" + campaignId, null);
	}
	
	/**
	 * Gets all keywords.
	 */
	public ApiList<ApiMoKeyword> getKeywords
		() throws ApiException {
		return getKeywords(-1, -1);
	}
	
	/**
	 * Gets keywords by page and pageSize.
	 */
	public ApiList<ApiMoKeyword> getKeywords
		(int page, int pageSize) throws ApiException {
		return ApiHelper.getApiList(ApiMoKeyword.class,
			this.apiHost, "/v3/keywords", page, pageSize);
	}
	
	/**
	 * Creates new keyword.
	 */
	public ApiMoKeyword create
		(ApiMoKeyword apiMoKeyword) throws ApiException {
		try {
			if (apiMoKeyword == null)
				throw new NullPointerException("apiMoKeyword");
			return new ApiMoKeyword(ApiHelper.getJson(this.apiHost,
				"POST", "/v3/keywords", apiMoKeyword.toJson()));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}
	
	/**
	 * Updates a keyword.
	 */
	public ApiMoKeyword update
		(ApiMoKeyword apiMoKeyword) throws ApiException {
		try {
			if (apiMoKeyword == null)
				throw new NullPointerException("apiMoKeyword");
			return new ApiMoKeyword(ApiHelper.getJson(this.apiHost,
				"PUT", "/v3/keywords/" + apiMoKeyword.getId(),
					apiMoKeyword.toJson()));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}
	
	/**
	 * Deletes keyword.
	 */
	public void deleteKeyword
		(long keywordId) throws ApiException {
		ApiHelper.getData(this.apiHost,
			"DELETE", "/v3/keywords/" + keywordId, null);
	}
	
	/**
	 * Adds keyword to campaign.
	 */
	public ApiCampaign addKeywordToCampaign
		(long campaignId, long keywordId) throws ApiException {
		try {
			return new ApiCampaign(ApiHelper.getJson(this.apiHost,
				"PUT", "/v3/campaigns/" + campaignId
					+ "/keywords/" + keywordId, null));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}
	
	/**
	 * Removes keyword from campaign.
	 */
	public void removeKeywordFromCampaign
		(long campaignId, long keywordId) throws ApiException {
		ApiHelper.getData(this.apiHost, "DELETE", "/v3/campaigns/"
			+ campaignId + "/keywords/" + keywordId, null);
	}
	
	/**
	 * Get all campaign actions.
	 */
	public ApiList<ApiAction> getActions
		(long campaignId) throws ApiException {
		return getActions(campaignId, -1, -1);
	}
	
	/**
	 * Gets campaign actions by page and pageSize.
	 */
	public ApiList<ApiAction> getActions
		(long campaignId, int page, int pageSize) throws ApiException {
		return ApiHelper.getApiList(ApiAction.class, this.apiHost,
			"/v3/campaigns/" + campaignId + "/actions", page, pageSize);
	}
	
	/**
	 * Adds default reply action to campaign.
	 */
	public ApiCampaign addDefaultReplyAction
		(long campaignId, String message) throws ApiException {
		try {
			return new ApiCampaign(ApiHelper.getJson(this.apiHost,
				"POST", "/v3/campaigns/" + campaignId + "/actions/default_reply",
					new JsonObject().add("message", message).toString()));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}
	
	/**
	 * Adds dynamic URL action to campaign with no send response.
	 */
	public ApiCampaign addDynamicUrlAction
		(long campaignId, String url) throws ApiException {
		return addDynamicUrlAction(campaignId, url, "no");
	}
	
	/**
	 * Adds dynamic URL action to campaign with send response value.
	 */
	public ApiCampaign addDynamicUrlAction
		(long campaignId, String url, String sendResponse) throws ApiException {
		try {
			return new ApiCampaign(ApiHelper.getJson(this.apiHost,
				"POST", "/v3/campaigns/" + campaignId + "/actions/dynamic_url",
					new JsonObject().add("url", url)
						.add("send_response", sendResponse).toString()));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}
	
	/**
	 * Adds email address action to campaign.
	 */
	public ApiCampaign addEmailAddressAction
		(long campaignId, String address) throws ApiException {
		try {
			return new ApiCampaign(ApiHelper.getJson(this.apiHost,
				"POST", "/v3/campaigns/" + campaignId + "/actions/email",
					new JsonObject().add("address", address).toString()));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}
	
	/**
	 * Adds forward to mobile action to campaign.
	 */
	public ApiCampaign addForwardToMobileAction
		(long campaignId, String number) throws ApiException {
		try {
			return new ApiCampaign(ApiHelper.getJson(this.apiHost,
				"POST", "/v3/campaigns/" + campaignId + "/actions/phone",
					new JsonObject().add("number", number).toString()));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}
	
	/**
	 * Adds forward to SMPP action to campaign.
	 */
	public ApiCampaign addForwardToSmppAction
		(long campaignId, String appId) throws ApiException {
		try {
			return new ApiCampaign(ApiHelper.getJson(this.apiHost,
				"POST", "/v3/campaigns/" + campaignId + "/actions/smpp",
					new JsonObject().add("app_id", appId).toString()));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}
}
