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
public class VodafoneAccountDetails extends BrokerErrorCode {
      private Data data;
      private AccountInfo accountInfo;

    public VodafoneAccountDetails(JsonObject json) {
        super(json);
        if(getErrorCode().isEmpty() || null==getErrorCode())
        data  = new Data(json.get("Data").asObject());
        accountInfo  = new AccountInfo(json.get("AccountInfo").asObject());
    }

      
      
    /**
     * @return the data
     */
    public Data getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Data data) {
        this.data = data;
    }

    /**
     * @return the accountInfo
     */
    public AccountInfo getAccountInfo() {
        return accountInfo;
    }

    /**
     * @param accountInfo the accountInfo to set
     */
    public void setAccountInfo(AccountInfo accountInfo) {
        this.accountInfo = accountInfo;
    }
}
