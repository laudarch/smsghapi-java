// $Id: ApiService.java 0 1970-01-01 00:00:00Z mkwayisi $
package com.smsgh;
import java.util.Date;
import com.smsgh.json.JsonValue;
import com.smsgh.json.JsonObject;

public class ApiService {
	/**
	 * Data fields.
	 */
	private String  accountId;
	private Date    billDate;
	private long    billingCycleId;
	private Date    dateCreated;
	private String  description;
	private boolean isCreditBased;
	private boolean isPrepaid;
	private double  rate;
	private long    serviceId;
	private long    serviceStatusTypeId;
	private long    serviceTypeId;
	
	/**
	 * Primary constructor.
	 */
	public ApiService(JsonObject json) {
		JsonValue val;
		for (String name : json.names()) {
			val = json.get(name);
			switch (name.toLowerCase()) {
				case "accountid":
					this.accountId = val.asString();
					break;
				case "billdate":
					this.billDate = val.asDate();
					break;
				case "billingcycleid":
					this.billingCycleId = val.asLong();
					break;
				case "datecreated":
					this.dateCreated = val.asDate();
					break;
				case "description":
					this.description = val.asString();
					break;
				case "iscreditbased":
					this.isCreditBased = val.asBoolean();
					break;
				case "isprepaid":
					this.isPrepaid = val.asBoolean();
					break;
				case "rate":
					this.rate = val.asDouble();
					break;
				case "serviceid":
					this.serviceId = val.asLong();
					break;
				case "servicestatustypeid":
					this.serviceStatusTypeId = val.asLong();
					break;
				case "servicetypeid":
					this.serviceTypeId = val.asLong();
					break;
			}
		}
	}
	
	/**
	 * Gets accountId.
	 */
	public String getAccountId() {
		return this.accountId;
	}
	
	/**
	 * Gets billDate.
	 */
	public Date getBillDate() {
		return this.billDate;
	}
	
	/**
	 * Gets billingCycleId.
	 */
	public long getBillingCycleId() {
		return this.billingCycleId;
	}
	
	/**
	 * Gets dateCreated.
	 */
	public Date getDateCreated() {
		return this.dateCreated;
	}
	
	/**
	 * Gets description.
	 */
	public String getDescription() {
		return this.description;
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
	 * Gets rate.
	 */
	public double getRate() {
		return this.rate;
	}
	
	/**
	 * Gets serviceId.
	 */
	public long getServiceId() {
		return this.serviceId;
	}
	
	/**
	 * Gets serviceStatusTypeId.
	 */
	public long getServiceStatusTypeId() {
		return this.serviceStatusTypeId;
	}
	
	/**
	 * Gets serviceTypeId.
	 */
	public long getServiceTypeId() {
		return this.serviceTypeId;
	}
}
