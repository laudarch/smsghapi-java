// $Id: ApiList.java 0 1970-01-01 00:00:00Z mkwayisi $
package com.smsgh;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import com.smsgh.json.JsonObject;
import com.smsgh.json.JsonValue;

public class ApiList<T> implements Iterable<T> {
	/**
	 * Data fields.
	 */
	private long count;
	private long totalPages;
	private List<T> items;
	
	/**
	 * Primary constructor.
	 */
	@SuppressWarnings("unchecked")
	public ApiList(JsonObject json) {
		this.items = new ArrayList<T>();
		JsonValue val;
		for (String name : json.names()) {
			val = json.get(name);
			switch (name.toLowerCase()) {
				case "count":
					this.count = val.asLong();
					break;
				case "totalpages":
					this.totalPages = val.asLong();
					break;
					
				case "actionlist":
					for (JsonValue o : val.asArray())
						this.items.add((T) new ApiAction(o.asObject()));
					break;
					
				case "campaignlist":
					for (JsonValue o : val.asArray())
						this.items.add((T) new ApiCampaign(o.asObject()));
					break;
					
				case "childaccountlist":
					for (JsonValue o : val.asArray())
						this.items.add((T) new ApiChildAccount(o.asObject()));
					break;
					
				case "contactlist":
					for (JsonValue o : val.asArray())
						this.items.add((T) new ApiContact(o.asObject()));
					break;
					
				case "grouplist":
					for (JsonValue o : val.asArray())
						this.items.add((T) new ApiContactGroup(o.asObject()));
					break;
					
				case "invoicestatementlist":
					for (JsonValue o : val.asArray())
						this.items.add((T) new ApiInvoice(o.asObject()));
					break;
					
				case "messagetemplatelist":
					for (JsonValue o : val.asArray())
						this.items.add((T) new ApiTemplate(o.asObject()));
					break;
					
				case "mokeywordlist":
					for (JsonValue o : val.asArray())
						this.items.add((T) new ApiMoKeyword(o.asObject()));
					break;
					
				case "numberplanlist":
					for (JsonValue o : val.asArray())
						this.items.add((T) new ApiNumberPlan(o.asObject()));
					break;
					
				case "senderaddresseslist":
					for (JsonValue o : val.asArray())
						this.items.add((T) new ApiSender(o.asObject()));
					break;
					
				case "servicelist":
					for (JsonValue o : val.asArray())
						this.items.add((T) new ApiService(o.asObject()));
					break;
			}
		}
	}
	
	/**
	 * Gets count.
	 */
	public long getCount() {
		return this.count;
	}
	
	/**
	 * Gets totalPages.
	 */
	public long getTotalPages() {
		return this.totalPages;
	}
	
	/**
	 * Gets items.
	 */
	public List<T> getItems() {
		return this.items;
	}
	
	/**
	 * iterator
	 */
	public Iterator<T> iterator() {
		return items.iterator();
	}
}
