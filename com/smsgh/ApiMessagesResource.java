/**
 * $Id: ApiMessagesResource.java 225 2013-08-29 11:29:43Z mkwayisi $
 */
package com.smsgh;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import com.smsgh.json.JsonValue;
import com.smsgh.json.JsonObject;

public class ApiMessagesResource {
	
	/**
	 * Data fields.
	 */
	private SmsghApi apiHost;
	private ApiRequest apiRequest;
	
	/**
	 * Primary constructor.
	 */
	public ApiMessagesResource(SmsghApi apiHost) {
		this.apiHost = apiHost;
	}
	
	/**
	 * Initializes apiRequest.
	 */
	private ApiRequest init() {
		if (this.apiRequest == null) {
			this.apiRequest =
				new ApiRequest(
					this.apiHost.getHostname(),
					this.apiHost.getPort(),
					this.apiHost.isHttps() ? "ssl" : "tcp",
					this.apiHost.getTimeout(),
					this.apiHost.getClientId(),
					this.apiHost.getClientSecret()
					);
		}
		return this.apiRequest;
	}
	
	/**
	 * Sends a message.
	 */
	public ApiMessageResponse send(ApiMessage apiMessage)
		throws ApiException {
		ApiResponse apiResponse = this.init()
			.setMethod("POST")
			.setUri("/v3/messages")
			.setHeader("Accept", "application/json")
			.setHeader("Content-type", "application/json")
			.send(apiMessage.serialize());
		if (apiResponse.getStatus() > 199 && apiResponse.getStatus() < 300)
			return new ApiMessageResponse(apiResponse.getBody());
		throw new ApiException("Request failed: "
			+ apiResponse.getStatus() + " " + apiResponse.getReason());
	}
	
	/**
	 * Sends a quick message.
	 */
	public ApiMessageResponse send(String from, String to, String content)
		throws ApiException {
		return this.send(new ApiMessage()
			.setFrom(from).setTo(to).setContent(content));
	}
	
	/**
	 * Schedules a message.
	 */
	public ApiMessageResponse schedule(ApiMessage apiMessage, Date time)
		throws ApiException {
		return this.send(apiMessage.setTime(time));
	}
	
	/**
	 * Reschedules a message.
	 */
	public ApiMessageResponse reschedule(String messageId, Date time)
		throws ApiException {
		StringBuffer sbJson = new StringBuffer()
			.append("{\"Time\":\"")
			.append(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(time))
			.append("\"}");
		ApiResponse apiResponse = this.init()
			.setMethod("PUT")
			.setUri("/v3/messages/" + messageId)
			.setHeader("accept", "application/json")
			.setHeader("content-type", "applicaton/json")
			.send(sbJson.toString());
			
		if (apiResponse.getStatus() > 199 && apiResponse.getStatus() < 300)
			return new ApiMessageResponse(apiResponse.getBody());
		throw new ApiException("Request failed: "
			+ apiResponse.getStatus() + " " + apiResponse.getReason());
	}
	
	/**
	 * Cancels a scheduled message.
	 */
	public ApiMessageResponse cancel(String id)
		throws ApiException {
		ApiResponse apiResponse = this.init()
			.setMethod("DELETE")
			.setUri("/v3/messages/" + id)
			.setHeader("accept", "application/json")
			.send(null);
		if (apiResponse.getStatus() > 199 && apiResponse.getStatus() < 300)
			return new ApiMessageResponse(apiResponse.getBody());
		throw new ApiException("Request failed: "
			+ apiResponse.getStatus() + " " + apiResponse.getReason());
	}
	
	/**
	 * Gets a message.
	 */
	public ApiMessage getMessage(String id) throws ApiException {
		ApiResponse apiResponse = this.init()
			.setMethod("GET")
			.setUri("/v3/messages/" + id)
			.setHeader("accept", "application/json")
			.send(null);
		if (apiResponse.getStatus() > 199 && apiResponse.getStatus() < 300)
			return new ApiMessage(apiResponse.getBody());
		throw new ApiException("Request failed: "
			+ apiResponse.getStatus() + " " + apiResponse.getReason());
	}
	
	/**
	 * Gets messages.
	 */
	public List<ApiMessage> getMessages() throws ApiException {
		return this.getMessages(-1, -1, null, null, false, null);
	}
	
	/**
	 * Gets messages.
	 */
	public List<ApiMessage> getMessages(int index, int limit)
		throws ApiException {
		return this.getMessages(index, limit, null, null, false, null);
	}
	
	/**
	 * Gets messages.
	 */
	public List<ApiMessage> getMessages(int index, int limit,
		Date start, Date end, boolean pending, String direction)
		throws ApiException {
		ArrayList<ApiMessage> apiMessages = new ArrayList<ApiMessage>();
		StringBuilder sbUri = new StringBuilder().append("/v3/messages");
		ApiResponse apiResponse;
		
		sbUri.append("?index=").append(index > 0 ? index : 0);
		if (limit > 0)
			sbUri.append("&limit=").append(limit);
		if (start != null) {
			sbUri.append("&start=").append(
				new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
					.format(start).replace(' ', '+').replace(":", "%3A"));
		}
		if (end != null) {
			sbUri.append("&end=").append(
				new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
					.format(end).replace(' ', '+').replace(":", "%3A"));
		}
		if (pending)
			sbUri.append("&pending=true");
		if (direction != null) {
			sbUri.append("&direction=")
				.append(direction.toLowerCase().equals("in") ? "in" : "out");
		}
		
		apiResponse = this.init()
			.setMethod("GET")
			.setUri(sbUri.toString())
			.setHeader("accept", "application/json")
			.send(null);
			
		if (apiResponse.getStatus() > 199 && apiResponse.getStatus() < 300) {
			JsonObject jsonObject = JsonObject.readFrom(apiResponse.getBody());
			JsonValue jsonValue = jsonObject.get("Messages");
			if (jsonValue != null) {
				for (JsonValue jsonMessage : jsonValue.asArray())
					apiMessages.add(new ApiMessage(jsonMessage.toString()));
			}
		} else throw new ApiException("Request failed: "
			+ apiResponse.getStatus() + " " + apiResponse.getReason());
			
		return apiMessages;
	}
}
