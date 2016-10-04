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
public class BrokerEcgRequest extends AccountBasedRequest {

    private String name;
    private String serviceType;
    public BrokerEcgRequest(String account, double amount,String name,String serviceType, String token, String foreignId) {
        super(account, amount, token, foreignId);
        this.name = name;
        this.serviceType = serviceType;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the serviceType
     */
    public String getServiceType() {
        return serviceType;
    }

    /**
     * @param serviceType the serviceType to set
     */
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
    
    
    public JsonObject getJsonObject(){
        return super.getJson()
                .add("name", name)
                .add("serviceType", serviceType);
    }
    
}
