// $Id: ApiAction.java 0 1970-01-01 00:00:00Z mkwayisi $
package com.smsgh;

import com.smsgh.json.JsonObject;
import com.smsgh.json.JsonValue;

/**
 * Represents an API action.
 *
 * @author Michael Kwayisi
 */
public class ApiAction {

    private String actionMeta;
    private long actionTypeId;
    private long campaignId;
    private long id;
    private boolean isActive;

    /**
     * Used internally to initialize the data fields of this class.
     */
    public ApiAction(JsonObject json) {
        JsonValue val;
        for (String name : json.names()) {
            val = json.get(name);
            switch (name.toLowerCase()) {
                case "actionmeta":
                    this.actionMeta = val.asString();
                    break;
                case "actiontypeid":
                    this.actionTypeId = val.asLong();
                    break;
                case "campaignid":
                    this.campaignId = val.asLong();
                    break;
                case "id":
                    this.id = val.asLong();
                    break;
                case "isactive":
                    this.isActive = val.asBoolean();
                    break;
            }
        }
    }

    /**
     * Gets the action meta of this API action.
     *
     * @return the action meta.
     */
    public String getActionMeta() {
        return this.actionMeta;
    }

    /**
     * Gets the action type ID of this API action.
     *
     * @return the action type ID.
     */
    public long getActionTypeId() {
        return this.actionTypeId;
    }

    /**
     * Gets the campaign ID of this API action.
     *
     * @return the campaign ID.
     */
    public long getCampaignId() {
        return this.campaignId;
    }

    /**
     * Gets the ID of this API action.
     *
     * @return the ID.
     */
    public long getId() {
        return this.id;
    }

    /**
     * Gets a boolean value indicating whether this API action is active or not.
     *
     * @return the boolean active state.
     */
    public boolean isActive() {
        return this.isActive;
    }
}
