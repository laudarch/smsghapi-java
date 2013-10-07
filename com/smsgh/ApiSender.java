// $Id: ApiSender.java 0 1970-01-01 00:00:00Z mkwayisi $
package com.smsgh;
import java.util.Date;
import com.smsgh.json.JsonValue;
import com.smsgh.json.JsonObject;

public class ApiSender {
	/**
	 * Data fields.
	 */
	private String  accountId;
	private String  address;
	private long    id;
	private boolean isDeleted;
	private Date    timeAdded;
	private Date    timeDeleted;
	
	/**
	 * Primary constructor.
	 */
	public ApiSender() {
	}
	
	/**
	 * Constructor from JSON.
	 */
	public ApiSender(JsonObject json) {
		JsonValue val;
		for (String name : json.names()) {
			val = json.get(name);
			switch (name.toLowerCase()) {
				case "accountid":
					this.accountId = val.asString();
					break;
				case "address":
					this.address = val.asString();
					break;
				case "id":
					this.id = val.asLong();
					break;
				case "isdeleted":
					this.isDeleted = val.asBoolean();
					break;
				case "timeadded":
					this.timeAdded = val.asDate();
					break;
				case "timedeleted":
					this.timeDeleted = val.asDate();
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
	 * Gets address.
	 */
	public String getAddress() {
		return this.address;
	}
	
	/**
	 * Gets id.
	 */
	public long getId() {
		return this.id;
	}
	
	/**
	 * Gets isDeleted.
	 */
	public boolean isDeleted() {
		return this.isDeleted;
	}
	
	/**
	 * Gets timeAdded.
	 */
	public Date getTimeAdded() {
		return this.timeAdded;
	}
	
	/**
	 * Gets timeDeleted.
	 */
	public Date getTimeDeleted() {
		return this.timeDeleted;
	}
	
	/**
	 * Sets address.
	 */
	public ApiSender setAddress(String value) {
		this.address = value;
		return this;
	}
	
	/**
	 * toJson.
	 */
	public String toJson() {
		return new JsonObject()
			.add("Address", this.address)
			.toString();
	}
}
