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
public class BrokerCommission {

    private boolean commissionEnabled;
    private String commissionMode;
    private String commissionFormula;

    public BrokerCommission() {
    }

    public BrokerCommission(JsonObject jsonObject) {
        this.commissionEnabled = BrokerUtil.getJsonBooleanValue("CommissionEnabled", jsonObject);
        this.commissionMode = BrokerUtil.getJsonValue("CommissionMode", jsonObject);
        this.commissionFormula = BrokerUtil.getJsonValue("CommissionFormula", jsonObject);
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

}
