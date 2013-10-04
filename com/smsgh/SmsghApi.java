// $Id: SmsghApi.java 225 2013-08-29 11:29:43Z mkwayisi $
package com.smsgh;

public class SmsghApi {
	
	/**
	 * Data fields.
	 */
	private String clientId;
	private String clientSecret;
	private String hostname;
	private int port;
	private boolean https;
	private int timeout;
	private ApiMessagesResource messagesResource;
	private ApiAccountResource accountResource;
	
	/**
	 * Primary constructor.
	 */
	public SmsghApi() {
		this.hostname = "api.smsgh.com";
		this.port = 443;
		this.https = true;
		this.timeout = 15;
		
		this.messagesResource = new ApiMessagesResource(this);
		this.accountResource = new ApiAccountResource(this);
	}
	
	/**
	 * Constructor with client id and secret.
	 */
	public SmsghApi(String clientId, String clientSecret) {
		this.clientId = clientId;
		this.clientSecret = clientSecret;
	}
	
	/**
	 * Gets clientId.
	 */
	public String getClientId() {
		return this.clientId;
	}
	
	/**
	 * Gets clientSecret.
	 */
	public String getClientSecret() {
		return this.clientSecret;
	}
	
	/**
	 * Gets hostname.
	 */
	public String getHostname() {
		return this.hostname;
	}
	
	/**
	 * Gets port.
	 */
	public int getPort() {
		return this.port;
	}
	
	/**
	 * Gets https.
	 */
	public boolean isHttps() {
		return this.https;
	}
	
	/**
	 * Gets timeout.
	 */
	public int getTimeout() {
		return this.timeout;
	}
	
	/**
	 * Sets clientId.
	 */
	public SmsghApi setClientId(String value) {
		this.clientId = value;
		return this;
	}
	
	/**
	 * Sets clientSecret.
	 */
	public SmsghApi setClientSecret(String value) {
		this.clientSecret = value;
		return this;
	}
	
	/**
	 * Sets hostname.
	 */
	public SmsghApi setHostname(String value) {
		this.hostname = value;
		return this;
	}
	
	/**
	 * Sets port
	 */
	public SmsghApi setPort(int value) {
		this.port = value;
		return this;
	}
	
	/**
	 * Sets protocol.
	 */
	public SmsghApi setHttps(boolean value) {
		this.https = value;
		return this;
	}
	
	/**
	 * Sets timeout.
	 */
	public SmsghApi setTimeout(int value) {
		this.timeout = value;
		return this;
	}
	
	/**
	 * Gets messagesResource.
	 */
	public ApiMessagesResource getMessagesResource() {
		return this.messagesResource;
	}
	
	/**
	 * Gets accountResource.
	 */
	public ApiAccountResource getAccount() {
		return this.accountResource;
	}
}
