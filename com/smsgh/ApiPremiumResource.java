package com.smsgh;

import com.smsgh.json.JsonObject;

/**
 * Represents an API premium resource.
 * 
 * @author Michael Kwayisi
 */
public class ApiPremiumResource {
	private SmsghApi apiHost;

	/**
	 * Initializes a new instance of this class.
	 */
	public ApiPremiumResource(SmsghApi apiHost) {
		this.apiHost = apiHost;
	}

	/**
	 * Retrieves all number plans.
	 * 
	 * @return API list of number plans.
	 * @throws ApiException if an error occurs.
	 */
	public ApiList<ApiNumberPlan> getNumberPlans() throws ApiException {
		return getNumberPlans(-1, -1, -1);
	}

	/**
	 * Retrieves number plans by page and page size.
	 * 
	 * @param page one-based index of the page to query.
	 * @param pageSize maximum number of entries in a page.
	 * @param type type of number plan to retrieve
	 * @return API list of number plans.
	 * @throws ApiException if an error occurs.
	 */
	public ApiList<ApiNumberPlan> getNumberPlans(int page, int pageSize, int type) throws ApiException {
		String uri = null;
		if (this.apiHost.getVersion() == null || this.apiHost.getVersion().length() == 0)
			uri = "/numberplans/";
		else
			uri = "/" + this.apiHost.getVersion() + "/numberplans/";
		if (type >= 0){
			uri += "?Type=" + type;
			return ApiHelper.getApiList(ApiNumberPlan.class, this.apiHost, uri, page, pageSize, true);
		}
		return ApiHelper.getApiList(ApiNumberPlan.class, this.apiHost, uri, page, pageSize);
	}

	/**
	 * Retrieves all shared number plans.
	 * 
	 * @return API list of number plans.
	 * @throws ApiException if an error occurs.
	 */
	/*
	 * public ApiList<ApiNumberPlan> getSharedNumberPlans() throws ApiException
	 * { return getSharedNumberPlans(-1, -1); }
	 */

	/**
	 * Retrieves shared number plans by page and page size.
	 * 
	 * @param page one-based index of the page to query.
	 * @param pageSize maximum number of entries in a page.
	 * @return API list of number plans.
	 * @throws ApiException if an error occurs.
	 */
	/*
	 * public ApiList<ApiNumberPlan> getSharedNumberPlans(int page, int
	 * pageSize) throws ApiException { return
	 * ApiHelper.getApiList(ApiNumberPlan.class, this.apiHost,
	 * "/v3/numberplans/shared", page, pageSize); }
	 */

	/**
	 * Retrieves all not-shared number plans.
	 * 
	 * @return API list of number plans.
	 * @throws ApiException if an error occurs.
	 */
	/*
	 * public ApiList<ApiNumberPlan> getNotSharedNumberPlans() throws
	 * ApiException { return getNotSharedNumberPlans(-1, -1); }
	 */
	/**
	 * Retrieves not-shared number plans by page and page size.
	 * 
	 * @param page one-based index of the page to query.
	 * @param pageSize maximum number of entries in a page.
	 * @return API list of number plans.
	 * @throws ApiException if an error occurs.
	 */
	/*
	 * public ApiList<ApiNumberPlan> getNotSharedNumberPlans(int page, int
	 * pageSize) throws ApiException { return
	 * ApiHelper.getApiList(ApiNumberPlan.class, this.apiHost,
	 * "/v3/numberplans/notshared", page, pageSize); }
	 */

	/**
	 * Retrieves all number plan keywords.
	 * 
	 * @param numberPlanId ID of the number plan to query.
	 * @return API list of MO keywords.
	 * @throws ApiException if an error occurs.
	 */
	public ApiList<ApiMoKeyWord> getNumberPlanKeywords(long numberPlanId) throws ApiException {
		return getNumberPlanKeyWords(numberPlanId, -1, -1);
	}

	/**
	 * Retrieves number plan keywords by page and page size.
	 * 
	 * @param numberPlanId ID of the number plan to query.
	 * @param page one-based index of the page to query.
	 * @param pageSize maximum number of entries in a page.
	 * @return API list of MO keywords.
	 * @throws ApiException if an error occurs.
	 */
	public ApiList<ApiMoKeyWord> getNumberPlanKeyWords(long numberPlanId, int page, int pageSize) throws ApiException {
		String uri = null;
		if (this.apiHost.getVersion() == null || this.apiHost.getVersion().length() == 0)
			uri = "/numberplans/" + numberPlanId + "/keywords/";
		else
			uri = "/" + this.apiHost.getVersion() + "/numberplans/" + numberPlanId + "/keywords/";

		return ApiHelper.getApiList(ApiMoKeyWord.class, this.apiHost, uri, page, pageSize);
	}

