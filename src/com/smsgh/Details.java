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
public class Details {

    private String AccountStatus;
    private String AccountType;

    List<SurflineBalance> balances;

    public Details(JsonObject detailsJson) {
        this.setAccountStatus(detailsJson.get("AccountStatus").asString());
        this.setAccountType(detailsJson.get("AccountType").asString());

        processBalances(detailsJson.get("Balances").asArray());
    }

    public void processBalances(JsonArray jsonBalances) {
        balances = new ArrayList<>();
        for (int i = 0; i < jsonBalances.size(); i++) {
            balances.add(new SurflineBalance(jsonBalances.get(i).asObject()));
        }
    }

    public Details(String AccountStatus, String AccountType, List<SurflineBalance> balances) {
        this.AccountStatus = AccountStatus;
        this.AccountType = AccountType;
        this.balances = balances;
    }

    /**
     * @return the AccountStatus
     */
    public String getAccountStatus() {
        return AccountStatus;
    }

    /**
     * @param AccountStatus the AccountStatus to set
     */
    public void setAccountStatus(String AccountStatus) {
        this.AccountStatus = AccountStatus;
    }

    /**
     * @return the AccountType
     */
    public String getAccountType() {
        return AccountType;
    }

    /**
     * @param AccountType the AccountType to set
     */
    public void setAccountType(String AccountType) {
        this.AccountType = AccountType;
    }
}
