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
public class VodafoneRequest extends AccountBasedRequest {
     private String service;

    public VodafoneRequest(String service,String account, double amount, String token, String foreignId) {
        super(account, amount, token, foreignId);
        this.service = service;
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
    

    public JsonObject getJsonObject(){
       return  super.getJsonObject()
                .add("service", service);
    }
}
