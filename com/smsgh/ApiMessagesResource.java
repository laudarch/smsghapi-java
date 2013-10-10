// $Id: ApiMessagesResource.java 0 1970-01-01 00:00:00Z mkwayisi $
package com.smsgh;
import java.util.Date;
import java.util.UUID;
import java.text.SimpleDateFormat;
import java.net.URLEncoder;
import com.smsgh.json.JsonObject;

public class ApiMessagesResource {
	private SmsghApi apiHost;
	
	/**
	 * Primary constructor.
	 */
	public ApiMessagesResource(SmsghApi apiHost) {
		this.apiHost = apiHost;
	}
	
	/**
	 * Sends a quick message.
	 */
	public ApiMessageResponse send
		(String from, String to, String content) throws ApiException {
		ApiMessage apiMessage = new ApiMessage();
		apiMessage.setFrom(from).setTo(to).setContent(content);
		return this.send(apiMessage);
	}
	
	/**
	 * Sends a message.
	 */
	public ApiMessageResponse send
		(ApiMessage apiMessage) throws ApiException {
		try {
			if (apiMessage == null)
				throw new NullPointerException("apiMessage");
			return new ApiMessageResponse(ApiHelper.getJson
				(this.apiHost, "POST", "/v3/messages", apiMessage.toJson()));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}
	
	/**
	 * Schedules a message.
	 */
	public ApiMessageResponse schedule
		(ApiMessage apiMessage, Date time) throws ApiException {
		if (apiMessage != null)
			apiMessage.setTime(time);
		return this.send(apiMessage);
	}
	
	/**
	 * Reschedules a message by ID and time.
	 */
	public ApiMessageResponse reschedule
		(UUID messageId, Date time) throws ApiException {
		try {
			if (messageId == null)
				throw new NullPointerException("messageId");
			if (time == null)
				throw new NullPointerException("time");
			return new ApiMessageResponse(ApiHelper.getJson
				(this.apiHost, "PUT", "/v3/messages/"
					+ messageId.toString().replace("-", ""),
						new JsonObject().add("Time", time).toString()));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}
	
	/**
	 * Cancels scheduled message by ID.
	 */
	public ApiMessageResponse cancel
		(UUID messageId) throws ApiException {
		try {
			if (messageId == null)
				throw new NullPointerException("messageId");
			return new ApiMessageResponse(ApiHelper.getJson
				(this.apiHost, "DELETE", "/v3/messages/"
					+ messageId.toString().replace("-", ""), null));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}
	
	/**
	 * Gets message by ID.
	 */
	public ApiMessage get
		(UUID messageId) throws ApiException {
		try {
			if (messageId == null)
				throw new NullPointerException("messageId");
			return new ApiMessage(ApiHelper.getJson(this.apiHost,
				"GET", "/v3/messages/" + messageId.toString().replace("-", ""), null));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}
	
	/**
	 * Gets messages by several params.
	 */
	public ApiList<ApiMessage> get
		(Date start, Date end, int index, int limit, boolean pending,
			String direction) throws ApiException {
		boolean hasQ = false;
		StringBuilder sb = new StringBuilder();
		sb.append("/v3/messages");
		
		try {
			if (start != null) {
				sb.append("?start=").append(URLEncoder.encode
					(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(start), "utf-8"));
				if (!hasQ) hasQ = true;
			}
			
			if (end != null) {
				sb.append(hasQ ? "&" : "?").append("end=").append(URLEncoder.encode
					(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(end), "utf-8"));
				if (!hasQ) hasQ = true;
			}
			
			if (index > 0) {
				sb.append(hasQ ? "&" : "?")
					.append("index=").append(index);
				if (!hasQ) hasQ = true;
			}
			
			if (limit > 0) {
				sb.append(hasQ ? "&" : "?")
					.append("limit=").append(limit);
				if (!hasQ) hasQ = true;
			}
			
			if (pending) {
				sb.append(hasQ ? "&" : "?").append("pending=true");
				if (!hasQ) hasQ = true;
			}
			
			if (direction != null) {
				sb.append(hasQ ? "&" : "?")
					.append("direction=")
					.append(URLEncoder.encode(direction, "utf-8"));
			}
			
			return ApiHelper.getApiList
				(ApiMessage.class, this.apiHost, sb.toString(), -1, -1);
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}
}
