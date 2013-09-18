// $Id: ApiMessage.java 222 2013-08-27 10:07:18Z mkwayisi $
package com.smsgh;
import java.util.Date;
import java.util.UUID;
import java.text.SimpleDateFormat;
import com.smsgh.json.JsonValue;
import com.smsgh.json.JsonObject;

public class ApiMessage {
	
	/**
	 * Data fields.
	 */
	private int apiMessageType = -1;
	private String clientReference;
	private String content;
	private String direction;
	private boolean flashMessage;
	private String from;
	private UUID id;
	private String networkId;
	private double rate;
	private boolean registeredDelivery;
	private String status;
	private Date time;
	private String to;
	private String udh;
	private double units;
	private Date updateTime;
	
	/**
	 * Primary constructor.
	 */
	public ApiMessage() {
	
	}
	
	/**
	 * Constructor to parse Json.
	 */
	public ApiMessage(String data) throws ApiException {
		try {
			JsonValue jsonValue;
			JsonObject jsonObject = JsonObject.readFrom(data);
			for (String name : jsonObject.names()) {
				jsonValue = jsonObject.get(name);
				switch (name.toLowerCase()) {
					case "apimessagetype":
						this.apiMessageType = jsonValue.asInt();
						break;
					case "clientreference":
						this.clientReference = jsonValue.asString();
						break;
					case "content":
						this.content = jsonValue.asString();
						break;
					case "direction":
						this.content = jsonValue.asString();
						break;
					case "flashmessage":
						this.flashMessage = jsonValue.asBoolean();
						break;
					case "from":
						this.from = jsonValue.asString();
						break;
					case "messageid":
						String msgId = jsonValue.asString();
						StringBuilder buf = new StringBuilder();
						if (msgId.length() == 32) {
							buf
								.append(msgId.substring(0, 8))
								.append('-')
								.append(msgId.substring(8, 12))
								.append('-')
								.append(msgId.substring(12, 16))
								.append('-')
								.append(msgId.substring(16, 20))
								.append('-')
								.append(msgId.substring(20));
							msgId = buf.toString();
						}
						this.id = UUID.fromString(msgId);
						break;
					case "networkid":
						this.networkId = jsonValue.asString();
						break;
					case "rate":
						this.rate = jsonValue.asDouble();
						break;
					case "registereddelivery":
						this.registeredDelivery = jsonValue.asBoolean();
						break;
					case "status":
						this.status = jsonValue.asString();
						break;
					case "time":
						this.time =
							new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
								.parse(jsonValue.asString());
						break;
					case "to":
						this.to = jsonValue.asString();
						break;
					case "udh":
						this.udh = jsonValue.asString();
						break;
					case "units":
						this.units = jsonValue.asDouble();
						break;
					case "updatetime":
						this.updateTime = 
							new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
								.parse(jsonValue.asString());
						break;
				}
			}
		} catch (Exception ex) {
			throw new ApiException(
				"Could not construct ApiMessage instance from response: "
					+ ex);
		}
	}
	
	/**
	 * Gets apiMessageType.
	 */
	public int getApiMessageType() {
		return this.apiMessageType;
	}
	
	/**
	 * Gets clientReference.
	 */
	public String getClientReference() {
		return this.clientReference;
	}
	
	/**
	 * Gets content.
	 */
	public String getContent() {
		return this.content;
	}
	
	/**
	 * Gets direction.
	 */
	public String getDirection() {
		return this.direction;
	}
	
	/**
	 * Gets flashMessage.
	 */
	public boolean isFlashMessage() {
		return this.flashMessage;
	}
	
	/**
	 * Gets from.
	 */
	public String getFrom() {
		return this.from;
	}
	
	/**
	 * Gets id.
	 */
	public UUID getId() {
		return this.id;
	}
	
	/**
	 * Gets id.
	 */
	public UUID getMessageId() {
		return this.id;
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
	 * Gets registeredDelivery
	 */
	public boolean isRegisteredDelivery() {
		return this.registeredDelivery;
	}
	
	/**
	 * Gets status.
	 */
	public String getStatus() {
		return this.status;
	}
	
	/**
	 * Gets time.
	 */
	public Date getTime() {
		return this.time;
	}
	
	/**
	 * Gets to.
	 */
	public String getTo() {
		return this.to;
	}
	
	/**
	 * Gets udh.
	 */
	public String getUdh() {
		return this.udh;
	}
	
	/**
	 * Gets units.
	 */
	public double getUnits() {
		return this.units;
	}
	
	/**
	 * Gets updateTime.
	 */
	public Date getUpdateTime() {
		return this.updateTime;
	}
	
	/**
	 * Sets apiMessageType.
	 */
	public ApiMessage setApiMessageType(int value) {
		this.apiMessageType = value;
		return this;
	}
	
	/**
	 * Sets clientReference.
	 */
	public ApiMessage setClientReference(String value) {
		this.clientReference = value;
		return this;
	}
	
	/**
	 * Sets content.
	 */
	public ApiMessage setContent(String value) {
		this.content = value;
		return this;
	}
	
	/**
	 * Sets flashMessage.
	 */
	public ApiMessage setFlashMessage(boolean value) {
		this.flashMessage = value;
		return this;
	}
	
	/**
	 * Sets from.
	 */
	public ApiMessage setFrom(String value) {
		this.from = value;
		return this;
	}
	
	/**
	 * Sets id.
	 */
	public ApiMessage setId(UUID value) {
		this.id = value;
		return this;
	}
	
	/**
	 * Sets id.
	 */
	public ApiMessage setMessageId(UUID value) {
		this.id = value;
		return this;
	}
	
	/**
	 * Sets registeredDelivery.
	 */
	public ApiMessage setRegisteredDelivery(boolean value) {
		this.registeredDelivery = value;
		return this;
	}
	
	/**
	 * Sets time.
	 */
	public ApiMessage setTime(Date value) {
		this.time = value;
		return this;
	}
	
	/**
	 * Sets to.
	 */
	public ApiMessage setTo(String value) {
		this.to = value;
		return this;
	}
	
	/**
	 * Sets udh.
	 */
	public ApiMessage setUdh(String value) {
		this.udh = value;
		return this;
	}
	
	/**
	 * Returns this message as serialized.
	 */
	public String serialize() {
		JsonObject jsonObject = new JsonObject()
			.set("From", this.from)
			.set("To", this.to)
			.set("Content", this.content);
			
		if (this.apiMessageType >= 0)
			jsonObject.set("ApiMessageType", this.apiMessageType);
		if (this.udh != null)
			jsonObject.set("Udh", this.udh);
		if (this.time != null) {
			jsonObject.set("Time",
				new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
					.format(this.time));
		}
		if (this.clientReference != null)
			jsonObject.set("ClientReference", this.clientReference);
		if (this.registeredDelivery)
			jsonObject.set("RegisteredDelivery", true);
		if (this.flashMessage)
			jsonObject.set("FlashMessage", true);
			
		return jsonObject.toString();
	}
}
