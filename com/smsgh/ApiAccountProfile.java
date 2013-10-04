// $Id: ApiAccountProfile.java 0 1970-01-01 00:00:00Z mkwayisi $
package com.smsgh;
import java.util.Date;
import java.text.SimpleDateFormat;
import com.smsgh.json.JsonObject;
import com.smsgh.json.JsonValue;

public class ApiAccountProfile {
	/**
	 * Data fields.
	 */
	private String accountId;
	private String accountManager;
	private long   accountNumber;
	private String accountStatus;
	private double balance;
	private String company;
	private double credit;
	private String emailAddress;
	private Date   lastAccessed;
	private String mobileNumber;
	private int    numberOfServices;
	private String primaryContact;
	private double unpostedBalance;
	
	/**
	 * Constructor from JSON.
	 */
	public ApiAccountProfile(JsonObject json)
	{
		for (String name : json.names()) {
			JsonValue val = json.get(name);
			switch (name.toLowerCase()) {
				case "accountid":
					this.accountId = val.asString();
					break;
				case "accountmanager":
					this.accountManager = val.asString();
					break;
				case "accountnumber":
					this.accountNumber = val.asLong();
					break;
				case "accountstatus":
					this.accountStatus = val.asString();
					break;
				case "balance":
					this.balance = val.asDouble();
					break;
				case "company":
					this.company = val.asString();
					break;
				case "credit":
					this.credit = val.asDouble();
					break;
				case "emailaddress":
					this.emailAddress = val.asString();
					break;
				case "lastaccessed":
					this.lastAccessed = val.asDate();
					break;
				case "mobilenumber":
					this.mobileNumber = val.asString();
					break;
				case "numberofservices":
					this.numberOfServices = val.asInt();
					break;
				case "primarycontact":
					this.primaryContact = val.asString();
					break;
				case "unpostedbalance":
					this.unpostedBalance = val.asDouble();
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
	 * Gets accountManager.
	 */
	public String getAccountManager() {
		return this.accountManager;
	}
	
	/**
	 * Gets accountNumber.
	 */
	public long getAccountNumber() {
		return this.accountNumber;
	}
	
	/**
	 * Gets accountStatus.
	 */
	public String getAccountStatus() {
		return this.accountStatus;
	}
	
	/**
	 * Gets balance.
	 */
	public double getBalance() {
		return this.balance;
	}
	
	/**
	 * Gets company.
	 */
	public String getCompany() {
		return this.company;
	}
	
	/**
	 * Gets credit.
	 */
	public double getCredit() {
		return this.credit;
	}
	
	/**
	 * Gets emailAddress.
	 */
	public String getEmailAddress() {
		return this.emailAddress;
	}
	
	/**
	 * Gets lastAccessed.
	 */
	public Date getLastAccessed() {
		return this.lastAccessed;
	}
	
	/**
	 * Gets mobileNumber.
	 */
	public String getMobileNumber() {
		return this.mobileNumber;
	}
	
	/**
	 * Gets numberOfServices.
	 */
	public int getNumberOfServices() {
		return this.numberOfServices;
	}
	
	/**
	 * Gets primaryContact.
	 */
	public String getPrimaryContact() {
		return this.primaryContact;
	}
	
	/**
	 * Gets unpostedBalance.
	 */
	public double getUnpostedBalance() {
		return this.unpostedBalance;
	}
}
