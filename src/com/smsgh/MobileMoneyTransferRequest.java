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
public class MobileMoneyTransferRequest extends BrokerRequestCommon {

    private String receivePhone;
    private String receiverName;
    private String provider;
    private String sender;

    public MobileMoneyTransferRequest(String receivePhone, String receiverName, String provider, String sender, double amount, String token, String foreignId) {
        super(amount, token, foreignId);
        this.receivePhone = receivePhone;
        this.receiverName = receiverName;
        this.provider = provider;
        this.sender = sender;
    }
    

    /**
     * @return the receivePhone
     */
    public String getReceivePhone() {
        return receivePhone;
    }

    /**
     * @param receivePhone the receivePhone to set
     */
    public void setReceivePhone(String receivePhone) {
        this.receivePhone = receivePhone;
    }

    /**
     * @return the receiverName
     */
    public String getReceiverName() {
        return receiverName;
    }

    /**
     * @param receiverName the receiverName to set
     */
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    /**
     * @return the provider
     */
    public String getProvider() {
        return provider;
    }

    /**
     * @param provider the provider to set
     */
    public void setProvider(String provider) {
        this.provider = provider;
    }

    /**
     * @return the sender
     */
    public String getSender() {
        return sender;
    }

    /**
     * @param sender the sender to set
     */
    public void setSender(String sender) {
        this.sender = sender;
    }
    
     public JsonObject getJsonObject(){

        return super.getJson()
                .add("receiverPhone", receivePhone)
                .add("provider", provider)
                .add("sender", sender)
                .add("receiverName", receiverName);
    }
     
}
