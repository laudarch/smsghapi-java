// $Id: ApiTemplate.java 0 1970-01-01 00:00:00Z mkwayisi $
package com.smsgh;
import java.util.Date;
import com.smsgh.json.JsonValue;
import com.smsgh.json.JsonObject;

public class ApiTemplate {
	/**
	 * Data fields.
	 */
	private String accountId;
	private Date   dateCreated;
	private long   id;
	private String name;
	private String text;
	
	/**
	 * Primary constructor.
	 */
	public ApiTemplate() {
	}
	
	/**
	 * Constructor from JSON.
	 */
	public ApiTemplate(JsonObject json) {
		JsonValue val;
		for (String name : json.names()) {
			val = json.get(name);
			switch (name.toLowerCase()) {
				case "accountid":
					this.accountId = val.asString();
					break;
				case "datecreated":
					this.dateCreated = val.asDate();
					break;
				case "id":
					this.id = val.asLong();
					break;
				case "name":
					this.name = val.asString();
					break;
				case "text":
					this.text = val.asString();
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
	 * Gets dateCreated.
	 */
	public Date getDateCreated() {
		return this.dateCreated;
	}
	
	/**
	 * Gets id.
	 */
	public long getId() {
		return this.id;
	}
	
	/**
	 * Gets name.
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Gets text.
	 */
	public String getText() {
		return this.text;
	}
	
	/**
	 * Sets name.
	 */
	public ApiTemplate setName(String value) {
		this.name = value;
		return this;
	}
	
	/**
	 * Sets text.
	 */
	public ApiTemplate setText(String value) {
		this.text = value;
		return this;
	}
	
	/**
	 * toJson.
	 */
	public String toJson() {
		return new JsonObject()
			.add("Name", this.name)
			.add("Text", this.text)
			.toString();
	}
}
