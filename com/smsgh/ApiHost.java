// $Id: ApiHost.java 225 2013-08-29 11:29:43Z mkwayisi $
package com.smsgh;

public class ApiHost {
	
	/**
	 * Data fields.
	 */
	private String clientId;
	private String clientSecret;
	private String hostname;
	private int port;
	private String protocol;
	private int timeout;
	private ApiMessagesResource messagesResource;
	
	/**
	 * Primary constructor.
	 */
	public ApiHost() {
		this.hostname = "api.smsgh.com";
		this.port = 443;
		this.protocol = "ssl";
		this.timeout = 15;
		
		this.messagesResource = new ApiMessagesResource(this);
	}
	
	/**
	 * Constructor with client id and secret.
	 */
	public ApiHost(String clientId, String clientSecret) {
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
	 * Gets protocol.
	 */
	public String getProtocol() {
		return this.protocol;
	}
	
	/**
	 * Gets timeout.
	 */
	public int getTimeout() {
		return this.timeout;
	}
	
	/**
	 * Gets messages.
	 */
	public ApiMessagesResource getMessagesResource() {
		return this.messagesResource;
	}
	
	/**
	 * Sets clientId.
	 */
	public ApiHost setClientId(String value) {
		this.clientId = value;
		return this;
	}
	
	/**
	 * Sets clientSecret.
	 */
	public ApiHost setClientSecret(String value) {
		this.clientSecret = value;
		return this;
	}
	
	/**
	 * Sets hostname.
	 */
	public ApiHost setHostname(String value) {
		this.hostname = value;
		return this;
	}
	
	/**
	 * Sets port
	 */
	public ApiHost setPort(int value) {
		this.port = value;
		return this;
	}
	
	/**
	 * Sets protocol.
	 */
	public ApiHost setProtocol(String value) {
		this.protocol = value.toLowerCase();
		return this;
	}
	
	/**
	 * Sets timeout.
	 */
	public ApiHost setTimeout(int value) {
		this.timeout = value;
		return this;
	}
}
