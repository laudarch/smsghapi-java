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
public class BrokerServiceCharge {

    private boolean serviceChargeEnabled;
    private String  commissionMode;
    private String serviceChargeFormula;

    public BrokerServiceCharge(JsonObject jsonObject) {
        this.serviceChargeEnabled = BrokerUtil.getJsonBooleanValue("ServiceChargeEnabled", jsonObject);
        this.commissionMode = BrokerUtil.getJsonValue("CommissionMode", jsonObject);
        this.serviceChargeFormula = BrokerUtil.getJsonValue("ServiceChargeFormula", jsonObject);
    }

    BrokerServiceCharge() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
     * @return the sommissionMode
     */
    public String getCommissionMode() {
        return commissionMode;
    }

    /**
     * @param sommissionMode the sommissionMode to set
     */
    public void setCommissionMode(String commissionMode) {
        this.commissionMode = commissionMode;
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
