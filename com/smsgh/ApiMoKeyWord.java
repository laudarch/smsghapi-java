// $Id: ApiMoKeyWord.java 0 1970-01-01 00:00:00Z mkwayisi $
package com.smsgh;
import com.smsgh.json.JsonValue;
import com.smsgh.json.JsonObject;

public class ApiMoKeyWord {
	/**
	 * Data fields.
	 */
	private String  alias1;
	private String  alias2;
	private String  alias3;
	private String  alias4;
	private String  alias5;
	private long    id;
	private boolean isActive;
	private boolean isDefault;
	private String  keyword;
	private long    numberPlanId;
	
	/**
	 * Primary constructor.
	 */
	public ApiMoKeyWord() {
	}
	
	/**
	 * Constructor from JSON.
	 */
	public ApiMoKeyWord(JsonObject json) {
		JsonValue val;
		for (String name : json.names()) {
			val = json.get(name);
			switch (name.toLowerCase()) {
				case "alias1":
					this.alias1 = val.asString();
					break;
				case "alias2":
					this.alias2 = val.asString();
					break;
				case "alias3":
					this.alias3 = val.asString();
					break;
				case "alias4":
					this.alias4 = val.asString();
					break;
				case "alias5":
					this.alias5 = val.asString();
					break;
				case "id":
					this.id = val.asLong();
					break;
				case "isactive":
					this.isActive = val.asBoolean();
					break;
				case "isdefault":
					this.isDefault = val.asBoolean();
					break;
				case "keyword":
					this.keyword = val.asString();
					break;
				case "numberplanid":
					this.numberPlanId = val.asLong();
					break;
			}
		}
	}
	
	/**
	 * Gets alias1.
	 */
	public String getAlias1() {
		return this.alias1;
	}
	
	/**
	 * Gets alias2.
	 */
	public String getAlias2() {
		return this.alias2;
	}
	
	/**
	 * Gets alias3.
	 */
	public String getAlias3() {
		return this.alias3;
	}
	
	/**
	 * Gets alias4.
	 */
	public String getAlias4() {
		return this.alias4;
	}
	
	/**
	 * Gets alias5.
	 */
	public String getAlias5() {
		return this.alias5;
	}
	
	/**
	 * Gets id.
	 */
	public long getId() {
		return this.id;
	}
	
	/**
	 * Gets isActive.
	 */
	public boolean isActive() {
		return this.isActive;
	}
	
	/**
	 * Gets isDefault.
	 */
	public boolean isDefault() {
		return this.isDefault;
	}
	
	/**
	 * Gets keyword.
	 */
	public String getKeyword() {
		return this.keyword;
	}
	
	/**
	 * Gets numberPlanId.
	 */
	public long getNumberPlanId() {
		return this.numberPlanId;
	}
	
	/**
	 * Sets alias1.
	 */
	public ApiMoKeyWord setAlias1(String value) {
		this.alias1 = value;
		return this;
	}
	
	/**
	 * Sets alias2.
	 */
	public ApiMoKeyWord setAlias2(String value) {
		this.alias2 = value;
		return this;
	}
	
	/**
	 * Sets alias3.
	 */
	public ApiMoKeyWord setAlias3(String value) {
		this.alias3 = value;
		return this;
	}
	
	/**
	 * Sets alias4.
	 */
	public ApiMoKeyWord setAlias4(String value) {
		this.alias4 = value;
		return this;
	}
	
	/**
	 * Sets alias5.
	 */
	public ApiMoKeyWord setAlias5(String value) {
		this.alias5 = value;
		return this;
	}
	
	/**
	 * Sets isActive.
	 */
	public ApiMoKeyWord setActive(boolean value) {
		this.isActive = value;
		return this;
	}
	
	/**
	 * Sets isDefault.
	 */
	public ApiMoKeyWord setDefault(boolean value) {
		this.isDefault = value;
		return this;
	}
	
	/**
	 * Sets keyword.
	 */
	public ApiMoKeyWord setKeyword(String value) {
		this.keyword = value;
		return this;
	}
	
	/**
	 * Sets numberPlanId.
	 */
	public ApiMoKeyWord setNumberPlanId(long value) {
		this.numberPlanId = value;
		return this;
	}
	
	/**
	 * toJson.
	 */
	public String toJson() {
		return new JsonObject()
			.add("Alias1", this.alias1)
			.add("Alias2", this.alias2)
			.add("Alias3", this.alias3)
			.add("Alias4", this.alias4)
			.add("Alias5", this.alias5)
			.add("IsActive", this.isActive)
			.add("IsDefault", this.isDefault)
			.add("Keyword", this.keyword)
			.add("NumberPlanId", this.numberPlanId)
			.toString();
	}
}
