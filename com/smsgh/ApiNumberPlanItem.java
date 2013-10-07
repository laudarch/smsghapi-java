// $Id: ApiNumberPlanItem.java 0 1970-01-01 00:00:00Z mkwayisi $
package com.smsgh;
import com.smsgh.json.JsonValue;
import com.smsgh.json.JsonObject;

public class ApiNumberPlanItem {
	/**
	 * Data fields.
	 */
	private long   id;
	private String network;
	private double payout;
	private double reversePayout;
	private String shortCode;
	
	/**
	 * Constructor from JSON.
	 */
	public ApiNumberPlanItem(JsonObject json) {
		JsonValue val;
		for (String name : json.names()) {
			val = json.get(name);
			switch (name.toLowerCase()) {
				case "id":
					this.id = val.asLong();
					break;
				case "network":
					this.network = val.asString();
					break;
				case "payout":
					this.payout = val.asDouble();
					break;
				case "reversepayout":
					this.reversePayout = val.asDouble();
					break;
				case "shortcode":
					this.shortCode = val.asString();
					break;
			}
		}
	}
	
	/**
	 * Gets id.
	 */
	public long getId() {
		return this.id;
	}
	
	/**
	 * Gets network.
	 */
	public String getNetwork() {
		return this.network;
	}
	
	/**
	 * Gets payout.
	 */
	public double getPayout() {
		return this.payout;
	}
	
	/**
	 * Gets reversePayout.
	 */
	public double getReversePayout() {
		return this.reversePayout;
	}
	
	/**
	 * Gets shortCode.
	 */
	public String getShortCode() {
		return this.shortCode;
	}
}
