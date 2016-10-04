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
public class PerAccountServiceDetails {

    private BrokerCommission commission;
    private BrokerServiceCharge serviceCharge;

    public PerAccountServiceDetails(JsonObject jsonObject) {
        try {
            commission = new BrokerCommission(jsonObject.get("Commission").asObject());
            serviceCharge = new BrokerServiceCharge(jsonObject.get("ServiceCharge").asObject());
        } catch (Exception e) {
            commission = new BrokerCommission();
            serviceCharge = new BrokerServiceCharge();
        }

    }

    public PerAccountServiceDetails() {
    }

    
    /**
     * @return the commission
     */
    public BrokerCommission getCommission() {
        return commission;
    }

    /**
     * @param commission the commission to set
     */
    public void setCommission(BrokerCommission commission) {
        this.commission = commission;
    }

    /**
     * @return the serviceCharge
     */
    public BrokerServiceCharge getServiceCharge() {
        return serviceCharge;
    }

    /**
     * @param serviceCharge the serviceCharge to set
     */
    public void setServiceCharge(BrokerServiceCharge serviceCharge) {
        this.serviceCharge = serviceCharge;
    }
}
