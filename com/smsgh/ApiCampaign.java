// $Id: ApiCampaign.java 0 1970-01-01 00:00:00Z mkwayisi $
package com.smsgh;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import com.smsgh.json.JsonValue;
import com.smsgh.json.JsonObject;

public class ApiCampaign {
	/**
	 * Data fields.
	 */
	private String             accountId;
	private List<ApiAction>    actions;
	private String             brief;
	private long               campaignId;
	private Date               dateCreated;
	private Date               dateEnded;
	private String             description;
	private boolean            enabled;
	private boolean            isDefault;
	private List<ApiMoKeyword> moKeywords;
	private boolean            pendingApproval;
	
	/**
	 * Primary constructor.
	 */
	public ApiCampaign() {
	}
	
	/**
	 * Constructor from JSON.
	 */
	public ApiCampaign(JsonObject json) {
		JsonValue val;
		this.actions = new ArrayList<ApiAction>();
		this.moKeywords = new ArrayList<ApiMoKeyword>();
		
		for (String name : json.names()) {
			val = json.get(name);
			switch (name.toLowerCase()) {
				case "accountid":
					this.accountId = val.asString();
					break;
				case "actions":
					for (JsonValue v : val.asArray())
						this.actions.add(new ApiAction(v.asObject()));
					break;
				case "brief":
					this.brief = val.asString();
					break;
				case "campaignid":
					this.campaignId = val.asLong();
					break;
				case "datecreated":
					this.dateCreated = val.asDate();
					break;
				case "dateended":
					this.dateEnded = val.asDate();
					break;
				case "description":
					this.description = val.asString();
					break;
				case "enabled":
					this.enabled = val.asBoolean();
					break;
				case "isdefault":
					this.isDefault = val.asBoolean();
					break;
				case "mokeywords":
					for (JsonValue v : val.asArray())
						this.moKeywords.add(new ApiMoKeyword(v.asObject()));
					break;
				case "pendingapproval":
					this.pendingApproval = val.asBoolean();
					break;
			}
		}
	}
	
	/**
	 * Gets accountId.
	 */
	public String getAccountId() {
		return this.accountId;
	}
	
	/**
	 * Gets actions.
	 */
	public List<ApiAction> getActions() {
		return this.actions;
	}
	
	/**
	 * Gets brief.
	 */
	public String getBrief() {
		return this.brief;
	}
	
	/**
	 * Gets campaignId.
	 */
	public long getCampaignId() {
		return this.campaignId;
	}
	
	/**
	 * Gets dateCreated.
	 */
	public Date getDateCreated() {
		return this.dateCreated;
	}
	
	/**
	 * Gets dateEnded.
	 */
	public Date getDateEnded() {
		return this.dateEnded;
	}
	
	/**
	 * Gets description.
	 */
	public String getDescription() {
		return this.description;
	}
	
	/**
	 * Gets enabled.
	 */
	public boolean getEnabled() {
		return this.enabled;
	}
	
	/**
	 * Gets isDefault.
	 */
	public boolean isDefault() {
		return this.isDefault;
	}
	
	/**
	 * Gets moKeywords.
	 */
	public List<ApiMoKeyword> getMoKeywords() {
		return this.moKeywords;
	}
	
	/**
	 * Gets pendingApproval.
	 */
	public boolean getPendingApproval() {
		return this.pendingApproval;
	}
	
	/**
	 * Sets brief.
	 */
	public ApiCampaign setBrief(String value) {
		this.brief = value;
		return this;
	}
	
	/**
	 * Sets description.
	 */
	public ApiCampaign setDescription(String value) {
		this.description = value;
		return this;
	}
	
	/**
	 * Sets dateCreated.
	 */
	public ApiCampaign setDateCreated(Date value) {
		this.dateCreated = value;
		return this;
	}
	
	/**
	 * Sets dateEndend.
	 */
	public ApiCampaign setDateEnded(Date value) {
		this.dateEnded = value;
		return this;
	}
	
	/**
	 * toJson.
	 */
	public String toJson() {
		return new JsonObject()
			.add("Brief", this.brief)
			.add("DateCreated", this.dateCreated)
			.add("DateEnded", this.dateEnded)
			.add("Description", this.description)
			.toString();
	}
}
