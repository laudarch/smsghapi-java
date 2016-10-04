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
public class BrokerRequestCommon {

    private double amount;

    private String token;

    private String foreignId;

    public BrokerRequestCommon(double amount, String token, String foreignId) {
        this.amount = amount;
        this.token = token;
        this.foreignId = foreignId;
    }

    

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * @return the foreignId
     */
    public String getForeignId() {
        return foreignId;
    }

    /**
     * @param foreignId the foreignId to set
     */
    public void setForeignId(String foreignId) {
        this.foreignId = foreignId;
    }
    public JsonObject getJson(){
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("amount", amount);
        jsonObject.add("token", token);
        jsonObject.add("foreignId", foreignId);
        return jsonObject;
    }
    
}
