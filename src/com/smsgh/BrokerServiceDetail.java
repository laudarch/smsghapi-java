/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smsgh;

/**
 *
 * @author Seth
 */
public class BrokerServiceDetail {

    private int amountMin;
    private int amountMax;
    private String amountType;
    private boolean online;
    private boolean commissionEnabled;
    private String commissionMode;
    private String commissionFormula;
    private boolean serviceChargeEnabled;
    private String serviceChargeMode;
    private String serviceChargeFormula;

    public BrokerServiceDetail(JsonObject jsonObject) {
        this.amountMin = BrokerUtil.getJsonIntValue("AmountMin", jsonObject);
        this.amountMax = BrokerUtil.getJsonIntValue("AmountMax", jsonObject);
        this.amountType = BrokerUtil.getJsonValue("AmountType", jsonObject);
        this.online = BrokerUtil.getJsonBooleanValue("Online", jsonObject);
        this.commissionEnabled = BrokerUtil.getJsonBooleanValue("SommissionEnabled", jsonObject);
        this.serviceChargeEnabled = BrokerUtil.getJsonBooleanValue("ServiceChargeEnabled", jsonObject);
        this.commissionMode = BrokerUtil.getJsonValue("CommissionMode", jsonObject);
        this.commissionFormula = BrokerUtil.getJsonValue("CommissionFormula", jsonObject);
        this.serviceChargeMode = BrokerUtil.getJsonValue("ServiceChargeMode", jsonObject);
        this.serviceChargeFormula = BrokerUtil.getJsonValue("ServiceChargeFormula", jsonObject);

    }

    BrokerServiceDetail() {
    }

    /**
     * @return the amountMin
     */
    public int getAmountMin() {
        return amountMin;
    }

    /**
     * @param amountMin the amountMin to set
     */
    public void setAmountMin(int amountMin) {
        this.amountMin = amountMin;
    }

    /**
     * @return the amountMax
     */
    public int getAmountMax() {
        return amountMax;
    }

    /**
     * @param amountMax the amountMax to set
     */
    public void setAmountMax(int amountMax) {
        this.amountMax = amountMax;
    }

    /**
     * @return the amountType
     */
    public String getAmountType() {
        return amountType;
    }

    /**
     * @param amountType the amountType to set
     */
    public void setAmountType(String amountType) {
        this.amountType = amountType;
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
     * @return the commissionEnabled
     */
    public boolean isCommissionEnabled() {
        return commissionEnabled;
    }

    /**
     * @param commissionEnabled the commissionEnabled to set
     */
    public void setCommissionEnabled(boolean commissionEnabled) {
        this.commissionEnabled = commissionEnabled;
    }

    /**
     * @return the commissionMode
     */
    public String getCommissionMode() {
        return commissionMode;
    }

    /**
     * @param commissionMode the commissionMode to set
     */
    public void setCommissionMode(String commissionMode) {
        this.commissionMode = commissionMode;
    }

    /**
     * @return the commissionFormula
     */
    public String getCommissionFormula() {
        return commissionFormula;
    }

    /**
     * @param commissionFormula the commissionFormula to set
     */
    public void setCommissionFormula(String commissionFormula) {
        this.commissionFormula = commissionFormula;
    }

    /**
     * @return the serviceChargeEnabled
     */
    public boolean isServiceChargeEnabled() {
        return serviceChargeEnabled;
    }

    /**
     * @param serviceChargeEnabled the serviceChargeEnabled to set
     */
    public void setServiceChargeEnabled(boolean serviceChargeEnabled) {
        this.serviceChargeEnabled = serviceChargeEnabled;
    }

    /**
     * @return the serviceChargeMode
     */
    public String getServiceChargeMode() {
        return serviceChargeMode;
    }

    /**
     * @param serviceChargeMode the serviceChargeMode to set
     */
    public void setServiceChargeMode(String serviceChargeMode) {
        this.serviceChargeMode = serviceChargeMode;
    }

    /**
     * @return the serviceChargeFormula
     */
    public String getServiceChargeFormula() {
        return serviceChargeFormula;
    }

    /**
     * @param serviceChargeFormula the serviceChargeFormula to set
     */
    public void setServiceChargeFormula(String serviceChargeFormula) {
        this.serviceChargeFormula = serviceChargeFormula;
    }
}
