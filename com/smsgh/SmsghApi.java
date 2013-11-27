// $Id: SmsghApi.java 0 1970-01-01 00:00:00Z mkwayisi $
package com.smsgh;

/**
 * Represents an SMSGH API host.
 * 
 * @author Michael Kwayisi
 */
public class SmsghApi {
	private String clientId;
	private String clientSecret;
	private String hostname;
	private int port;
	private boolean https;
	private int timeout;
	private ApiAccountResource accountResource;
	private ApiContactsResource contactsResource;
	private ApiMessagesResource messagesResource;
	private ApiPremiumResource premiumResource;
	private ApiBulkMessagingResource bulkMessagingResource;
	private String version;

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
		this.setVersion(null);
	}

	/**
	 * Constructor from a client ID and client secret.
	 * 
	 * @param clientId API client ID.
	 * @param clientSecret API client secret.
	 */
	public SmsghApi(String clientId, String clientSecret) {
		this();
		this.clientId = clientId;
		this.clientSecret = clientSecret;
	}

	/**
	 * Gets the API account resource of this SMSGH API host.
	 * 
	 * @return instance of the ApiAccountResource class.
	 */
	public ApiAccountResource getAccount() {
		return this.accountResource;
	}

	/**
	 * Gets the API messages resource of this SMSGH API host.
	 * 
	 * @return instance of the ApiMessagesResource class.
	 */
	public ApiMessagesResource getMessages() {
		return this.messagesResource;
	}

	/**
	 * Gets the API contacts resource of this SMSGH API host.
	 * 
	 * @return instance of the ApiContactsResource class.
	 */
	public ApiContactsResource getContacts() {
		return this.contactsResource;
	}

	/**
	 * Gets the API premium resource of this SMSGH API host.
	 * 
	 * @return instance of the ApiPremiumResource class.
	 */
	public ApiPremiumResource getPremium() {
		return this.premiumResource;
	}

	/**
	 * Gets the API bulk messaging resource of this SMSGH API host.
	 * 
	 * @return instance of the ApiBulkMessagingResource class.
	 */
	public ApiBulkMessagingResource getBulkMessaging() {
		return this.bulkMessagingResource;
	}

	/**
	 * Gets the API client ID of this SMSGH API host.
	 * 
	 * @return the API client ID or null if not set.
	 */
	public String getClientId() {
		return this.clientId;
	}

	/**
	 * Gets the API client secret of this SMSGH API host.
	 * 
	 * @return the API client secret or null if not set.
	 */
	public String getClientSecret() {
		return this.clientSecret;
	}

	/**
	 * Gets the hostname of this SMSGH API host.
	 * 
	 * @return the hostname or null if not set.
	 */
	public String getHostname() {
		return this.hostname;
	}

	/**
	 * Gets the port of this SMSGH API host.
	 * 
	 * @return the port or 0 if not set.
	 */
	public int getPort() {
		return this.port;
	}

	/**
	 * Gets a value indicating whether this SMSGH API host uses SSL when making
	 * connections to the remote host or not.
	 * 
	 * @return boolean true if SSL is used otherwise false.
	 */
	public boolean isHttps() {
		return this.https;
	}

	/**
	 * Gets the network I/O timeout, in seconds, of this SMSGH API host.
	 * 
	 * @return the timeout value or 0 if not set.
	 */
	public int getTimeout() {
		return this.timeout;
	}

	/**
	 * Sets the client ID for this SMSGH API host.
	 * 
	 * @param value API client ID.
	 * @return this instance of the SMSGH API host.
	 */
	public SmsghApi setClientId(String value) {
		this.clientId = value;
		return this;
	}

	/**
	 * Sets the client secret for this SMSGH API host.
	 * 
	 * @param value API client secret.
	 * @return this instance of the SMSGH API host.
	 */
	public SmsghApi setClientSecret(String value) {
		this.clientSecret = value;
		return this;
	}

	/**
	 * Sets the hostname for this SMSGH API host.
	 * 
	 * @param value hostname.
	 * @return this instance of the SMSGH API host.
	 */
	public SmsghApi setHostname(String value) {
		this.hostname = value;
		return this;
	}

	/**
	 * Sets the port number to connect to on the remote host for this SMSGH API
	 * host.
	 * 
	 * @param value port number.
	 * @return this instance of the SMSGH API host.
	 */
	public SmsghApi setPort(int value) {
		this.port = value;
		return this;
	}

	/**
	 * Sets a value indicating whether SSL should be used in connecting to the
	 * remote host or otherwise (plain TCP).
	 * 
	 * @param value SSL connection?
	 * @return this instance of the SMSGH API host.
	 */
	public SmsghApi setHttps(boolean value) {
		this.https = value;
		return this;
	}

	/**
	 * Sets the network I/O timeout value, in seconds, to be used for
	 * connection.
	 * 
	 * @param value timeout in seconds.
	 * @return this instance of the SMSGH API host.
	 */
	public SmsghApi setTimeout(int value) {
		this.timeout = value;
		return this;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String apiVersion) {
		this.version = apiVersion;
	}
}