	/**
	 * Get Campaign keywords
	 * @param numberPlanId
	 * @param page
	 * @param pageSize
	 * @return  API list of MO keywords.
	 * @throws ApiException
	 */
	public ApiList<ApiMoKeyWord> getCampaignKeyWords(long campaignId, int page, int pageSize) throws ApiException {
		String uri = null;
		if (this.apiHost.getVersion() == null || this.apiHost.getVersion().length() == 0)
			uri = "/campaigns/" + campaignId + "/keywords/";
		else
			uri = "/" + this.apiHost.getVersion() + "/campaigns/" + campaignId + "/keywords/";

		return ApiHelper.getApiList(ApiMoKeyWord.class, this.apiHost, uri, page, pageSize);
	}
	
	/**
	 * Retrieves all campaigns.
	 * 
	 * @return API list of campaigns.
	 * @throws ApiException if an error occurs.
	 */
	public ApiList<ApiCampaign> getCampaigns() throws ApiException {
		return getCampaigns(-1, -1);
	}

	/**
	 * Retrieves campaigns by page and page size.
	 * 
	 * @param page one-based index of the page to query.
	 * @param pageSize maximum number of entries in a page.
	 * @return API list of campaigns.
	 * @throws ApiException if an error occurs.
	 */
	public ApiList<ApiCampaign> getCampaigns(int page, int pageSize) throws ApiException {
		String uri = null;
		if (this.apiHost.getVersion() == null || this.apiHost.getVersion().length() == 0)
			uri = "/campaigns/";
		else
			uri = "/" + this.apiHost.getVersion() + "/campaigns/";
		return ApiHelper.getApiList(ApiCampaign.class, this.apiHost, uri, page, pageSize);
	}

