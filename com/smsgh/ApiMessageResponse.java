// $Id: ApiMessageResponse.java 0 1970-01-01 00:00:00Z mkwayisi $
package com.smsgh;
import java.util.UUID;
import com.smsgh.json.JsonValue;
import com.smsgh.json.JsonObject;

public class ApiMessageResponse {
	
	/**
	 * Data fields.
	 */
	private String clientReference;
	private String detail;
	private UUID   messageId;
	private String networkId;
	private int    status;
	private double rate;
	
	/**
	 * Primary constructor.
	 */
	public ApiMessageResponse(JsonObject json) {
		JsonValue val;
		for (String name : json.names()) {
			val = json.get(name);
			switch (name.toLowerCase()) {
				case "clientreference":
					this.clientReference = val.asString();
					break;
				case "detail":
					//this.detail = val.asString();
					break;
				case "messageid":
					this.messageId = val.asUUID();
					break;
				case "networkid":
					this.networkId = val.asString();
					break;
				case "rate":
					this.rate = val.asDouble();
					break;
				case "status":
					this.status = val.asInt();
					break;
			}
		}
	}
	
	/**
	 * Gets clientReference.
	 */
	public String getClientReference() {
		return this.clientReference;
	}
	
	/**
	 * Gets detail.
	 */
	public String getDetail() {
		return this.detail;
	}
	
	/**
	 * Gets messageId.
	 */
	public UUID getMessageId() {
		return this.messageId;
	}
	
	/**
	 * Gets networkId.
	 */
	public String getNetworkId() {
		return this.networkId;
	}
	
	/**
	 * Gets rate.
	 */
	public double getRate() {
		return this.rate;
	}
	
	/**
	 * Gets stats.
	 */
	public int getStatus() {
		return this.status;
	}
}
