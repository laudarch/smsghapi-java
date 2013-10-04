// $Id: ApiAccountContact.java 0 1970-01-01 00:00:00Z mkwayisi $
package com.smsgh;
import com.smsgh.json.JsonObject;
import com.smsgh.json.JsonValue;

public class ApiAccountContact {
	/**
	 * Data fields.
	 */
	private long   accountContactId;
	private String address1;
	private String address2;
	private String city;
	private String country;
	private String firstName;
	private String lastName;
	private String province;
	private String postalCode;
	private String primaryEmail;
	private String primaryPhone;
	private String privateNote;
	private String publicNote;
	private String secondaryEmail;
	private String secondaryPhone;
	
	/**
	 * Primary constructor.
	 */
	public ApiAccountContact() {
	}
	
	/**
	 * Constructor from JSON.
	 */
	public ApiAccountContact(JsonObject json) {
		JsonValue val;
		for (String name : json.names()) {
			val = json.get(name);
			switch (name.toLowerCase()) {
				case "accountcontactid":
					this.accountContactId = val.asLong();
					break;
				case "address1":
					this.address1 = val.asString();
					break;
				case "address2":
					this.address2 = val.asString();
					break;
				case "city":
					this.city = val.asString();
					break;
				case "country":
					this.country = val.asString();
					break;
				case "firstname":
					this.firstName = val.asString();
					break;
				case "lastname":
					this.lastName = val.asString();
					break;
				case "province":
					this.province = val.asString();
					break;
				case "postalcode":
					this.postalCode = val.asString();
					break;
				case "primaryemail":
					this.primaryEmail = val.asString();
					break;
				case "primaryphone":
					this.primaryPhone = val.asString();
					break;
				case "privatenote":
					this.privateNote = val.asString();
					break;
				case "publicnote":
					this.publicNote = val.asString();
					break;
				case "secondaryemail":
					this.secondaryEmail = val.asString();
					break;
				case "secondaryphone":
					this.secondaryPhone = val.asString();
					break;
			}
		}
	}
	
	/**
	 * Gets accountContactId.
	 */
	public long getAccountContactId() {
		return this.accountContactId;
	}
	
	/**
	 * Gets address1.
	 */
	public String getAddress1() {
		return this.address1;
	}
	
	/**
	 * Gets address2.
	 */
	public String getAddress2() {
		return this.address2;
	}
	
	/**
	 * Gets city.
	 */
	public String getCity() {
		return this.city;
	}
	
	/**
	 * Gets country.
	 */
	public String getCountry() {
		return this.country;
	}
	
	/**
	 * Gets firstName.
	 */
	public String getFirstName() {
		return this.firstName;
	}
	
	/**
	 * Gets lastName.
	 */
	public String getLastName() {
		return this.lastName;
	}
	
	/**
	 * Gets province.
	 */
	public String getProvince() {
		return this.province;
	}
	
	/**
	 * Gets postalCode.
	 */
	public String getPostalCode() {
		return this.postalCode;
	}
	
	/**
	 * Gets primaryEmail.
	 */
	public String getPrimaryEmail() {
		return this.primaryEmail;
	}
	
	/**
	 * Gets primaryPhone.
	 */
	public String getPrimaryPhone() {
		return this.primaryPhone;
	}
	
	/**
	 * Gets privateNote.
	 */
	public String getPrivateNote() {
		return this.privateNote;
	}
	
	/**
	 * Gets publicNote.
	 */
	public String getPublicNote() {
		return this.publicNote;
	}
	
	/**
	 * Gets secodaryEmail.
	 */
	public String getSecondaryEmail() {
		return this.secondaryEmail;
	}
	
	/**
	 * Gets secondaryPhone.
	 */
	public String getSecondaryPhone() {
		return this.secondaryPhone;
	}
	
	/**
	 * Sets address1.
	 */
	public ApiAccountContact setAddress1(String value) {
		this.address1 = value;
		return this;
	}
	
	/**
	 * Sets address2.
	 */
	public ApiAccountContact setAddress2(String value) {
		this.address2 = value;
		return this;
	}
	
	/**
	 * Sets city.
	 */
	public ApiAccountContact setCity(String value) {
		this.city = value;
		return this;
	}
	
	/**
	 * Sets country.
	 */
	public ApiAccountContact setCountry(String value) {
		this.country = value;
		return this;
	}
	
	/**
	 * Sets firstName.
	 */
	public ApiAccountContact setFirstName(String value) {
		this.firstName = value;
		return this;
	}
	
	/**
	 * Sets lastName.
	 */
	public ApiAccountContact setLastName(String value) {
		this.lastName = value;
		return this;
	}
	
	/**
	 * Sets province.
	 */
	public ApiAccountContact setProvince(String value) {
		this.province = value;
		return this;
	}
	
	/**
	 * Sets postalCode.
	 */
	public ApiAccountContact setPostalCode(String value) {
		this.postalCode = value;
		return this;
	}
	
	/**
	 * Sets primaryEmail.
	 */
	public ApiAccountContact setPrimaryEmail(String value) {
		this.primaryEmail = value;
		return this;
	}
	
	/**
	 * Sets primaryPhone.
	 */
	public ApiAccountContact setPrimaryPhone(String value) {
		this.primaryPhone = value;
		return this;
	}
	
	/**
	 * Sets privateNote.
	 */
	public ApiAccountContact setPrivateNote(String value) {
		this.privateNote = value;
		return this;
	}
	
	/**
	 * Sets publicNote.
	 */
	public ApiAccountContact setPublicNote(String value) {
		this.publicNote = value;
		return this;
	}
	
	/**
	 * Sets secondaryEmail.
	 */
	public ApiAccountContact setSecondaryEmail(String value) {
		this.secondaryEmail = value;
		return this;
	}
	
	/**
	 * Sets secondaryPhone.
	 */
	public ApiAccountContact setSecondaryPhone(String value) {
		this.secondaryPhone = value;
		return this;
	}
	
	/**
	 * toJson.
	 */
	public String toJson() {
		return new JsonObject()
			.add("Address1", this.address1)
			.add("Address2", this.address2)
			.add("City", this.city)
			.add("Country", this.country)
			.add("FirstName", this.firstName)
			.add("LastName", this.lastName)
			.add("Province", this.province)
			.add("PostalCode", this.postalCode)
			.add("PrimaryEmail", this.primaryEmail)
			.add("PrimaryPhone", this.primaryPhone)
			.add("PrivateNote", this.privateNote)
			.add("PublicNote", this.publicNote)
			.add("SecondaryEmail", this.secondaryEmail)
			.add("SecondaryPhone", this.secondaryPhone)
			.toString();
	}
}
