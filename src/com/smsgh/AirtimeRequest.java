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
public class AirtimeRequest extends BrokerRequestCommon {

    private AirtimeNetwork network;
    private String phone;

    public AirtimeRequest(AirtimeNetwork network, String phone, double amount, String token, String foreignId) {
        super(amount, token, foreignId);
        this.network = network;
        this.phone = phone;
    }

    /**
     * @return the network
     */
    public AirtimeNetwork getNetwork() {
        return network;
    }

    /**
     * @param network the network to set
     */
    public void setNetwork(AirtimeNetwork network) {
        this.network = network;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public JsonObject getJsonObject() {
        return super.getJson()
                .add("phone", phone)
                .add("network", network.getValue());
    }
}
