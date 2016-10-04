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
public class BrokerResponse extends BrokerErrorCode {

    private String id;
    private String customer;
    private String foreignId;
    private String providerId;


    BrokerResponse(JsonObject json) {
        super(json);
        if (null != json) {
            this.id = BrokerUtil.getJsonValue("Id", json);
            this.foreignId = BrokerUtil.getJsonValue("ForeignId",json);
            this.customer = BrokerUtil.getJsonValue("Customer",json);
            this.providerId = BrokerUtil.getJsonValue("ProviderId",json);
            
        }
    }

    public boolean isSuccessful() {
        return (!id.isEmpty() && getErrorCode().isEmpty());
    }

    /**
     * @return the Id
     */
    public String getId() {
        return id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(String Id) {
        this.id = Id;
    }

    /**
     * @return the Customer
     */
    public String getCustomer() {
        return customer;
    }

    /**
     * @param Customer the Customer to set
     */
    public void setCustomer(String Customer) {
        this.customer = Customer;
    }

    /**
     * @return the ForeignId
     */
    public String getForeignId() {
        return foreignId;
    }

    /**
     * @param ForeignId the ForeignId to set
     */
    public void setForeignId(String ForeignId) {
        this.foreignId = ForeignId;
    }

    /**
     * @return the ProviderId
     */
    public String getProviderId() {
        return providerId;
    }

    /**
     * @param ProviderId the ProviderId to set
     */
    public void setProviderId(String ProviderId) {
        this.providerId = ProviderId;
    }

   
}
