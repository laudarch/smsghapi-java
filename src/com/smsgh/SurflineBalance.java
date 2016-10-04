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
public class SurflineBalance {
    private String balanceType;
    private String value;
    private String expiry;

    public SurflineBalance(String balanceType, String value, String expiry) {
        this.balanceType = balanceType;
        this.value = value;
        this.expiry = expiry;
    }

    public SurflineBalance(JsonObject jsonObject) {
        this.balanceType = jsonObject.get("Type").asString();
        this.value = jsonObject.get("Value").asString();
        this.expiry = jsonObject.get("Expiry").asString();
    }

    
    
    
    /**
     * @return the balanceType
     */
    public String getBalanceType() {
        return balanceType;
    }

    /**
     * @param balanceType the balanceType to set
     */
    public void setBalanceType(String balanceType) {
        this.balanceType = balanceType;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @return the expiry
     */
    public String getExpiry() {
        return expiry;
    }

    /**
     * @param expiry the expiry to set
     */
    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }
    
}
