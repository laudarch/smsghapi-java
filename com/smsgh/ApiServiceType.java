// $Id: ApiServiceType.java 0 1970-01-01 00:00:00Z mkwayisi $
package com.smsgh;
import com.smsgh.json.JsonValue;
import com.smsgh.json.JsonObject;

public class ApiServiceType {
	/**
	 * Data fields.
	 */
	private String  descriptor;
	private boolean isCreditBased;
	private boolean isPrepaid;
	private String  name;
	private double  rate;
	private boolean requiresActivation;
	
	/**
	 * Constructor from JSON.
	 */
	public ApiServiceType(JsonObject json) {
		JsonValue val;
		for (String name : json.names()) {
			val = json.get(name);
			switch (name.toLowerCase()) {
				case "descriptor":
					this.descriptor = val.asString();
					break;
				case "iscreditbased":
					this.isCreditBased = val.asBoolean();
					break;
				case "isprepaid":
					this.isPrepaid = val.asBoolean();
					break;
				case "name":
					this.name = val.asString();
					break;
				case "rate":
					this.rate = val.asDouble();
					break;
				case "requiresactivation":
					this.requiresActivation = val.asBoolean();
					break;
			}
		}
	}
	
	/**
	 * Gets descriptor.
	 */
	public String getDescriptor() {
		return this.descriptor;
	}
	
	/**
	 * Gets isCreditBased.
	 */
	public boolean isCreditBased() {
		return this.isCreditBased;
	}
	
	/**
	 * Gets isPrepaid.
	 */
	public boolean isPrepaid() {
		return this.isPrepaid;
	}
	
	/**
	 * Gets name.
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Gets rate.
	 */
	public double getRate() {
		return this.rate;
	}
	
	/**
	 * Gets requiresActivation.
	 */
	public boolean getRequiresActivation() {
		return this.requiresActivation;
	}
}
