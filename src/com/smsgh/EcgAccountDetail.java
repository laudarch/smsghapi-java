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
public class EcgAccountDetail extends BrokerErrorCode {

    String accountName;
    String message;

    public EcgAccountDetail(JsonObject json) {
        super(json);
        accountName = BrokerUtil.getJsonValue("account_name", json);
        message = BrokerUtil.getJsonValue("message", json);
    }

}
