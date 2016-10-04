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
public class HubtellAccountDetail extends BrokerErrorCode {

    private String accountId;
    private String balance;
    private List<Bundle> bundles;

    public HubtellAccountDetail(JsonObject jsonObject) {
        super(jsonObject);
        this.accountId = jsonObject.get("AccountId").asString();
        this.balance = jsonObject.get("Balance").asString();
        processBundles(jsonObject.get("Bundles").asArray());
    }

    public void processBundles(JsonArray bundlesArray) {

        bundles = new ArrayList<>();
        if (null != bundlesArray) {
            for (int i = 0; i < bundlesArray.size(); i++) {
                bundles.add(new Bundle(bundlesArray.get(i).asObject()));
            }
        }
    }

    /**
     * @return the accountId
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * @param accountId the accountId to set
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    /**
     * @return the balance
     */
    public String getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(String balance) {
        this.balance = balance;
    }

    /**
     * @return the bundles
     */
    public List<Bundle> getBundles() {
        return bundles;
    }

    /**
     * @param bundles the bundles to set
     */
    public void setBundles(List<Bundle> bundles) {
        this.bundles = bundles;
    }

}
