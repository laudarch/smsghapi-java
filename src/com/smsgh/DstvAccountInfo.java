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
public class DstvAccountInfo extends BrokerErrorCode {

    private CustomerData customerData;
    private AccountInfo accountInfo;

    public DstvAccountInfo(JsonObject json) {
        super(json);
        customerData = new CustomerData(json.get("CustomerData").asObject());
        accountInfo = new AccountInfo(json.get("AccountInfo").asObject());
    }

    
    

    /**
     * @return the CustomerData
     */
    public CustomerData getCustomerData() {
        return customerData;
    }

    /**
     * @param CustomerData the CustomerData to set
     */
    public void setCustomerData(CustomerData CustomerData) {
        this.customerData = CustomerData;
    }

    /**
     * @return the AccountInfo
     */
    public AccountInfo getAccountInfo() {
        return accountInfo;
    }

    /**
     * @param AccountInfo the AccountInfo to set
     */
    public void setAccountInfo(AccountInfo AccountInfo) {
        this.accountInfo = AccountInfo;
    }

    public class CustomerData {

        private String CustomerSurname;
        private String CustomerStatus;
        private String AccountCurrency;
        private String AccountType;
        private String AccountStatus;
        private String LastInvoiceDate;
        private String PaymentDueDate;
        private String CustomerCellNumber;

        public CustomerData(JsonObject jsonObject) {
            this.CustomerSurname = jsonObject.get("CustomerSurname").asString();
            this.CustomerStatus = jsonObject.get("CustomerStatus").asString();
            this.AccountCurrency = jsonObject.get("AccountCurrency").asString();
            this.AccountType = jsonObject.get("AccountType").asString();
            this.LastInvoiceDate = jsonObject.get("LastInvoiceDate").asString();
            this.PaymentDueDate = jsonObject.get("PaymentDueDate").asString();
            this.CustomerCellNumber = jsonObject.get("CustomerCellNumber").asString();
        }

        /**
         * @return the CustomerSurname
         */
        public String getCustomerSurname() {
            return CustomerSurname;
        }

        /**
         * @param CustomerSurname the CustomerSurname to set
         */
        public void setCustomerSurname(String CustomerSurname) {
            this.CustomerSurname = CustomerSurname;
        }

        /**
         * @return the CustomerStatus
         */
        public String getCustomerStatus() {
            return CustomerStatus;
        }

        /**
         * @param CustomerStatus the CustomerStatus to set
         */
        public void setCustomerStatus(String CustomerStatus) {
            this.CustomerStatus = CustomerStatus;
        }

        /**
         * @return the AccountCurrency
         */
        public String getAccountCurrency() {
            return AccountCurrency;
        }

        /**
         * @param AccountCurrency the AccountCurrency to set
         */
        public void setAccountCurrency(String AccountCurrency) {
            this.AccountCurrency = AccountCurrency;
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
         * @return the LastInvoiceDate
         */
        public String getLastInvoiceDate() {
            return LastInvoiceDate;
        }

        /**
         * @param LastInvoiceDate the LastInvoiceDate to set
         */
        public void setLastInvoiceDate(String LastInvoiceDate) {
            this.LastInvoiceDate = LastInvoiceDate;
        }

        /**
         * @return the PaymentDueDate
         */
        public String getPaymentDueDate() {
            return PaymentDueDate;
        }

        /**
         * @param PaymentDueDate the PaymentDueDate to set
         */
        public void setPaymentDueDate(String PaymentDueDate) {
            this.PaymentDueDate = PaymentDueDate;
        }

        /**
         * @return the CustomerCellNumber
         */
        public String getCustomerCellNumber() {
            return CustomerCellNumber;
        }

        /**
         * @param CustomerCellNumber the CustomerCellNumber to set
         */
        public void setCustomerCellNumber(String CustomerCellNumber) {
            this.CustomerCellNumber = CustomerCellNumber;
        }
    }

    public class AccountInfo {

        private String dstvSmartCardNumber;
        private String rechargeCurrency;

        public AccountInfo(JsonObject jsonObject) {
            this.dstvSmartCardNumber = jsonObject.get("DstvSmartCardNumber").asString();
            this.rechargeCurrency = jsonObject.get("RechargeCurrency").asString();
        }

        /**
         * @return the DstvSmartCardNumber
         */
        public String getDstvSmartCardNumber() {
            return dstvSmartCardNumber;
        }

        /**
         * @param DstvSmartCardNumber the DstvSmartCardNumber to set
         */
        public void setDstvSmartCardNumber(String DstvSmartCardNumber) {
            this.dstvSmartCardNumber = DstvSmartCardNumber;
        }

        /**
         * @return the RechargeCurrency
         */
        public String getRechargeCurrency() {
            return rechargeCurrency;
        }

        /**
         * @param RechargeCurrency the RechargeCurrency to set
         */
        public void setRechargeCurrency(String RechargeCurrency) {
            this.rechargeCurrency = RechargeCurrency;
        }

    }
}
