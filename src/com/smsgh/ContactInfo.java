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
public class ContactInfo {
    private String email;
    private String mobilePhone;

    public ContactInfo(JsonObject jsonData) {
        this.email = jsonData.get("Email").asString();
        this.mobilePhone = jsonData.get("MobilePhone").asString();
    }

    public ContactInfo(String email, String mobilePhone) {
        this.email = email;
        this.mobilePhone = mobilePhone;
    }
    
    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the mobilePhone
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * @param mobilePhone the mobilePhone to set
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
}
