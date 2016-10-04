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
public class DstvRequest extends BrokerRequestCommon{
    
    private String account;

    public DstvRequest(String account,double amount, String token, String foreignId) {
        super(amount, token, foreignId);
        this.account = account;
    }
    
    
    /**
     * @return the Account
     */
    public String getAccount() {
        return account;
    }

    /**
     * @param Account the Account to set
     */
    public void setAccount(String Account) {
        this.account = Account;
    }
    public JsonObject getJsonObject(){
        return this.getJson().add("account", account);
    }
}
