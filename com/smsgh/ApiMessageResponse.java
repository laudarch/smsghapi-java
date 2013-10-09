// $Id: ApiMessageResponse.java 0 1970-01-01 00:00:00Z mkwayisi $
package com.smsgh;
import com.smsgh.json.JsonValue;
import com.smsgh.json.JsonObject;

public class ApiMessageResponse {
	
	/**
	 * Data fields.
	 */
	private String clientReference;
	private String detail;
	private String messageId;
	private String networkId;
	private int    status;
	private double rate;
	
	/**
	 * Primary constructor.
	 */
	public ApiMessageResponse(String response) throws ApiException {
		try {
			JsonValue val;
			JsonObject jsonObject = JsonObject.readFrom(response);
			for (String name : jsonObject.names()) {
				val = jsonObject.get(name);
				switch (name.toLowerCase()) {
					case "status":
						this.status = val.asInt();
						break;
					case "messageid":
						this.messageId = val.asString();
						break;
					case "rate":
						this.rate = val.asDouble();
						break;
					case "networkid":
						this.networkId = val.asString();
						break;
					case "clientreference":
						this.clientReference = val.asString();
						break;
					case "detail":
						this.detail = val.asString();
						break;
				}
			}
		} catch (Exception ex) {
			throw new ApiException(
				"Could not construct ApiMessageResponse instance from response: "
					+ ex);
		}
	}
	
	/**
	 * Gets stats.
	 */
	public int getStatus() {
		return this.status;
	}
	
	/**
	 * Gets messageId.
	 */
	public String getMessageId() {
		return this.messageId;
	}
	
	/**
	 * Gets rate.
	 */
	public double getRate() {
		return this.rate;
	}
	
	/**
	 * Gets networkId.
	 */
	public String getNetworkId() {
		return this.networkId;
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
}
