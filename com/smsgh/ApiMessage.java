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
	private int     apiMessageType = -1;
	private String  clientReference;
	private String  content;
	private String  direction;
	private boolean flashMessage;
	private String  from;
	private UUID    messageId;
	private String  networkId;
	private double  rate;
	private boolean registeredDelivery;
	private String  status;
	private Date    time;
	private String  to;
	private String  udh;
	private double  units;
	private Date    updateTime;
	
	/**
	 * Primary constructor.
	 */
	public ApiMessage() {
	
	}
	
	/**
	 * Constructor to parse Json.
	 */
	public ApiMessage(JsonObject json) {
		JsonValue val;
		for (String name : json.names()) {
			val = json.get(name);
			switch (name.toLowerCase()) {
				case "apimessagetype":
					this.apiMessageType = val.asInt();
					break;
				case "clientreference":
					this.clientReference = val.asString();
					break;
				case "content":
					this.content = val.asString();
					break;
				case "direction":
					this.content = val.asString();
					break;
				case "flashmessage":
					this.flashMessage = val.asBoolean();
					break;
				case "from":
					this.from = val.asString();
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
				case "registereddelivery":
					this.registeredDelivery = val.asBoolean();
					break;
				case "status":
					this.status = val.asString();
					break;
				case "time":
					this.time = val.asDate();
					break;
				case "to":
					this.to = val.asString();
					break;
				case "udh":
					this.udh = val.asString();
					break;
				case "units":
					this.units = val.asDouble();
					break;
				case "updatetime":
					this.updateTime = val.asDate();
					break;
			}
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
	public boolean getFlashMessage() {
		return this.flashMessage;
	}
	
	/**
	 * Gets from.
	 */
	public String getFrom() {
		return this.from;
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
	 * Gets registeredDelivery.
	 */
	public boolean getRegisteredDelivery() {
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
	 * toJson
	 */
	public String toJson() {
		return new JsonObject()
			.add("ApiMessageType", this.apiMessageType)
			.add("ClientReference", this.clientReference)
			.add("Content", this.content)
			.add("FlashMessage", this.flashMessage)
			.add("From", this.from)
			.add("RegisteredDelivery", this.registeredDelivery)
			.add("Time", this.time)
			.add("To", this.to)
			.add("Udh", this.udh)
			.toString();
	}
}