	/**
	 * Retrieves details of a campaign.
	 * 
	 * @param campaignId ID of the campaign to query.
	 * @return instance of ApiCampaign representing the queried campaign.
	 * @throws ApiException if an error occurs.
	 */
	public ApiCampaign getCampaign(long campaignId) throws ApiException {
		String uri = null;
		if (this.apiHost.getVersion() == null || this.apiHost.getVersion().length() == 0)
			uri = "/campaigns/" + campaignId;
		else
			uri = "/" + this.apiHost.getVersion() + "/campaigns/" + campaignId;
		try {
			return new ApiCampaign(ApiHelper.getJson(this.apiHost, "GET", uri, null));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}

	/**
	 * 
	 * @param numberPlanId the number plan Id
	 * @return instance of ApiNumberPlan representing the queried Number Plan
	 * @throws ApiException
	 */
	public ApiNumberPlan getNumberPlan(long numberPlanId) throws ApiException {
		String uri = null;
		if (this.apiHost.getVersion() == null || this.apiHost.getVersion().length() == 0)
			uri = "/numberplans/" + numberPlanId;
		else
			uri = "/" + this.apiHost.getVersion() + "/numberplans/" + numberPlanId;

		try {
			return new ApiNumberPlan(ApiHelper.getJson(this.apiHost, "GET", uri, null));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}

	/**
	 * 
	 * @param keywordId
	 * @return instance of ApiMoKeyword
	 * @throws ApiException
	 */
	public ApiMoKeyWord getKeywordById(long keywordId) throws ApiException {
		String uri = "/" + this.apiHost.getVersion() + "/keywords/" + keywordId;
		if (this.apiHost.getVersion() == null || this.apiHost.getVersion().length() == 0)
			uri = "/keywords/" + keywordId;

		try {
			return new ApiMoKeyWord(ApiHelper.getJson(this.apiHost, "GET", uri, null));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}

	/**
	 * Creates a new campaign.
	 * 
	 * @param apiCampaign API campaign to create.
	 * @return instance of ApiCampaign representing the created campaign.
	 * @throws ApiException if an error occurs.
	 */
	public ApiCampaign create(ApiCampaign apiCampaign) throws ApiException {
		String uri = "/" + this.apiHost.getVersion() + "/campaigns/";
		if (this.apiHost.getVersion() == null || this.apiHost.getVersion().length() == 0)
			uri = "/campaigns/";
		try {
			if (apiCampaign == null)
				throw new NullPointerException("apiCampaign");
			return new ApiCampaign(ApiHelper.getJson(this.apiHost, "POST", uri, apiCampaign.toJson()));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}

	/**
	 * Updates a campaign.
	 * 
	 * @param apiCampaign API campaign to update.
	 * @return instance of ApiCampaign representing the updated campaign.
	 * @throws ApiException if an error occurs.
	 */
	public ApiCampaign update(ApiCampaign apiCampaign) throws ApiException {
		if (apiCampaign == null)
			throw new NullPointerException("apiCampaign");
		String uri = "/" + this.apiHost.getVersion() + "/campaigns/" + apiCampaign.getCampaignId();
		if (this.apiHost.getVersion() == null || this.apiHost.getVersion().length() == 0)
			uri = "/campaigns/" + apiCampaign.getCampaignId();
		try {
			return new ApiCampaign(ApiHelper.getJson(this.apiHost, "PUT", uri, apiCampaign.toJson()));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}

	/**
	 * Deletes a campaign.
	 * 
	 * @param campaignId ID of the campaign to delete.
	 * @throws ApiException if an error occurs.
	 */
	public void deleteCampaign(long campaignId) throws ApiException {
		String uri = "/" + this.apiHost.getVersion() + "/campaigns/" + campaignId;
		if (this.apiHost.getVersion() == null || this.apiHost.getVersion().length() == 0)
			uri = "/campaigns/" + campaignId;
		ApiHelper.getData(this.apiHost, "DELETE", uri, null);
	}

	/**
	 * Retrieves all MO keywords.
	 * 
	 * @return API list of MO keywords.
	 * @throws ApiException if an error occurs.
	 */
	public ApiList<ApiMoKeyWord> getKeyWords() throws ApiException {
		return getKeyWords(-1, -1);
	}

	/**
	 * Retrieves MO keywords by page and page size.
	 * 
	 * @param page one-based index of the page to query.
	 * @param pageSize maximum number of entries in a page.
	 * @return API list of MO keywords.
	 * @throws ApiException if an error occurs.
	 */
	public ApiList<ApiMoKeyWord> getKeyWords(int page, int pageSize) throws ApiException {
		String uri = "/" + this.apiHost.getVersion() + "/keywords/";
		if (this.apiHost.getVersion() == null || this.apiHost.getVersion().length() == 0)
			uri = "/keywords/";
		return ApiHelper.getApiList(ApiMoKeyWord.class, this.apiHost, uri, page, pageSize);
	}

	/**
	 * Creates a new MO keyword.
	 * 
	 * @param apiMoKeyWord the MO keyword to create.
	 * @return instance of ApiMoKeyword representing the created keyword.
	 * @throws ApiException if an error occurs.
	 */
	public ApiMoKeyWord create(ApiMoKeyWord apiMoKeyWord) throws ApiException {
		if (apiMoKeyWord == null)
			throw new NullPointerException("apiMoKeyWord");

		String uri = "/" + this.apiHost.getVersion() + "/keywords";
		if (this.apiHost.getVersion() == null || this.apiHost.getVersion().length() == 0)
			uri = "/keywords";
		try {
			return new ApiMoKeyWord(ApiHelper.getJson(this.apiHost, "POST", uri, apiMoKeyWord.toJson()));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}

	/**
	 * Updates an MO keyword.
	 * 
	 * @param apiMoKeyWord the MO keyword to update.
	 * @return instance of ApiMoKeyWord representing the updated keyword.
	 * @throws ApiException if an error occurs.
	 */
	public ApiMoKeyWord update(ApiMoKeyWord apiMoKeyWord) throws ApiException {
		if (apiMoKeyWord == null)
			throw new NullPointerException("apiMoKeyWord");

		String uri = "/" + this.apiHost.getVersion() + "/keywords/" + apiMoKeyWord.getId();
		if (this.apiHost.getVersion() == null || this.apiHost.getVersion().length() == 0)
			uri = "/keywords/" + apiMoKeyWord.getId();
		try {
			return new ApiMoKeyWord(ApiHelper.getJson(this.apiHost, "PUT", uri, apiMoKeyWord.toJson()));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}

	/**
	 * Deletes an MO keyword.
	 * 
	 * @param keywordId ID of the keyword to delete.
	 * @throws ApiException if an error occurs.
	 */
	public void deleteKeyword(long keywordId) throws ApiException {
		String uri = "/" + this.apiHost.getVersion() + "/keywords/" + keywordId;
		if (this.apiHost.getVersion() == null || this.apiHost.getVersion().length() == 0)
			uri = "/keywords/" + keywordId;
		ApiHelper.getData(this.apiHost, "DELETE", uri, null);
	}

	/**
	 *  Get keyword By id
	 * @param keywordId
	 * @return
	 * @throws ApiException
	 */
	public ApiMoKeyWord getKeyword(long keywordId) throws ApiException {
		String uri = "/" + this.apiHost.getVersion() + "/keywords/" + keywordId;
		if (this.apiHost.getVersion() == null || this.apiHost.getVersion().length() == 0)
			uri = "/keywords/" + keywordId;
		return new ApiMoKeyWord(ApiHelper.getJson(this.apiHost, "GET", uri, null));
	}	
	
	/**
	 * Adds an MO keyword to campaign.
	 * 
	 * @param campaignId ID of the campaign to have the MO keyword.
	 * @param keywordId ID of the MO keyword to add to campaign.
	 * @return instance of ApiCampaign represented the API campaign to which the
	 *         MO keyword was added.
	 * @throws ApiException if an error occurs.
	 */
	public ApiCampaign addKeywordToCampaign(long campaignId, long keywordId) throws ApiException {
		String uri = "/" + this.apiHost.getVersion() + "/campaigns/" + campaignId + "/keywords/" + keywordId;
		if (this.apiHost.getVersion() == null || this.apiHost.getVersion().length() == 0)
			uri = "/campaigns/" + campaignId + "/keywords/" + keywordId;

		try {
			return new ApiCampaign(ApiHelper.getJson(this.apiHost, "PUT", uri, null));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}

	/**
	 * Removes an MO keyword from a campaign.
	 * 
	 * @param campaignId ID of the campaign having the MO keyword.
	 * @param keywordId ID of the keyword to remove from the campaign.
	 * @throws ApiException if an error occurs.
	 */
	public void removeKeywordFromCampaign(long campaignId, long keywordId) throws ApiException {
		String uri = "/" + this.apiHost.getVersion() + "/campaigns/" + campaignId + "/keywords/" + keywordId;
		if (this.apiHost.getVersion() == null || this.apiHost.getVersion().length() == 0)
			uri = "/campaigns/" + campaignId + "/keywords/" + keywordId;
		ApiHelper.getData(this.apiHost, "DELETE", uri, null);
	}

	/**
	 * Retrieves all actions on a campaign.
	 * 
	 * @param campaignId ID of the campaign to query.
	 * @return API list of actions.
	 * @throws ApiException if an error occurs.
	 */
	public ApiList<ApiAction> getActions(long campaignId) throws ApiException {
		return getActions(campaignId, -1, -1);
	}

	/**
	 * Retrieves actions on a campaign by page and page size.
	 * 
	 * @param campaignId ID of the campaign to query.
	 * @param page one-based index of the page to query.
	 * @param pageSize maximum number of entries in a page.
	 * @return API list of actions.
	 * @throws ApiException if an error occurs.
	 */
	public ApiList<ApiAction> getActions(long campaignId, int page, int pageSize) throws ApiException {
		String uri = "/" + this.apiHost.getVersion() + "/campaigns/" + campaignId + "/actions";
		if (apiHost.getVersion() == null || apiHost.getVersion().length() == 0)
			uri = "/campaigns/" + campaignId + "/actions";
		return ApiHelper.getApiList(ApiAction.class, this.apiHost, uri, page, pageSize);
	}

	/**
	 * Adds a default reply action to campaign.
	 * 
	 * @param campaignId ID of the campaign to add the action to.
	 * @param message the default reply action message to add.
	 * @return instance of ApiCampaign representing the API campaign the action
	 *         was added to.
	 * @throws ApiException if an error occurs.
	 */
	public ApiCampaign addDefaultReplyAction(long campaignId, String message) throws ApiException {
		String uri = "/" + this.apiHost.getVersion() + "/campaigns/" + campaignId + "/actions/default_reply";
		if(apiHost.getVersion() == null || apiHost.getVersion().length() == 0)
			uri = "/campaigns/" + campaignId + "/actions/default_reply";
		try {
			return new ApiCampaign(ApiHelper.getJson(this.apiHost, "POST", uri, new JsonObject().add("message", message).toString()));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}

	/**
	 * Adds a dynamic URL action, with no send response, to campaign.
	 * 
	 * @param campaignId ID of the campaign to add the action to.
	 * @param url the dynamic URL to add.
	 * @return instance of ApiCampaign representing the API campaign the action
	 *         was added to.
	 * @throws ApiException if an error occurs.
	 */
	public ApiCampaign addDynamicUrlAction(long campaignId, String url) throws ApiException {
		return addDynamicUrlAction(campaignId, url, "no");
	}

	/**
	 * Adds a dynamic URL action, with send response, to campaign.
	 * 
	 * @param campaignId ID of the campaign to add the action to.
	 * @param url the dynamic URL to add.
	 * @param sendResponse a yes or no value.
	 * @return instance of ApiCampaign representing the API campaign the action
	 *         was added to.
	 * @throws ApiException if an error occurs.
	 */
	public ApiCampaign addDynamicUrlAction(long campaignId, String url, String sendResponse) throws ApiException {
		String uri = "/" + this.apiHost.getVersion() + "/campaigns/" + campaignId + "/actions/dynamic_url";
		if(apiHost.getVersion() == null || apiHost.getVersion().length() == 0)
			uri = "/campaigns/" + campaignId + "/actions/dynamic_url";
		
		try {
			return new ApiCampaign(ApiHelper.getJson(this.apiHost, "POST", uri, new JsonObject().add("url", url).add("send_response", sendResponse).toString()));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}

	/**
	 * Adds an email address action to campaign.
	 * 
	 * @param campaignId ID of the campaign to add the action to.
	 * @param address the email address to add.
	 * @return instance of ApiCampaign representing the API campaign the action
	 *         was added to.
	 * @throws ApiException if an error occurs.
	 */
	public ApiCampaign addEmailAddressAction(long campaignId, String address) throws ApiException {
		String uri = "/" + this.apiHost.getVersion() + "/campaigns/" + campaignId + "/actions/email";
		if(apiHost.getVersion() == null || apiHost.getVersion().length() == 0)
			uri = "/campaigns/" + campaignId + "/actions/email";
		try {
			return new ApiCampaign(ApiHelper.getJson(this.apiHost, "POST", uri, new JsonObject().add("address", address).toString()));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}

	/**
	 * Adds a forward-to-mobile action to campaign.
	 * 
	 * @param campaignId ID of the campaign to add the action to.
	 * @param number the mobile phone number to add.
	 * @return instance of ApiCampaign representing the API campaign the action
	 *         was added to.
	 * @throws ApiException if an error occurs.
	 */
	public ApiCampaign addForwardToMobileAction(long campaignId, String number) throws ApiException {
		String uri = "/" + this.apiHost.getVersion() + "/campaigns/" + campaignId + "/actions/phone";
		if(apiHost.getVersion() == null || apiHost.getVersion().length() == 0)
			uri = "/campaigns/" + campaignId + "/actions/phone";
		
		try {
			return new ApiCampaign(ApiHelper.getJson(this.apiHost, "POST", uri, new JsonObject().add("number", number).toString()));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}

	/**
	 * Adds a forward-to-SMPP action to campaign.
	 * 
	 * @param campaignId ID of the campaign to add the action to.
	 * @param appId the app ID to add.
	 * @return instance of ApiCampaign representing the API campaign the action
	 *         was added to.
	 * @throws ApiException if an error occurs.
	 */
	public ApiCampaign addForwardToSmppAction(long campaignId, String appId) throws ApiException {
		String uri = "/" + this.apiHost.getVersion() + "/campaigns/" + campaignId + "/actions/smpp";
		if(apiHost.getVersion() == null || apiHost.getVersion().length() == 0)
			uri = "/campaigns/" + campaignId + "/actions/smpp";
		try {
			return new ApiCampaign(ApiHelper.getJson(this.apiHost, "POST", uri, new JsonObject().add("api_id", appId).toString()));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}

	/**
	 * Removes an action from a campaign.
	 * 
	 * @param campaignId ID of the campaign to remove the action from.
	 * @param actionId ID of the action to remove from campaign.
	 * @return instance of ApiCampaign representing the API campaign the action
	 *         was removed from.
	 * @throws ApiException if an error occurs.
	 */
	public ApiCampaign removeActionFromCampaign(long campaignId, long actionId) throws ApiException {
		String uri = "/" + this.apiHost.getVersion() + "/campaigns/" + campaignId + "/actions/" + actionId;
		if(apiHost.getVersion() == null || apiHost.getVersion().length() == 0)
			uri = "/campaigns/" + campaignId + "/actions/" + actionId;
		try {
			return new ApiCampaign(ApiHelper.getJson(this.apiHost, "DELETE", uri, null));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}
}
