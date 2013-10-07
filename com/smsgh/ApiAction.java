// $Id: ApiAction.java 0 1970-01-01 00:00:00Z mkwayisi $
package com.smsgh;
import com.smsgh.json.JsonValue;
import com.smsgh.json.JsonObject;

public class ApiAction {
	/**
	 * Data fields.
	 */
	private String  actionMeta;
	private long    actionTypeId;
	private long    campaignId;
	private long    id;
	private boolean isActive;
	
	/**
	 * Constructor from JSON.
	 */
	public ApiAction(JsonObject json) {
		JsonValue val;
		for (String name : json.names()) {
			val = json.get(name);
			switch (name.toLowerCase()) {
				case "actionmeta":
					this.actionMeta = val.asString();
					break;
				case "actiontypeid":
					this.actionTypeId = val.asLong();
					break;
				case "campaignid":
					this.campaignId = val.asLong();
					break;
				case "id":
					this.id = val.asLong();
					break;
				case "isactive":
					this.isActive = val.asBoolean();
					break;
			}
		}
	}
	
	/**
	 * Gets actionMeta.
	 */
	public String getActionMeta() {
		return this.actionMeta;
	}
	
	/**
	 * Gets actionTypeId.
	 */
	public long getActionTypeId() {
		return this.actionTypeId;
	}
	
	/**
	 * Gets campaignId.
	 */
	public long getCampaignId() {
		return this.campaignId;
	}
	
	/**
	 * Gets id.
	 */
	public long getId() {
		return this.id;
	}
	
	/**
	 * Gets isActive.
	 */
	public boolean isActive() {
		return this.isActive;
	}
}
