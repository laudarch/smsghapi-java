// $Id: ApiMessageResponse.java 222 2013-08-27 10:07:18Z mkwayisi $
package com.smsgh;
import com.smsgh.json.JsonValue;
import com.smsgh.json.JsonObject;

public class ApiMessageResponse {
	
	/**
	 * Data fields.
	 */
	private int status;
	private String messageId;
	private double rate;
	private String networkId;
	private String clientReference;
	private String detail;
	
	/**
	 * Primary constructor.
	 */
	public ApiMessageResponse(String response) throws ApiException {
		try {
			JsonValue jsonValue;
			JsonObject jsonObject = JsonObject.readFrom(response);
			for (String name : jsonObject.names()) {
				jsonValue = jsonObject.get(name);
				switch (name.toLowerCase()) {
					case "status":
						this.status = jsonValue.asInt();
						break;
					case "messageid":
						this.messageId = jsonValue.asString();
						break;
					case "rate":
						this.rate = jsonValue.asDouble();
						break;
					case "networkid":
						this.networkId = jsonValue.asString();
						break;
					case "clientreference":
						this.clientReference = jsonValue.asString();
						break;
					case "detail":
						this.detail = jsonValue.asString();
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
