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
public class BrokerAccountBalance {
 
    private String accountBalance;

    public BrokerAccountBalance(String accountBalance) {
        this.accountBalance = accountBalance;
    }

    public BrokerAccountBalance(JsonObject json) {
        
        try {
            setAccountBalance(json.get("AccountBalance").asString());
        } catch (Exception e) {
        }
    }

    
    
    /**
     * @return the accountNumber
     */
    public String getAccountBalance() {
        return accountBalance;
    }

    /**
     * @param accountNumber the accountNumber to set
     */
    public void setAccountBalance(String accountBalance) {
        this.accountBalance = accountBalance;
    }
}
