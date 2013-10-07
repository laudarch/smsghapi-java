// $Id: ApiContactGroup.java 0 1970-01-01 00:00:00Z mkwayisi $
package com.smsgh;
import com.smsgh.json.JsonValue;
import com.smsgh.json.JsonObject;

public class ApiContactGroup {
	/**
	 * Data fields.
	 */
	private String accountId;
	private long   contactCount;
	private long   groupId;
	private String name;
	
	/**
	 * Primary constructor.
	 */
	public ApiContactGroup() {
	}
	
	/**
	 * Constructor from JSON.
	 */
	public ApiContactGroup(JsonObject json) {
		JsonValue val;
		for (String name : json.names()) {
			val = json.get(name);
			switch (name.toLowerCase()) {
				case "accountid":
					this.accountId = val.asString();
					break;
				case "contactcount":
					this.contactCount = val.asLong();
					break;
				case "groupid":
					this.groupId = val.asLong();
					break;
				case "name":
					this.name = val.asString();
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
	 * Gets contactCount.
	 */
	public long getContactCount() {
		return this.contactCount;
	}
	
	/**
	 * Gets groupId.
	 */
	public long getGroupId() {
		return this.groupId;
	}
	
	/**
	 * Gets name.
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Sets name.
	 */
	public ApiContactGroup setName(String value) {
		this.name = value;
		return this;
	}
	
	/**
	 * toJson.
	 */
	public String toJson() {
		return new JsonObject()
			.add("Name", this.name)
			.toString();
	}
}
