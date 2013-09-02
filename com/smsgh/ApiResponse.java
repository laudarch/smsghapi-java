// $Id: ApiResponse.java 222 2013-08-27 10:07:18Z mkwayisi $
package com.smsgh;
import java.util.ArrayList;
import java.util.AbstractMap;

public class ApiResponse {
	
	// Data fields.
	private int status;
	private String reason;
	private ArrayList<AbstractMap.SimpleEntry> headers;
	private String body;
	private boolean locked;
	
	// Primary constructor.
	public ApiResponse() {
		this.headers = new ArrayList<AbstractMap.SimpleEntry>();
	}
	
	// Gets status.
	public int getStatus() {
		return this.status;
	}
	
	// Gets reason.
	public String getReason() {
		return this.reason;
	}
	
	// Gets header.
	public String getHeader(String name) {
		if (name == null)
			throw new NullPointerException();
			
		name = name.toLowerCase();
		
		for (AbstractMap.SimpleEntry entry : this.headers)
			if (entry.getKey().equals(name))
				return (String) entry.getValue();
			
		return null;
	}
	
	// Gets body.
	public String getBody() {
		return this.body;
	}
	
	// Sets status.
	public ApiResponse setStatus(int value)
		throws ApiException {
		if (this.locked) {
			throw new ApiException(
				"Object's properties cannot be modified");
		}
		this.status = value;
		return this;
	}
	
	// Sets reason.
	public ApiResponse setReason(String value)
		throws ApiException {
		if (this.locked) {
			throw new ApiException(
				"Object's properties cannot be modified");
		}
		this.reason = value;
		return this;
	}
	
	/**
	 * Sets header.
	 */
	@SuppressWarnings("unchecked")
	public ApiResponse setHeader(String name, String value)
		throws ApiException {
		if (this.locked) {
			throw new ApiException(
				"Object's properties cannot be modified");
		}
		this.headers.add(
			new AbstractMap.SimpleEntry(name.toLowerCase(), value));
		return this;
	}
	
	// Sets body.
	public ApiResponse setBody(String value)
		throws ApiException {
		if (this.locked) {
			throw new ApiException(
				"Object's properties cannot be modified");
		}
		this.body = value;
		this.locked = true;
		return this;
	}
}
