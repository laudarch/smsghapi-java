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
public class Data {

    /**
     * "AccountNumber": "UNKP0000000932",
		"CurrentBalance": 0,
		"ExpectedPayment": 0,
		"Name": "CHRISTIAN APEDO",
		"PaymentType": "broadband",

     */
    private String accountNumber;
    private String currentBalance;
    private String expiryDate;
    private String productType;
    private String status;
    private String planName;
    
    private ContactInfo contactInfo;

    public Data(JsonObject jsonData) {
        this.accountNumber = jsonData.get("AccountNumber").asString();
        this.currentBalance = jsonData.get("CurrentBalance").asString();
        this.expiryDate = jsonData.get("ExpiryDate").asString();
        this.productType = jsonData.get("ProductType").asString();
        this.status = jsonData.get("Status").asString();
        this.planName = jsonData.get("PlanName").asString();
        this.contactInfo = new ContactInfo(jsonData.get("ContactInfo").asObject());
    }

    /**
     * @return the accountNumber
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * @param accountNumber the accountNumber to set
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * @return the currentBalance
     */
    public String getCurrentBalance() {
        return currentBalance;
    }

    /**
     * @param currentBalance the currentBalance to set
     */
    public void setCurrentBalance(String currentBalance) {
        this.currentBalance = currentBalance;
    }

    /**
     * @return the expiryDate
     */
    public String getExpiryDate() {
        return expiryDate;
    }

    /**
     * @param expiryDate the expiryDate to set
     */
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * @return the productType
     */
    public String getProductType() {
        return productType;
    }

    /**
     * @param productType the productType to set
     */
    public void setProductType(String productType) {
        this.productType = productType;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the planName
     */
    public String getPlanName() {
        return planName;
    }

    /**
     * @param planName the planName to set
     */
    public void setPlanName(String planName) {
        this.planName = planName;
    }

    /**
     * @return the contactInfo
     */
    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    /**
     * @param contactInfo the contactInfo to set
     */
    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }
}
