// $Id: ApiContact.java 0 1970-01-01 00:00:00Z mkwayisi $
package com.smsgh;
import com.smsgh.json.JsonValue;
import com.smsgh.json.JsonObject;

public class ApiContact {
	/**
	 * Data fields.
	 */
	private long   contactId;
	private String custom1;
	private String custom2;
	private String custom3;
	private String firstName;
	private long   groupId;
	private String groupName;
	private String mobileNumber;
	private String owner;
	private String surname;
	private String title;
	
	/**
	 * Primary constructor.
	 */
	public ApiContact() {
	}
	
	/**
	 * Constructor from JSON.
	 */
	public ApiContact(JsonObject json) {
		JsonValue val;
		for (String name : json.names()) {
			val = json.get(name);
			switch (name.toLowerCase()) {
				case "contactid":
					this.contactId = val.asLong();
					break;
				case "custom1":
					this.custom1 = val.asString();
					break;
				case "custom2":
					this.custom2 = val.asString();
					break;
				case "custom3":
					this.custom3 = val.asString();
					break;
				case "firstname":
					this.firstName = val.asString();
					break;
				case "groupid":
					this.groupId = val.asLong();
					break;
				case "groupname":
					this.groupName = val.asString();
					break;
				case "mobilenumber":
					this.mobileNumber = val.asString();
					break;
				case "owner":
					this.owner = val.asString();
					break;
				case "surname":
					this.surname = val.asString();
					break;
				case "title":
					this.title = val.asString();
					break;
			}
		}
	}
	
	/**
	 * Gets contactId.
	 */
	public long getContactId() {
		return this.contactId;
	}
	
	/**
	 * Gets custom1.
	 */
	public String getCustom1() {
		return this.custom1;
	}
	
	/**
	 * Gets custom2.
	 */
	public String getCustom2() {
		return this.custom2;
	}
	
	/**
	 * Gets custom3.
	 */
	public String getCustom3() {
		return this.custom3;
	}
	
	/**
	 * Gets firstName.
	 */
	public String getFirstName() {
		return this.firstName;
	}
	
	/**
	 * Gets groupId.
	 */
	public long getGroupId() {
		return this.groupId;
	}
	
	/**
	 * Gets groupName.
	 */
	public String getGroupName() {
		return this.groupName;
	}
	
	/**
	 * Gets mobileNumber.
	 */
	public String getMobileNumber() {
		return this.mobileNumber;
	}
	
	/**
	 * Gets owner.
	 */
	public String getOwner() {
		return this.owner;
	}
	
	/**
	 * Gets surname.
	 */
	public String getSurname() {
		return this.surname;
	}
	
	/**
	 * Gets title.
	 */
	public String getTitle() {
		return this.title;
	}
	
	/**
	 * Sets custom1.
	 */
	public ApiContact setCustom1(String value) {
		this.custom1 = value;
		return this;
	}
	
	/**
	 * Sets custom2.
	 */
	public ApiContact setCustom2(String value) {
		this.custom2 = value;
		return this;
	}
	
	/**
	 * Sets custom3.
	 */
	public ApiContact setCustom3(String value) {
		this.custom3 = value;
		return this;
	}
	
	/**
	 * Sets firstName.
	 */
	public ApiContact setFirstName(String value) {
		this.firstName = value;
		return this;
	}
	
	/**
	 * Sets groupId.
	 */
	public ApiContact setGroupId(long value) {
		this.groupId = value;
		return this;
	}
	
	/**
	 * Sets mobileNumber.
	 */
	public ApiContact setMobileNumber(String value) {
		this.mobileNumber = value;
		return this;
	}
	
	/**
	 * Sets surname.
	 */
	public ApiContact setSurname(String value) {
		this.surname = value;
		return this;
	}
	
	/**
	 * Sets title.
	 */
	public ApiContact setTitle(String value) {
		this.title = value;
		return this;
	}
	
	/**
	 * toJson.
	 */
	public String toJson() {
		return new JsonObject()
			.add("Custom1", this.custom1)
			.add("Custom2", this.custom2)
			.add("Custom3", this.custom3)
			.add("FirstName", this.firstName)
			.add("GroupId", this.groupId)
			.add("MobileNumber", this.mobileNumber)
			.add("Surname", this.surname)
			.add("Title", this.title)
			.toString();
	}
}
