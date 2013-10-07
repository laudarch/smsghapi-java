// $Id: ApiNumberPlan.java 0 1970-01-01 00:00:00Z mkwayisi $
package com.smsgh;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import com.smsgh.json.JsonValue;
import com.smsgh.json.JsonObject;

public class ApiNumberPlan {
	/**
	 * Data fields.
	 */
	private String                  accountId;
	private Date                    dateActivated;
	private Date                    dateCreated;
	private Date                    dateDeactivated;
	private Date                    dateExpiring;
	private String                  description;
	private long                    id;
	private double                  initialCost;
	private boolean                 isActive;
	private boolean                 isPremium;
	private int                     maxAllowedKeywords;
	private List<ApiMoKeyword>      moKeywords;
	private String                  notes;
	private List<ApiNumberPlanItem> numberPlanItems;
	private double                  periodicCostBasis;
	private ApiServiceType          serviceType;
	
	/**
	 * Constructor from JSON.
	 */
	public ApiNumberPlan(JsonObject json) {
		JsonValue val;
		this.moKeywords = new ArrayList<ApiMoKeyword>();
		this.numberPlanItems = new ArrayList<ApiNumberPlanItem>();
		for (String name : json.names()) {
			val = json.get(name);
			switch (name.toLowerCase()) {
				case "accountid":
					this.accountId = val.asString();
					break;
				case "dateactivated":
					this.dateActivated = val.asDate();
					break;
				case "datecreated":
					this.dateCreated = val.asDate();
					break;
				case "datedeactivated":
					this.dateDeactivated = val.asDate();
					break;
				case "dateexpiring":
					this.dateExpiring = val.asDate();
					break;
				case "description":
					this.description = val.asString();
					break;
				case "id":
					this.id = val.asLong();
					break;
				case "initialcost":
					this.initialCost = val.asDouble();
					break;
				case "isactive":
					this.isActive = val.asBoolean();
					break;
				case "ispremium":
					this.isPremium = val.asBoolean();
					break;
				case "maxallowedkeywords":
					this.maxAllowedKeywords = val.asInt();
					break;
				case "mokeywords":
					for (JsonValue o : val.asArray())
						this.moKeywords.add(new ApiMoKeyword(o.asObject()));
					break;
				case "notes":
					this.notes = val.asString();
					break;
				case "numberplanitems":
					for (JsonValue o : val.asArray())
						this.numberPlanItems
							.add(new ApiNumberPlanItem(o.asObject()));
					break;
				case "periodiccostbasis":
					this.periodicCostBasis = val.asDouble();
					break;
				case "servicetype":
					this.serviceType = new ApiServiceType(val.asObject());
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
	 * Gets dateActivated.
	 */
	public Date getDateActivated() {
		return this.dateActivated;
	}
	
	/**
	 * Gets dateCreated.
	 */
	public Date getDateCreated() {
		return this.dateCreated;
	}
	
	/**
	 * Gets dateDeactivated.
	 */
	public Date getDateDeactivated() {
		return this.dateDeactivated;
	}
	
	/**
	 * Gets dateExpiring.
	 */
	public Date getDateExpiring() {
		return this.dateExpiring;
	}
	
	/**
	 * Gets description.
	 */
	public String getDescription() {
		return this.description;
	}
	
	/**
	 * Gets id.
	 */
	public long getId() {
		return this.id;
	}
	
	/**
	 * Gets initialCost.
	 */
	public double getInitialCost() {
		return this.initialCost;
	}
	
	/**
	 * Gets isActive.
	 */
	public boolean isActive() {
		return this.isActive;
	}
	
	/**
	 * Gets isPremium.
	 */
	public boolean isPremium() {
		return this.isPremium;
	}
	
	/**
	 * Gets maxAllowedKeywords.
	 */
	public int getMaxAllowedKeywords() {
		return this.maxAllowedKeywords;
	}
	
	/**
	 * Gets moKeywords.
	 */
	public List<ApiMoKeyword> getMoKeywords() {
		return this.moKeywords;
	}
	
	/**
	 * Gets notes.
	 */
	public String getNotes() {
		return this.notes;
	}
	
	/**
	 * Gets numberPlanItems.
	 */
	public List<ApiNumberPlanItem> getNumberPlanItems() {
		return this.numberPlanItems;
	}
	
	/**
	 * Gets periodicCostBasis.
	 */
	public double getPeriodicCostBasis() {
		return this.periodicCostBasis;
	}
	
	/**
	 * Gets serviceType.
	 */
	public ApiServiceType getServiceType() {
		return this.serviceType;
	}
}
