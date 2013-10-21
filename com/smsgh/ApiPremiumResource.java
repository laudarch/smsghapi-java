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
	public ApiList<ApiNumberPlan> getNumberPlans
		() throws ApiException {
		return getNumberPlans(-1, -1);
	}
	
	/**
	 * Retrieves number plans by page and page size.
	 *
	 * @param  page     one-based index of the page to query.
	 * @param  pageSize maximum number of entries in a page.
	 * @return API list of number plans.
	 * @throws ApiException if an error occurs.
	 */
	public ApiList<ApiNumberPlan> getNumberPlans
		(int page, int pageSize) throws ApiException {
		return ApiHelper.getApiList(ApiNumberPlan.class,
			this.apiHost, "/v3/numberplans", page, pageSize);
	}
	
	/**
	 * Retrieves all shared number plans.
	 *
	 * @return API list of number plans.
	 * @throws ApiException if an error occurs.
	 */
	public ApiList<ApiNumberPlan> getSharedNumberPlans
		() throws ApiException {
		return getSharedNumberPlans(-1, -1);
	}
	
	/**
	 * Retrieves shared number plans by page and page size.
	 *
	 * @param  page     one-based index of the page to query.
	 * @param  pageSize maximum number of entries in a page.
	 * @return API list of number plans.
	 * @throws ApiException if an error occurs.
	 */
	public ApiList<ApiNumberPlan> getSharedNumberPlans
		(int page, int pageSize) throws ApiException {
		return ApiHelper.getApiList(ApiNumberPlan.class,
			this.apiHost, "/v3/numberplans/shared", page, pageSize);
	}
	
	/**
	 * Retrieves all not-shared number plans.
	 *
	 * @return API list of number plans.
	 * @throws ApiException if an error occurs.
	 */
	public ApiList<ApiNumberPlan> getNotSharedNumberPlans
		() throws ApiException {
		return getNotSharedNumberPlans(-1, -1);
	}
	
	/**
	 * Retrieves not-shared number plans by page and page size.
	 *
	 * @param  page     one-based index of the page to query.
	 * @param  pageSize maximum number of entries in a page.
	 * @return API list of number plans.
	 * @throws ApiException if an error occurs.
	 */
	public ApiList<ApiNumberPlan> getNotSharedNumberPlans
		(int page, int pageSize) throws ApiException {
		return ApiHelper.getApiList(ApiNumberPlan.class,
			this.apiHost, "/v3/numberplans/notshared", page, pageSize);
	}
	
	/**
	 * Retrieves all number plan keywords.
	 *
	 * @param  numberPlanId  ID of the number plan to query.
	 * @return API list of MO keywords.
	 * @throws ApiException if an error occurs.
	 */
	public ApiList<ApiMoKeyWord> getNumberPlanKeywords
		(long numberPlanId) throws ApiException {
		return getNumberPlanKeyWords(numberPlanId, -1, -1);
	}
	
	/**
	 * Retrieves number plan keywords by page and page size.
	 *
	 * @param  numberPlanId  ID of the number plan to query.
	 * @param  page          one-based index of the page to query.
	 * @param  pageSize      maximum number of entries in a page.
	 * @return API list of MO keywords.
	 * @throws ApiException if an error occurs.
	 */
	public ApiList<ApiMoKeyWord> getNumberPlanKeyWords
		(long numberPlanId, int page, int pageSize) throws ApiException {
		return ApiHelper.getApiList(ApiMoKeyWord.class, this.apiHost,
			"/v3/numberplans/" + numberPlanId + "/keywords", page, pageSize);
	}
	
	/**
	 * Retrieves all campaigns.
	 *
	 * @return API list of campaigns.
	 * @throws ApiException if an error occurs.
	 */
	public ApiList<ApiCampaign> getCampaigns
		() throws ApiException {
		return getCampaigns(-1, -1);
	}
	
	/**
	 * Retrieves campaigns by page and page size.
	 *
	 * @param  page     one-based index of the page to query.
	 * @param  pageSize maximum number of entries in a page.
	 * @return API list of campaigns.
	 * @throws ApiException if an error occurs.
	 */
	public ApiList<ApiCampaign> getCampaigns
		(int page, int pageSize) throws ApiException {
		return ApiHelper.getApiList(ApiCampaign.class,
			this.apiHost, "/v3/campaigns", page, pageSize);
	}
	
	/**
	 * Retrieves details of a campaign.
	 *
	 * @param  campaignId  ID of the campaign to query.
	 * @return instance of ApiCampaign representing the queried campaign.
	 * @throws ApiException if an error occurs.
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
	 * Creates a new campaign.
	 *
	 * @param  apiCampaign  API campaign to create.
	 * @return instance of ApiCampaign representing the created campaign.
	 * @throws ApiException if an error occurs.
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
	 * Updates a campaign.
	 *
	 * @param  apiCampaign  API campaign to update.
	 * @return instance of ApiCampaign representing the updated campaign.
	 * @throws ApiException if an error occurs.
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
	 * Deletes a campaign.
	 *
	 * @param  campaignId  ID of the campaign to delete.
	 * @throws ApiException if an error occurs.
	 */
	public void deleteCampaign
		(long campaignId) throws ApiException {
		ApiHelper.getData(this.apiHost,
			"DELETE", "/v3/campaigns/" + campaignId, null);
	}
	
	/**
	 * Retrieves all MO keywords.
	 *
	 * @return API list of MO keywords.
	 * @throws ApiException if an error occurs.
	 */
	public ApiList<ApiMoKeyWord> getKeyWords
		() throws ApiException {
		return getKeyWords(-1, -1);
	}
	
	/**
	 * Retrieves MO keywords by page and page size.
	 *
	 * @param  page     one-based index of the page to query.
	 * @param  pageSize maximum number of entries in a page.
	 * @return API list of MO keywords.
	 * @throws ApiException if an error occurs.
	 */
	public ApiList<ApiMoKeyWord> getKeyWords
		(int page, int pageSize) throws ApiException {
		return ApiHelper.getApiList(ApiMoKeyWord.class,
			this.apiHost, "/v3/keywords", page, pageSize);
	}
	
	/**
	 * Creates a new MO keyword.
	 *
	 * @param  apiMoKeyWord  the MO keyword to create.
	 * @return instance of ApiMoKeyword representing the created keyword.
	 * @throws ApiException if an error occurs.
	 */
	public ApiMoKeyWord create
		(ApiMoKeyWord apiMoKeyWord) throws ApiException {
		try {
			if (apiMoKeyWord == null)
				throw new NullPointerException("apiMoKeyWord");
			return new ApiMoKeyWord(ApiHelper.getJson(this.apiHost,
				"POST", "/v3/keywords", apiMoKeyWord.toJson()));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}
	
	/**
	 * Updates an MO keyword.
	 *
	 * @param  apiMoKeyWord  the MO keyword to update.
	 * @return instance of ApiMoKeyWord representing the updated keyword.
	 * @throws ApiException if an error occurs.
	 */
	public ApiMoKeyWord update
		(ApiMoKeyWord apiMoKeyWord) throws ApiException {
		try {
			if (apiMoKeyWord == null)
				throw new NullPointerException("apiMoKeyWord");
			return new ApiMoKeyWord(ApiHelper.getJson(this.apiHost,
				"PUT", "/v3/keywords/" + apiMoKeyWord.getId(),
					apiMoKeyWord.toJson()));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}
	
	/**
	 * Deletes an MO keyword.
	 *
	 * @param  keywordId  ID of the keyword to delete.
	 * @throws ApiException if an error occurs.
	 */
	public void deleteKeyword
		(long keywordId) throws ApiException {
		ApiHelper.getData(this.apiHost,
			"DELETE", "/v3/keywords/" + keywordId, null);
	}
	
	/**
	 * Adds an MO keyword to campaign.
	 *
	 * @param  campaignId  ID of the campaign to have the MO keyword.
	 * @param  keywordId   ID of the MO keyword to add to campaign.
	 * @return instance of ApiCampaign represented the API campaign to
	 *         which the MO keyword was added.
	 * @throws ApiException if an error occurs.
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
	 * Removes an MO keyword from a campaign.
	 *
	 * @param  campaignId  ID of the campaign having the MO keyword.
	 * @param  keywordId   ID of the keyword to remove from the campaign.
	 * @throws ApiException if an error occurs.
	 */
	public void removeKeywordFromCampaign
		(long campaignId, long keywordId) throws ApiException {
		ApiHelper.getData(this.apiHost, "DELETE", "/v3/campaigns/"
			+ campaignId + "/keywords/" + keywordId, null);
	}
	
	/**
	 * Retrieves all actions on a campaign.
	 *
	 * @param  campaignId  ID of the campaign to query.
	 * @return API list of actions.
	 * @throws ApiException if an error occurs.
	 */
	public ApiList<ApiAction> getActions
		(long campaignId) throws ApiException {
		return getActions(campaignId, -1, -1);
	}
	
	/**
	 * Retrieves actions on a campaign by page and page size.
	 *
	 * @param  campaignId  ID of the campaign to query.
	 * @param  page        one-based index of the page to query.
	 * @param  pageSize    maximum number of entries in a page.
	 * @return API list of actions.
	 * @throws ApiException if an error occurs.
	 */
	public ApiList<ApiAction> getActions
		(long campaignId, int page, int pageSize) throws ApiException {
		return ApiHelper.getApiList(ApiAction.class, this.apiHost,
			"/v3/campaigns/" + campaignId + "/actions", page, pageSize);
	}
	
	/**
	 * Adds a default reply action to campaign.
	 *
	 * @param  campaignId  ID of the campaign to add the action to.
	 * @param  message     the default reply action message to add.
	 * @return instance of ApiCampaign representing the API campaign
	 *         the action was added to.
	 * @throws ApiException if an error occurs.
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
	 * Adds a dynamic URL action, with no send response, to campaign.
	 *
	 * @param  campaignId  ID of the campaign to add the action to.
	 * @param  url         the dynamic URL to add.
	 * @return instance of ApiCampaign representing the API campaign
	 *         the action was added to.
	 * @throws ApiException if an error occurs.
	 */
	public ApiCampaign addDynamicUrlAction
		(long campaignId, String url) throws ApiException {
		return addDynamicUrlAction(campaignId, url, "no");
	}
	
	/**
	 * Adds a dynamic URL action, with send response, to campaign.
	 *
	 * @param  campaignId   ID of the campaign to add the action to.
	 * @param  url          the dynamic URL to add.
	 * @param  sendResponse a yes or no value.
	 * @return instance of ApiCampaign representing the API campaign
	 *         the action was added to.
	 * @throws ApiException if an error occurs.
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
	 * Adds an email address action to campaign.
	 *
	 * @param  campaignId  ID of the campaign to add the action to.
	 * @param  address     the email address to add.
	 * @return instance of ApiCampaign representing the API campaign
	 *         the action was added to.
	 * @throws ApiException if an error occurs.
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
	 * Adds a forward-to-mobile action to campaign.
	 *
	 * @param  campaignId  ID of the campaign to add the action to.
	 * @param  number     the mobile phone number to add.
	 * @return instance of ApiCampaign representing the API campaign
	 *         the action was added to.
	 * @throws ApiException if an error occurs.
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
	 * Adds a forward-to-SMPP action to campaign.
	 *
	 * @param  campaignId  ID of the campaign to add the action to.
	 * @param  appId       the app ID to add.
	 * @return instance of ApiCampaign representing the API campaign
	 *         the action was added to.
	 * @throws ApiException if an error occurs.
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
	
	/**
	 * Removes an action from a campaign.
	 *
	 * @param  campaignId  ID of the campaign to remove the action from.
	 * @param  actionId    ID of the action to remove from campaign.
	 * @return instance of ApiCampaign representing the API campaign
	 *         the action was removed from.
	 * @throws ApiException if an error occurs.
	 */
	public ApiCampaign removeActionFromCampaign
		(long campaignId, long actionId) throws ApiException {
		try {
			return new ApiCampaign(ApiHelper.getJson(this.apiHost, "DELETE",
				"/v3/campaigns/" + campaignId + "/actions/" + actionId, null));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}
}
