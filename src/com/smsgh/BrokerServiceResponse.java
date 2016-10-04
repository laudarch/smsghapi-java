/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smsgh;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Seth_160
 */
public class BrokerServiceResponse {
    private List<BrokerService> brokerServices;

    public BrokerServiceResponse(JsonArray json) {
       brokerServices = new ArrayList<>();
        for(int i=0;i< json.size();i++){
            brokerServices.add(new BrokerService((JsonObject)json.get(i))); 
        }
    }

    
    
    /**
     * @return the brokerServices
     */
    public List<BrokerService> getBrokerServices() {
        return brokerServices;
    }
    

    /**
     * @param brokerServices the brokerServices to set
     */
    public void setBrokerServices(List<BrokerService> brokerServices) {
        this.brokerServices = brokerServices;
    }
}
