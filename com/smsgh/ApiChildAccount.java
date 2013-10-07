// $Id: ApiChildAccount.java 0 1970-01-01 00:00:00Z mkwayisi $
package com.smsgh;
import java.util.Date;
import com.smsgh.json.JsonValue;
import com.smsgh.json.JsonObject;

public class ApiChildAccount {
	/**
	 * Data fields.
	 */
	private long    accountNumber;
	private double  balance;
	private boolean canImpersonate;
	private String  child;
	private double  credit;
	private long    id;
	private String  parent;
	private String  productId;
	private String  productName;
	private int     status;
	private Date    timeCreated;
	private Date    timeRemoved;
	
	/**
	 * Constructor from JSON.
	 */
	public ApiChildAccount(JsonObject json) {
		JsonValue val;
		for (String name : json.names()) {
			val = json.get(name);
			switch (name.toLowerCase()) {
				case "accountnumber":
					this.accountNumber = val.asLong();
					break;
				case "balance":
					this.balance = val.asDouble();
					break;
				case "canimpersonate":
					this.canImpersonate = val.asBoolean();
					break;
				case "child":
					this.child = val.asString();
					break;
				case "credit":
					this.credit = val.asDouble();
					break;
				case "id":
					this.id = val.asLong();
					break;
				case "parent":
					this.parent = val.asString();
					break;
				case "productid":
					this.productId = val.asString();
					break;
				case "productname":
					this.productName = val.asString();
					break;
				case "status":
					this.status = val.asInt();
					break;
				case "timecreated":
					this.timeCreated = val.asDate();
					break;
				case "timeremoved":
					this.timeRemoved = val.asDate();
					break;
			}
		}
	}
	
	/**
	 * Gets accountNumber.
	 */
	public long getAccountNumber() {
		return this.accountNumber;
	}
	
	/**
	 * Gets balance.
	 */
	public double getBalance() {
		return this.balance;
	}
	
	/**
	 * Gets canImpersonate.
	 */
	public boolean canImpersonate() {
		return this.canImpersonate;
	}
	
	/**
	 * Gets child.
	 */
	public String getChild() {
		return this.child;
	}
	
	/**
	 * Gets credit.
	 */
	public double getCredit() {
		return this.credit;
	}
	
	/**
	 * Gets id.
	 */
	public long getId() {
		return this.id;
	}
	
	/**
	 * Gets parent.
	 */
	public String getParent() {
		return this.parent;
	}
	
	/**
	 * Gets productId.
	 */
	public String getProductId() {
		return this.productId;
	}
	
	/**
	 * Gets productName.
	 */
	public String getProductName() {
		return this.productName;
	}
	
	/**
	 * Gets status.
	 */
	public int getStatus() {
		return this.status;
	}
	
	/**
	 * Gets timeCreated.
	 */
	public Date getTimeCreated() {
		return this.timeCreated;
	}
	
	/**
	 * Gets timeRemoved.
	 */
	public Date getTimeRemoved() {
		return this.timeRemoved;
	}
}
