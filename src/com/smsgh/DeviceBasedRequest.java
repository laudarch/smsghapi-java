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
public class DeviceBasedRequest extends BrokerRequestCommon {
    
    private String device;

    public DeviceBasedRequest(String device, double amount, String token, String foreignId) {
        super(amount, token, foreignId);
        this.device = device;
    }

    
    
    /**
     * @return the device
     */
    public String getDevice() {
        return device;
    }

    /**
     * @param device the device to set
     */
    public void setDevice(String device) {
        this.device = device;
    }
    
     public JsonObject getJsonObject(){
        return super.getJson()
                .add("device", device);
    }
    
}
