// $Id: ApiChildAccount.java 0 1970-01-01 00:00:00Z mkwayisi $
package com.smsgh;
import java.util.Date;
import com.smsgh.json.JsonValue;
import com.smsgh.json.JsonObject;

/**
 * Represents an API child account.
 *
 * @author Michael Kwayisi
 */
public class ApiChildAccount {
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
	 * Used internally to initialize the data fields of this instance.
	 *
	 * @param json  gauranteed instance of com.smsgh.json.JsonObject.
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
	 * Gets the account number of this API child account.
	 *
	 * @return the account number.
	 */
	public long getAccountNumber() {
		return this.accountNumber;
	}
	
	/**
	 * Gets the balance of this API child account.
	 *
	 * @return the balance.
	 */
	public double getBalance() {
		return this.balance;
	}
	
	/**
	 * Indicates whether this child account can be impersonated.
	 *
	 * @return the boolean state impersonation.
	 */
	public boolean canImpersonate() {
		return this.canImpersonate;
	}
	
	/**
	 * Gets the child of this API child account.
	 *
	 * @return the child.
	 */
	public String getChild() {
		return this.child;
	}
	
	/**
	 * Gets the credit on this API child account.
	 *
	 * @return the credit.
	 */
	public double getCredit() {
		return this.credit;
	}
	
	/**
	 * Gets the ID of this API child account.
	 *
	 * @return the ID.
	 */
	public long getId() {
		return this.id;
	}
	
	/**
	 * Gets the parent of this API child account.
	 *
	 * @return the parent.
	 */
	public String getParent() {
		return this.parent;
	}
	
	/**
	 * Gets the product ID of this API child account.
	 *
	 * @return the product ID.
	 */
	public String getProductId() {
		return this.productId;
	}
	
	/**
	 * Gets the product name of this API child account.
	 *
	 * @return the product name.
	 */
	public String getProductName() {
		return this.productName;
	}
	
	/**
	 * Gets the status of this API child account.
	 *
	 * @return the status.
	 */
	public int getStatus() {
		return this.status;
	}
	
	/**
	 * Gets the created time of this API child account.
	 *
	 * @return the created time.
	 */
	public Date getTimeCreated() {
		return this.timeCreated;
	}
	
	/**
	 * Gets the removed time of this API child account.
	 *
	 * @return the removed time.
	 */
	public Date getTimeRemoved() {
		return this.timeRemoved;
	}
}
