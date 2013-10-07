// $Id: ApiInvoice.java 0 1970-01-01 00:00:00Z mkwayisi $
package com.smsgh;
import java.util.Date;
import com.smsgh.json.JsonValue;
import com.smsgh.json.JsonObject;

public class ApiInvoice {
	/**
	 * Data fields.
	 */
	private double  amount;
	private Date    created;
	private String  description;
	private Date    dueDate;
	private double  ending;
	private long    id;
	private boolean isPaid;
	private String  type;
	
	/**
	 * Constructor from JSON.
	 */
	public ApiInvoice(JsonObject json) {
		JsonValue val;
		for (String name : json.names()) {
			val = json.get(name);
			switch (name.toLowerCase()) {
				case "amount":
					this.amount = val.asDouble();
				case "created":
					this.created = val.asDate();
					break;
				case "description":
					this.description = val.asString();
					break;
				case "duedate":
					this.dueDate = val.asDate();
					break;
				case "ending":
					this.ending = val.asDouble();
					break;
				case "id":
					this.id = val.asLong();
					break;
				case "ispaid":
					this.isPaid = val.asBoolean();
					break;
				case "type":
					this.type = val.asString();
					break;
			}
		}
	}
	
	/**
	 * Gets amount.
	 */
	public double getAmount() {
		return this.amount;
	}
	
	/**
	 * Gets created.
	 */
	public Date getCreated() {
		return this.created;
	}
	
	/**
	 * Gets description.
	 */
	public String getDescription() {
		return this.description;
	}
	
	/**
	 * Gets dueDate.
	 */
	public Date getDueDate() {
		return this.dueDate;
	}
	
	/**
	 * Gets ending.
	 */
	public double getEnding() {
		return this.ending;
	}
	
	/**
	 * Gets id.
	 */
	public long getId() {
		return this.id;
	}
	
	/**
	 * Gets isPaid.
	 */
	public boolean isPaid() {
		return this.isPaid;
	}
	
	/**
	 * Gets type.
	 */
	public String getType() {
		return this.type;
	}
}
