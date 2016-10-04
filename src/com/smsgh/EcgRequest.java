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
public class EcgRequest extends BrokerRequestCommon{
    String account;
    String serviceType;
    String name;

 
    
    /***
     * Ecg base request
     * @param account
     * @param amount
     * @param name
     * @param serviceType either <strong>prepaid</strong> or <b>postpaid</b>
     * @param token
     * @param foreignId 
     */
    public EcgRequest(String account,double amount,String name, String serviceType,String token, String foreignId) {
        super(amount, token, foreignId);
        this.name = name;
        this.account = account;
        this.serviceType = serviceType;
    }
    
       public JsonObject getJsonObject(){
        return super.getJson()
                .add("account", account)
                .add("serviceType", serviceType)
                .add("accountName", name);
    }
    
}
