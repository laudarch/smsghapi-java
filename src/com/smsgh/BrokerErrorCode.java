/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smsgh;

/**
 *
 * @author Seth_160
 */
public class BrokerErrorCode {

    private String errorCode;
    private String description;
    private String id;

    public BrokerErrorCode(JsonObject jsonObject) {
        this.errorCode = BrokerUtil.getJsonValue("ErrorCode", jsonObject);
        this.description = BrokerUtil.getJsonValue("Description", jsonObject);
        this.id = BrokerUtil.getJsonValue("Id", jsonObject);
    }

    public boolean isSuccessful() {
        return (!id.isEmpty() && (null == errorCode || errorCode.isEmpty()));
    }

    public String getErrorMessage() {
        if (isSuccessful()) {
            return "";
        } else {
            return "["+(errorCode)+("] ")+(description);
        }
    }

    /**
     * @return the errorCode
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * @param errorCode the errorCode to set
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

}
