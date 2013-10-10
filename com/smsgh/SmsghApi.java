// $Id: SmsghApi.java 0 1970-01-01 00:00:00Z mkwayisi $
package com.smsgh;

public class SmsghApi {
	
	/**
	 * Data fields.
	 */
	private String                   clientId;
	private String                   clientSecret;
	private String                   hostname;
	private int                      port;
	private boolean                  https;
	private int                      timeout;
	private ApiAccountResource       accountResource;
	private ApiContactsResource      contactsResource;
	private ApiMessagesResource      messagesResource;
	private ApiPremiumResource       premiumResource;
	private ApiBulkMessagingResource bulkMessagingResource;
	
	/**
	 * Primary constructor.
	 */
	public SmsghApi() {
		this.hostname = "api.smsgh.com";
		this.port = 443;
		this.https = true;
		this.timeout = 15;
		
		this.accountResource = new ApiAccountResource(this);
		this.messagesResource = new ApiMessagesResource(this);
		this.contactsResource = new ApiContactsResource(this);
		this.premiumResource = new ApiPremiumResource(this);
		this.bulkMessagingResource = new ApiBulkMessagingResource(this);
	}
	
	/**
	 * Constructor with client id and secret.
	 */
	public SmsghApi(String clientId, String clientSecret) {
		this.clientId = clientId;
		this.clientSecret = clientSecret;
	}
	
	/**
	 * Gets accountResource.
	 */
	public ApiAccountResource getAccount() {
		return this.accountResource;
	}
	
	/**
	 * Gets messagesResource.
	 */
	public ApiMessagesResource getMessages() {
		return this.messagesResource;
	}
	
	/**
	 * Gets contactsResource.
	 */
	public ApiContactsResource getContacts() {
		return this.contactsResource;
	}
	
	/**
	 * Gets premiumResource.
	 */
	public ApiPremiumResource getPremium() {
		return this.premiumResource;
	}
	
	/**
	 * Gets bulkMessagingResource.
	 */
	public ApiBulkMessagingResource getBulkMessaging() {
		return this.bulkMessagingResource;
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
}
