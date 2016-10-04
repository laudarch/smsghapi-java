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
public class AccountBasedRequest extends BrokerRequestCommon {
    
    private String account;

    public AccountBasedRequest(String account, double amount, String token, String foreignId) {
        super(amount, token, foreignId);
        this.account = account;
    }

    
    
    /**
     * @return the device
     */
    public String getDevice() {
        return account;
    }

    /**
     * @param device the device to set
     */
    public void setDevice(String device) {
        this.account = device;
    }
    
     public JsonObject getJsonObject(){
        return super.getJson()
                .add("account", account);
    }
    
}
