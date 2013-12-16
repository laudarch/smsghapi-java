// $Id: ApiMessagesResource.java 0 1970-01-01 00:00:00Z mkwayisi $
package com.smsgh;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import com.smsgh.json.JsonObject;

/**
 * Represents an API messages resource.
 * 
 * @author Michael Kwayisi
 */
public class ApiMessagesResource {
	private SmsghApi apiHost;
	/**
	 * Initializes a new instance of this class.
	 */
	public ApiMessagesResource(SmsghApi apiHost) {
		this.apiHost = apiHost;
	}

	/**
	 * Sends a quick SMS message.
	 * 
	 * @param from sender address of the message.
	 * @param to recipient phone number of the message.
	 * @param content content of the message.
	 * @return instance of ApiMessageResponse.
	 * @throws ApiException if an error occurs.
	 */
	public ApiMessageResponse send(String from, String to, String content) throws ApiException {
		ApiMessage apiMessage = new ApiMessage();
		apiMessage.setFrom(from).setTo(to).setContent(content);
		return this.send(apiMessage);
	}

	/**
	 * Sends an API message.
	 * 
	 * @param apiMessage the API message to send.
	 * @return instance of ApiMessageResponse.
	 * @throws ApiException if an error occurs.
	 */
	public ApiMessageResponse send(ApiMessage apiMessage) throws ApiException {
		try {
			if (apiMessage == null)
				throw new NullPointerException("apiMessage");
			String uri = "/" + this.apiHost.getContextPath() + "/messages/";
			if(apiHost.getContextPath() == null || apiHost.getContextPath().length() == 0)
				uri = "/messages/";
			return new ApiMessageResponse(ApiHelper.getJson(this.apiHost, "POST", uri, apiMessage.toJson()));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}

	/**
	 * Schedules a message.
	 * 
	 * @param apiMessage the API message to schedule.
	 * @param time date and time to send the message.
	 * @return instance of ApiMessageResponse.
	 * @throws ApiException if an error occurs.
	 */
	public ApiMessageResponse schedule(ApiMessage apiMessage, Date time) throws ApiException {
		if (apiMessage != null)
			apiMessage.setTime(time);
		return this.send(apiMessage);
	}

	/**
	 * Rescheduled a scheduled message.
	 * 
	 * @param messageId ID of the scheduled message.
	 * @param time new date and time to send the message.
	 * @return instance of ApiMessageResponse.
	 * @throws ApiException if an error occurs.
	 */
	public ApiMessageResponse reschedule(UUID messageId, Date time) throws ApiException {
		try {
			if (messageId == null)
				throw new NullPointerException("messageId");
			if (time == null)
				throw new NullPointerException("time");
			
			String uri = "/" + this.apiHost.getContextPath() + "/messages/";
			if(apiHost.getContextPath() == null || apiHost.getContextPath().length() == 0)
				uri = "/messages/";
			
			return new ApiMessageResponse(ApiHelper.getJson(this.apiHost, "PUT", uri + messageId.toString().replace("-", ""), new JsonObject().add("Time", time).toString()));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}

	/**
	 * Rescheduled a scheduled message.
	 * 
	 * @param messageId ID of the scheduled message.
	 * @param time new date and time to send the message.
	 * @return instance of ApiMessageResponse.
	 * @throws ApiException if an error occurs.
	 */
	public ApiMessageResponse reschedule(String messageId, Date time) throws ApiException {
		try {
			if (messageId == null)
				throw new NullPointerException("messageId");
			if (time == null)
				throw new NullPointerException("time");
			
			String uri = "/" + this.apiHost.getContextPath() + "/messages/";
			if(apiHost.getContextPath() == null || apiHost.getContextPath().length() == 0)
				uri = "/messages/";
			
			return new ApiMessageResponse(ApiHelper.getJson(this.apiHost, "PUT", uri + messageId, new JsonObject().add("Time", time).toString()));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}	
	
	/**
	 * Cancels a scheduled message.
	 * 
	 * @param messageId ID of the scheduled message.
	 * @return instance of ApiMessageResponse.
	 * @throws ApiException if an error occurs.
	 */
	public ApiMessageResponse cancel(UUID messageId) throws ApiException {
		try {
			if (messageId == null)
				throw new NullPointerException("messageId");
			
			String uri = "/" + this.apiHost.getContextPath() + "/messages/";
			if(apiHost.getContextPath() == null || apiHost.getContextPath().length() == 0)
				uri = "/messages/";
			
			return new ApiMessageResponse(ApiHelper.getJson(this.apiHost, "DELETE", uri + messageId.toString().replace("-", ""), null));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}

	
	/**
	 * Cancels a scheduled message.
	 * 
	 * @param messageId ID of the scheduled message.
	 * @return instance of ApiMessageResponse.
	 * @throws ApiException if an error occurs.
	 */
	public ApiMessageResponse cancel(String messageId) throws ApiException {
		try {
			if (messageId == null)
				throw new NullPointerException("messageId");
			
			String uri = "/" + this.apiHost.getContextPath() + "/messages/";
			if(apiHost.getContextPath() == null || apiHost.getContextPath().length() == 0)
				uri = "/messages/";
			
			return new ApiMessageResponse(ApiHelper.getJson(this.apiHost, "DELETE", uri + messageId, null));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}	
	/**
	 * Retrieves details of a message.
	 * 
	 * @param messageId ID of the API message.
	 * @return instance of ApiMessage representing the API message.
	 * @throws ApiException if an error occurs.
	 */
	public ApiMessage get(UUID messageId) throws ApiException {
		try {
			if (messageId == null)
				throw new NullPointerException("messageId");
			
			String uri = "/" + this.apiHost.getContextPath() + "/messages/";
			if(apiHost.getContextPath() == null || apiHost.getContextPath().length() == 0)
				uri = "/messages/";
			
			return new ApiMessage(ApiHelper.getJson(this.apiHost, "GET", uri + messageId.toString().replace("-", ""), null));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}

	/**
	 * Retrieves details of a message.
	 * 
	 * @param messageId ID of the API message.
	 * @return instance of ApiMessage representing the API message.
	 * @throws ApiException if an error occurs.
	 */
	public ApiMessage get(String messageId) throws ApiException {
		try {
			if (messageId == null || messageId.length() == 0)
				throw new NullPointerException("messageId");
			
			String uri = "/" + this.apiHost.getContextPath() + "/messages/";
			if(apiHost.getContextPath() == null || apiHost.getContextPath().length() == 0)
				uri = "/messages/";
			
			return new ApiMessage(ApiHelper.getJson(this.apiHost, "GET", uri + messageId, null));
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}
	
	/**
	 * Retrieves messages by several parameters.
	 * 
	 * @param start the date to start querying from.
	 * @param end the last possible time in the query.
	 * @param index the number of results to skip from the result set.
	 * @param limit the maximum number of results to return.
	 * @param pending indicates if only scheduled messages should be returned.
	 * @param direction an in or out value used to filter.
	 * @return API list of API messages.
	 * @throws ApiException if an error occurs.
	 */
	public ApiList<ApiMessage> get(Date start, Date end, int index, int limit, boolean pending, String direction) throws ApiException {
		boolean hasQ = false;
		StringBuilder sb = new StringBuilder();
		String uri = "/" + this.apiHost.getContextPath() + "/messages/";
		if(apiHost.getContextPath() == null || apiHost.getContextPath().length() == 0)
			uri = "/messages/";
		
		sb.append(uri);

		try {
			if (start != null) {
				sb.append("?start=").append(URLEncoder.encode(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(start), "utf-8"));
				if (!hasQ)
					hasQ = true;
			}

			if (end != null) {
				sb.append(hasQ ? "&" : "?").append("end=").append(URLEncoder.encode(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(end), "utf-8"));
				if (!hasQ)
					hasQ = true;
			}

			if (index > 0) {
				sb.append(hasQ ? "&" : "?").append("index=").append(index);
				if (!hasQ)
					hasQ = true;
			}

			if (limit > 0) {
				sb.append(hasQ ? "&" : "?").append("limit=").append(limit);
				if (!hasQ)
					hasQ = true;
			}

			if (pending) {
				sb.append(hasQ ? "&" : "?").append("pending=true");
				if (!hasQ)
					hasQ = true;
			}

			if (direction != null) {
				sb.append(hasQ ? "&" : "?").append("direction=").append(URLEncoder.encode(direction, "utf-8"));
			}

			return ApiHelper.getApiList(ApiMessage.class, this.apiHost, sb.toString(), -1, -1);
		} catch (Exception ex) {
			throw new ApiException(ex.getMessage());
		}
	}
}
