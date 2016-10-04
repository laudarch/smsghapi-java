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
public class BrokerService {

    private String name;
    private boolean online;
    private String urlAlias;
    private String country;
    private int minimumAmount;
    private int maximumAmount;
    private String amountOptions;

    public BrokerService(String name, boolean online, String urlAlias, String country, int minimumAmount, int maximumAmount, String amountOptions) {
        this.name = name;
        this.online = online;
        this.urlAlias = urlAlias;
        this.country = country;
        this.minimumAmount = minimumAmount;
        this.maximumAmount = maximumAmount;
        this.amountOptions = amountOptions;
    }
    
    public BrokerService(JsonObject jsonObject){
        try {
            this.name = jsonObject.get("Name").asString();
            this.online = jsonObject.get("Online").asBoolean();
            this.urlAlias = jsonObject.get("UrlAlias").asString();
            this.country = jsonObject.get("Country").asString();
            this.minimumAmount = jsonObject.get("MinimumAmount").asInt();
            this.maximumAmount = jsonObject.get("MaximumAmount").asInt();
            this.amountOptions = jsonObject.get("AmountOptions").asString();
        } catch (Exception e) {
        }
    }

    public BrokerService() {
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
     * @return the online
     */
    public boolean isOnline() {
        return online;
    }

    /**
     * @param online the online to set
     */
    public void setOnline(boolean online) {
        this.online = online;
    }

    /**
     * @return the urlAlias
     */
    public String getUrlAlias() {
        return urlAlias;
    }

    /**
     * @param urlAlias the urlAlias to set
     */
    public void setUrlAlias(String urlAlias) {
        this.urlAlias = urlAlias;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the minimumAmount
     */
    public int getMinimumAmount() {
        return minimumAmount;
    }

    /**
     * @param minimumAmount the minimumAmount to set
     */
    public void setMinimumAmount(int minimumAmount) {
        this.minimumAmount = minimumAmount;
    }

    /**
     * @return the maximumAmount
     */
    public int getMaximumAmount() {
        return maximumAmount;
    }

    /**
     * @param maximumAmount the maximumAmount to set
     */
    public void setMaximumAmount(int maximumAmount) {
        this.maximumAmount = maximumAmount;
    }

    /**
     * @return the amountOptions
     */
    public String getAmountOptions() {
        return amountOptions;
    }

    /**
     * @param amountOptions the amountOptions to set
     */
    public void setAmountOptions(String amountOptions) {
        this.amountOptions = amountOptions;
    }
}
