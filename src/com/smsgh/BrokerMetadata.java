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
public class BrokerMetadata extends BrokerErrorCode{

    private String service;
    private String customer;
    private String foreignId;
    private boolean isBundle;
    private String bundleValue;
    private int amount;
    private double totalCommission;
    private double totalServiceCharge;
    private double fee;
    private BrokerServiceDetail serviceDetails;
    private PerAccountServiceDetails perAccountServiceDetails;

    public BrokerMetadata(JsonObject jsonObject) {
        super(jsonObject);
        this.service = BrokerUtil.getJsonValue("Service", jsonObject);
        this.customer = BrokerUtil.getJsonValue("Customer", jsonObject);
        this.isBundle = BrokerUtil.getJsonBooleanValue("IsBundle", jsonObject);
        this.bundleValue = BrokerUtil.getJsonValue("BundleValue", jsonObject);
        this.amount = BrokerUtil.getJsonIntValue("Amount", jsonObject);
        this.totalCommission = BrokerUtil.getJsonDoubleValue("TotalCommission", jsonObject);
        this.totalServiceCharge = BrokerUtil.getJsonDoubleValue("TotalServiceCharge", jsonObject);
        this.fee = BrokerUtil.getJsonIntValue("Fee", jsonObject);
        if(getErrorCode().isEmpty() || null == getErrorCode()){
        serviceDetails = new BrokerServiceDetail(jsonObject.get("ServiceDetails").asObject());
        perAccountServiceDetails = new PerAccountServiceDetails(jsonObject.get("PerAccountServiceDetails").asObject());
        }else{
        serviceDetails = new BrokerServiceDetail();
        perAccountServiceDetails = new PerAccountServiceDetails();
        }
    }

    /**
     * @return the service
     */
    public String getService() {
        return service;
    }

    /**
     * @param service the service to set
     */
    public void setService(String service) {
        this.service = service;
    }

    /**
     * @return the customer
     */
    public String getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(String customer) {
        this.customer = customer;
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

    /**
     * @return the isBundle
     */
    public boolean isIsBundle() {
        return isBundle;
    }

    /**
     * @param isBundle the isBundle to set
     */
    public void setIsBundle(boolean isBundle) {
        this.isBundle = isBundle;
    }

    /**
     * @return the bundleValue
     */
    public String getBundleValue() {
        return bundleValue;
    }

    /**
     * @param bundleValue the bundleValue to set
     */
    public void setBundleValue(String bundleValue) {
        this.bundleValue = bundleValue;
    }

    /**
     * @return the amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * @return the totalCommission
     */
    public double getTotalCommission() {
        return totalCommission;
    }

    /**
     * @param totalCommission the totalCommission to set
     */
    public void setTotalCommission(double totalCommission) {
        this.totalCommission = totalCommission;
    }

    /**
     * @return the totalServiceCharge
     */
    public double getTotalServiceCharge() {
        return totalServiceCharge;
    }

    /**
     * @param totalServiceCharge the totalServiceCharge to set
     */
    public void setTotalServiceCharge(double totalServiceCharge) {
        this.totalServiceCharge = totalServiceCharge;
    }

    /**
     * @return the fee
     */
    public double getFee() {
        return fee;
    }

    /**
     * @param fee the fee to set
     */
    public void setFee(double fee) {
        this.fee = fee;
    }

    /**
     * @return the serviceDetails
     */
    public BrokerServiceDetail getServiceDetails() {
        return serviceDetails;
    }

    /**
     * @param serviceDetails the serviceDetails to set
     */
    public void setServiceDetails(BrokerServiceDetail serviceDetails) {
        this.serviceDetails = serviceDetails;
    }

    /**
     * @return the perAccountServiceDetails
     */
    public PerAccountServiceDetails getPerAccountServiceDetails() {
        return perAccountServiceDetails;
    }

    /**
     * @param perAccountServiceDetails the perAccountServiceDetails to set
     */
    public void setPerAccountServiceDetails(PerAccountServiceDetails perAccountServiceDetails) {
        this.perAccountServiceDetails = perAccountServiceDetails;
    }
}
