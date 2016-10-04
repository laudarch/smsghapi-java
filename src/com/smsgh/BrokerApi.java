package com.smsgh;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Seth_160
 */
public class BrokerApi extends AbstractApi {

    String apiToken = "";

    /**
     *
     * @param apiHost
     */
    public BrokerApi(ApiHost apiHost) {
        super(apiHost);
    }

    /**
     *
     * @param host
     * @param apiToken
     */
    public BrokerApi(ApiHost host, String apiToken) {
        this(host);
        this.apiToken = apiToken;
    }

    //<editor-fold desc="Paying Functions">
    //<editor-fold desc="Buy Airtime">
    /**
     * Performs airtime transaction
     *
     * @param request Must be valid and not null.
     * @return An instance of BrokerResponse
     * @throws HttpRequestException
     */
    public BrokerResponse buyAirtime(AirtimeRequest request) throws HttpRequestException {
        String resource = "/airtime/";
        return sendPostBrokerRequest(resource, request.getJsonObject());
    }

    /**
     * *
     * Performs airtime transaction
     *
     * @param phoneNo The mobile number.Must be a valid phone number in the
     * country that the operating API token is created from.
     * @param network The mobile network AirtimeNetwork
     * @param amount The amount
     * @param foreignId The foreign Id
     * @return An instance of BrokerResponse
     * @throws HttpRequestException
     */
    public BrokerResponse buyAirtime(String phoneNo, AirtimeNetwork network, double amount, String foreignId) throws HttpRequestException {
        AirtimeRequest request = new AirtimeRequest(network, phoneNo, amount, apiToken, foreignId);
        return buyAirtime(request);
    }

    /**
     *
     * Performs airtime transaction
     *
     * @param phoneNo The mobile number.Must be a valid phone number in the
     * country that the operating API token is created from.
     * @param network The mobile network
     * @param amount The amount
     * @param foreignId The foreign Id
     * @return An instance of BrokerResponse
     * @throws HttpRequestException
     */
    public BrokerResponse buyAirtime(String phoneNo, String network, double amount, String foreignId) throws HttpRequestException {
        AirtimeRequest request = new AirtimeRequest(AirtimeNetwork.valueOf(network), phoneNo, amount, apiToken, foreignId);
        return buyAirtime(request);
    }
    //</editor-fold>

    //<editor-fold desc="Mobile Money Transfer">
    /**
     * Performs mobile money transfer transaction
     *
     * @param receiverPhoneNo The receiver's mobile number. Must be valid and
     * not null.
     * @param receiverName The receiver's name
     * @param amount The amount
     * @param provider
     * @param sender The sender
     * @param foreignId The foreign Id
     * @return An instance of BrokerResponse
     * @throws HttpRequestException
     */
    public BrokerResponse transferToMobileMoney(String receiverPhoneNo, String receiverName, double amount, String provider, String sender, String foreignId) throws HttpRequestException {
        MobileMoneyTransferRequest request = new MobileMoneyTransferRequest(receiverPhoneNo, receiverName, provider, sender, amount, apiToken, foreignId);
        return transferToMobileMoney(request);
    }

    /**
     * Performs mobile money transfer transaction
     *
     * @param mobileMoneyTransferRequest Must be valid and not null
     * @return An instance of BrokerResponse
     * @throws HttpRequestException
     */
    public BrokerResponse transferToMobileMoney(MobileMoneyTransferRequest mobileMoneyTransferRequest) throws HttpRequestException {
        return sendPostBrokerRequest("/mobilemoney/", mobileMoneyTransferRequest.getJsonObject());
    }
    //</editor-fold>
    
    
    //<editor-fold desc="Buy  Busy Bundle">
   
    /**
     * 
     * @param device
     * @param bundle
     * @param amount
     * @param foreignId
     * @return
     * @throws HttpRequestException 
     */
    public BrokerResponse buyBusyBundle(String device, String bundle,double amount, String foreignId) throws HttpRequestException {
        
            return sendPostBrokerRequest("/busy",
                    new BundleBaseRequest(device, bundle, amount, this.apiToken, foreignId).getJsonObject());

    }

  
    //</editor-fold>

    
    
    //<editor-fold desc="Pay MTN Postpaid Bill">
   
    /**
     * 
     * @param device
     * @param bundle
     * @param amount
     * @param foreignId
     * @return
     * @throws HttpRequestException 
     */
    public BrokerResponse payMtnPostpaid(String phone,double amount, String foreignId) throws HttpRequestException {
        
           return payMtnBill(phone, amount, "postpaid", foreignId);

    }

  
    //</editor-fold>
    
    
    
    //<editor-fold desc="Pay TV License">
   
    /**
     * 
     * @param device
     * @param bundle
     * @param amount
     * @param foreignId
     * @return
     * @throws HttpRequestException 
     */
    public BrokerResponse payTvLicence(String account,double amount, String foreignId) throws HttpRequestException {
        
            return sendPostBrokerRequest("/tvlicense",
                    new JsonObject()
                            .add("account", account)
                            .add("amount", amount)
                            .add("foreignId", foreignId)
                            .add("token", this.apiToken));

    }

  
    //</editor-fold>
    
    //<editor-fold desc="Buy Aero Ticket">
   
    /**
     * Buy Aero ticket
     * @param account
     * @param amount
     * @param foreignId
     * @return
     * @throws HttpRequestException 
     */
    public BrokerResponse buyAeroTicket(String account,double amount, String foreignId) throws HttpRequestException {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("account",account);
        jsonObject.add("amount",amount);
        jsonObject.add("foreignId",foreignId);
        jsonObject.add("token",this.apiToken);
            return sendPostBrokerRequest("/aero",
                     jsonObject);

    }

  
    //</editor-fold>
    //<editor-fold desc="Buy Aero Ticket">
   
   /**
    * Payment of MTN Bill
    * @param phone
    * @param amount
    * @param service
    * @param foreignId
    * @return
    * @throws HttpRequestException 
    */
    public BrokerResponse payMtnBill(String phone,double amount,String service, String foreignId) throws HttpRequestException {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("phone",phone);
        jsonObject.add("service",service);
        jsonObject.add("amount",amount);
        jsonObject.add("foreignId",foreignId);
        jsonObject.add("token",this.apiToken);
            return sendPostBrokerRequest("/mtn",
                     jsonObject);

    }

     public BrokerResponse payMtnBill(String phone,double amount) throws HttpRequestException {
        return payMtnBill(phone, amount, "postpaid", "");
    }

  
    //</editor-fold>
    
    //<editor-fold desc="Surfline">
    /**
     * Performs Surfline top-up transaction
     *
     * @param accountBasedRequestRequest Must be valid and not null.
     * @param endPoint The URL to which payment will be made either surflineplus
     * or surfline
     * @return An instance of BrokerResponse
     * @throws HttpRequestException
     */
    private BrokerResponse buySurflineBundle(DeviceBasedRequest accountBasedRequestRequest,String bundle, String endPoint) throws HttpRequestException {
        String resource = "/".concat(endPoint).concat("/");
        return sendPostBrokerRequest(resource, accountBasedRequestRequest.getJsonObject().add("bundle", bundle));
    }

    /**
     * Performs Surfline top-up transaction
     *
     * @param device Must be valid Surfline number. e.g. 233255xxxxxx
     * @param amount Must be valid Surfline bundle amount
     * @param foreignId The foreign Id
     * @return An instance of BrokerResponse
     * @throws HttpRequestException
     */
    public BrokerResponse buySurflineBundle(String device,String bundle, double amount, String foreignId) throws HttpRequestException {
        return buySurflineBundle(device,bundle, amount, foreignId, "surfline");
    }

    /**
     * Performs Surfline top-up transaction
     *
     * @param device Must be valid Surfline number. e.g. 233255xxxxxx
     * @param amount Must be valid Surfline bundle amount
     * @param foreignId The foreign Id
     * @param endPoint The URL to which payment will be made either surflineplus
     * or surfline
     * @return An instance of BrokerResponse
     * @throws HttpRequestException
     */
    public BrokerResponse buySurflineBundle(String device, String  bundle,double amount, String foreignId, String endPoint) throws HttpRequestException {
        return buySurflineBundle(new DeviceBasedRequest(device, amount, apiToken, foreignId), bundle, endPoint);
    }

    //</editor-fold>
    //<editor-fold desc="DSTV">
    /**
     * Performs DStv bill payment transaction
     *
     * @param dstvRequest Must be valid DstvRequest Object and not null
     * @param urlAlias The URL alias to which the payment will be made. e.g.
     * dstv, dstvbo, gotv
     * @return An instance of BrokerResponse
     * @throws HttpRequestException
     */
    private BrokerResponse payDstvBill(DstvRequest dstvRequest, String urlAlias) throws HttpRequestException {
        String resource = "/".concat(urlAlias).concat("/");

        return sendPostBrokerRequest(resource, dstvRequest.getJsonObject());
    }

    /**
     * Performs DStv Regular bill payment transaction
     *
     * @param account Must be valid DStv account number either the customer
     * number or smart card number
     * @param amount Must be valid DStv amount
     * @param foreignId The foreign Id
     * @param urlAlias The URL alias to which the payment will be made. e.g.
     * dstv, dstvbo, gotv * @return An instance of BrokerResponse
     * @throws HttpRequestException
     */
    private BrokerResponse payDstvBill(String account, double amount, String foreignId, String urlAlias) throws HttpRequestException {
        DstvRequest request = new DstvRequest(account, amount, apiToken, foreignId);
        return payDstvBill(request, urlAlias);
    }

    /**
     * Performs DStv Regular bill payment transaction
     *
     * @param account Must be valid DStv account number either the customer
     * number or smart card number
     * @param amount Must be valid DStv amount
     * @param foreignId The foreign Id
     * @return An instance of BrokerResponse
     * @throws HttpRequestException
     */
    public BrokerResponse payDstvRegularBill(String account, double amount, String foreignId) throws HttpRequestException {
        return payDstvBill(account, amount, foreignId, "dstv");
    }

    /**
     * Performs DStv bill payment transaction
     *
     * @param dstvRequest Must be valid DstvRequest Object and not null
     * @param urlAlias The URL alias to which the payment will be made. e.g.
     * dstv, dstvbo, gotv
     * @return An instance of BrokerResponse
     * @throws HttpRequestException
     */
    private BrokerResponse payGotvBill(DstvRequest request, String endPoint) throws HttpRequestException {
        return payDstvBill(request, endPoint);
    }

    /**
     * Performs GOtv bill payment transaction
     *
     * @param account Must be valid DStv account number either the customer
     * number or smart card number
     * @param amount Must be valid DStv amount
     * @param foreignId The foreign Id
     * @return An instance of BrokerResponse
     * @throws HttpRequestException
     */
    public BrokerResponse payGotvBill(String account, double amount, String foreignId) throws HttpRequestException {
        return payDstvBill(account, amount, foreignId, "gotv");
    }

    /**
     * Performs DStv Box Office bill payment transaction
     *
     * @param account Must be valid DStv account number either the customer
     * number or smart card number
     * @param amount Must be valid DStv amount
     * @param foreignId The foreign Id
     * @return An instance of BrokerResponse
     * @throws HttpRequestException
     */
    public BrokerResponse payDstvBoBill(String account, double amount, String foreignId) throws HttpRequestException {
        return payDstvBill(account, amount, foreignId, "dstvbo");
    }

    /**
     * Performs DStv Box Office bill payment transaction
     *
     * @param dstvRequest Must be valid DstvRequest Object and not null
     * @return An instance of BrokerResponse
     * @throws HttpRequestException
     */
    public BrokerResponse payDstvBoBill(DstvRequest dstvRequest) throws HttpRequestException {
        return payDstvBill(dstvRequest, "dstvbo");
    }

    //</editor-fold>
    //<editor-fold desc="Vodafone Bill Payment">
    /**
     * Vodafone Bill Payment
     *
     * @param account Must be valid Vodafone account number
     * @param service Must be valid Vodafone Service eg postpaid
     * @param amount Must be valid Vodafone amount
     * @param foreignId The foreign Id
     * @return An instance of BrokerResponse
     * @throws HttpRequestException
     */
    public BrokerResponse payVodafoneBill(String account, String service, double amount, String foreignId) throws HttpRequestException {
        return vodafoneBillPayment(new VodafoneRequest(service, account, amount, apiToken, foreignId));
    }

    /**
     * Vodafone Bill Payment
     *
     * @param vodafoneRequest Must be valid Vodafone Request Object and not null
     * @return An instance of BrokerResponse
     * @throws HttpRequestException
     */
    public BrokerResponse vodafoneBillPayment(VodafoneRequest vodafoneRequest) throws HttpRequestException {
        return sendPostBrokerRequest("/vodafone", vodafoneRequest.getJsonObject());
    }
    //</editor-fold>

    //<editor-fold desc="Hubtell Topup">
    /**
     * Performs Hubtell top-up transaction
     *
     * @param account Must be valid Hubtell account name
     * @param amount Must be valid Hubtell bundle amount
     * @param foreignIdThe foreign Id
     * @return An instance of BrokerResponse
     * @throws HttpRequestException
     */
    public BrokerResponse buyHubtellBundle(String account, double amount, String foreignId) throws HttpRequestException {
        return sendPostBrokerRequest("/hubtell", new AccountBasedRequest(account, amount, apiToken, foreignId).getJsonObject());
    }

    //</editor-fold>
    //<editor-fold desc="ECG Bill Payment">
    /**
     * *
     * Performs ECG bills payment
     *
     * @param account Must be valid ECG account number
     * @param name Must be valid ECG account name
     * @param amount The transaction amount
     * @param serviceType The type of service eg postpaid
     * @param foreignId The foreign Id
     * @return An instance of BrokerResponse
     * @throws HttpRequestException
     */
    public BrokerResponse payEcgBill(String account, String name, double amount, String serviceType, String foreignId) throws HttpRequestException {
        return sendPostBrokerRequest("/ecg", new BrokerEcgRequest(account, amount, name, serviceType, apiToken, foreignId).getJsonObject());
    }

    /**
     * Performs ECG bills payment
     *
     * @param account Must be valid ECG account number
     * @param name Must be valid ECG account name
     * @param amount The transaction amount
     * @param foreignId The foreign Id
     * @return An instance of BrokerResponse
     * @throws HttpRequestException
     */
    public BrokerResponse payEcgPostpaidBill(String account, String name, double amount, String foreignId) throws HttpRequestException {
        return payEcgBill(account, name, amount, "postpaid", foreignId);
    }
    //</editor-fold>

    //<editor-fold desc="Get Details Functions">
    /**
     * Retrieves the wallet balance for a token
     *
     * @param token Must be valid and not null
     * @return BrokerAccountBalance
     */
    public BrokerAccountBalance getAccountBalance(String token) {
        try {
            JsonObject jsonObject = sendGetBrokerRequest("/balance/".concat(token), new ParameterMap());
            return new BrokerAccountBalance(jsonObject);
        } catch (HttpRequestException ex) {
            Logger.getLogger(BrokerApi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Retrieves the wallet balance for the apiToken
     *
     * @return BrokerAccountBalance
     */
    public BrokerAccountBalance getAccountBalance() {
        return getAccountBalance(apiToken);
    }

    /**
     * Retrieves all active services on Broker
     *
     * @return An instance of list of BrokerService
     * @throws HttpRequestException
     */
    public List<BrokerService> getServiceList() throws HttpRequestException {
        JsonArray json = sendGetBrokerRequestAsJsonArray("/services", new ParameterMap());
        BrokerServiceResponse brokerServiceResponse = new BrokerServiceResponse(json);
        return brokerServiceResponse.getBrokerServices();
    }

    /**
     * Retrieves details about a Surfline number
     *
     * @param device Must be valid Surfline number. e.g. 233255xxxxxx
     * @return An instance of SurflineDetails
     * @throws HttpRequestException
     */
    public SurflineDetails getSuflineDeviceDetail(String device) throws HttpRequestException {
        JsonObject json = sendGetBrokerRequest("/surfline", new ParameterMap().add("device", device));

        return new SurflineDetails(json);
    }

    /**
     * Retrieves details about a Vodafone broadband/postpaid number
     *
     * @param account Must be valid Vodafone broadband/postpaid number
     * @return An instance of VodafoneAccountDetails
     * @throws HttpRequestException
     */
    public VodafoneAccountDetails getVodafoneAccountDetail(String account) throws HttpRequestException {
        JsonObject json = sendGetBrokerRequest("/vodafone", new ParameterMap().add("account", account));
        return new VodafoneAccountDetails(json);
    }

    /**
     * Retrieves details about a DStv/GOtv account number
     *
     * @param account Must be valid DStv/GOtv account number
     * @return An instance of DstvAccountInfo
     * @throws HttpRequestException
     */
    public DstvAccountInfo getDstvAccountDetails(String account) throws HttpRequestException {
        JsonObject json = sendGetBrokerRequest("/dstv", new ParameterMap().add("account", account));
        return new DstvAccountInfo(json);
    }

    /**
     * Retrieves details about a Hubtell account
     *
     * @param account Must be valid Hubtell account
     * @return An instance of HubtellAccountDetail
     * @throws HttpRequestException
     */
    public HubtellAccountDetail getHubtellAccountDetails(String account) throws HttpRequestException {
        JsonObject json = sendGetBrokerRequest("/hubtell", new ParameterMap().add("account", account));
        return new HubtellAccountDetail(json);
    }

    /**
     * Retrieves details about an ECG account
     *
     * @param account Must be valid ECG account
     * @return An instance of EcgAccountDetail
     * @throws HttpRequestException
     */
    public EcgAccountDetail getEcgAccountDetails(String account) throws HttpRequestException {
        JsonObject json = sendGetBrokerRequest("/ecg", new ParameterMap().add("account", account));

        return new EcgAccountDetail(json);
    }

    //</editor-fold>
    //<editor-fold desc="Metadata">
    /**
     * Gets information about charges/commissions to be applied when performing
     * this transaction. Note: this does not debit your Broker wallet.
     *
     * @param phoneNo The mobile number.Must be a valid phone number in the
     * country that the operating API token is created from.
     * @param network The mobile network
     * @param amount The amount
     * @param foreignId The foreign Id
     * @return An instance of BrokerMetadata
     * @throws HttpRequestException
     */
    public BrokerMetadata getAirtimeMetadata(String phoneNo, AirtimeNetwork network, double amount, String foreignId) throws HttpRequestException {
        return getAirtimeMetadata(new AirtimeRequest(network, phoneNo, amount, apiToken, foreignId));
    }

    /**
     * Gets information about charges/commissions to be applied when performing
     * this transaction. Note: this does not debit your Broker wallet.
     *
     * @param phoneNo The mobile number.Must be a valid phone number in the
     * country that the operating API token is created from.
     * @param network The mobile network
     * @param amount The amount
     * @param foreignId The foreign Id
     * @return An instance of BrokerMetadata
     * @throws HttpRequestException
     */
    public BrokerMetadata getAirtimeMetadata(String phoneNo, String network, double amount, String foreignId) throws HttpRequestException {
        return getAirtimeMetadata(new AirtimeRequest(AirtimeNetwork.valueOf(network), phoneNo, amount, apiToken, foreignId));
    }

    /**
     * Gets information about charges/commissions to be applied when performing
     * this transaction. Note: this does not debit your Broker wallet.
     *
     * @param airtimeRequest Must be valid and not null
     * @return An instance of BrokerMetadata
     * @throws HttpRequestException
     */
    public BrokerMetadata getAirtimeMetadata(AirtimeRequest airtimeRequest) throws HttpRequestException {
        return getMetadata(airtimeRequest.getJsonObject(), "airtime");
    }

    /**
     * Gets information about charges/commissions to be applied when performing
     * this transaction. Note: this does not debit your Broker wallet.
     *
     * @param mobileMoneyTransferRequest Must be valid and not null
     * @return An instance of BrokerMetadata
     * @throws HttpRequestException
     */
    public BrokerMetadata getMobileMoneyTransferMetadata(MobileMoneyTransferRequest mobileMoneyTransferRequest) throws HttpRequestException {
        return getMetadata(mobileMoneyTransferRequest.getJsonObject(), "mobilemoney");
    }

    /**
     * Gets information about charges/commissions to be applied when performing
     * this transaction. Note: this does not debit your Broker wallet.
     *
     * @param receiverPhoneNo The receiver's mobile number. Must be valid and
     * not null.
     * @param receiverName The receiver's name
     * @param amount The amount
     * @param provider The provider.Must be either M
     * @param sender The sender
     * @param foreignId The foreign Id
     * @return An instance of BrokerMetadata
     * @throws HttpRequestException
     */
    public BrokerMetadata getMobileMoneyTransferMetadata(String receiverPhoneNo, String receiverName, double amount, String provider, String sender, String foreignId) throws HttpRequestException {

        return getMobileMoneyTransferMetadata(
                new MobileMoneyTransferRequest(receiverPhoneNo,
                        receiverName,
                        provider,
                        sender, amount, apiToken, foreignId));
    }

    /**
     * Gets information about charges/commissions to be applied when performing
     * this transaction. Note: this does not debit your Broker wallet.
     *
     * @param dstvRequest Must be valid and not null
     * @param urlAlias The URL alias to which the payment will be made. e.g.
     * dstv, dstvbo, gotv
     * @return An instance of BrokerMetadata
     * @throws HttpRequestException
     */
    private BrokerMetadata getDstvMetadata(DstvRequest dstvRequest, String urlAlias) throws HttpRequestException {
        return getMetadata(dstvRequest.getJsonObject(), urlAlias);
    }

    /**
     * Gets information about charges/commissions to be applied when performing
     * this transaction. Note: this does not debit your Broker wallet.
     *
     * @param account Must be valid DStv account number either the customer
     * number or smart card number
     * @param amount Must be valid DStv amount
     * @param foreignId The foreign Id
     * @param urlAlias The URL alias to which the payment will be made. e.g.
     * dstv, dstvbo, gotv * @return An instance of BrokerResponse
     * @return An instance of BrokerMetadata
     * @throws HttpRequestException
     */
    private BrokerMetadata getDstvMetadata(String account, double amount, String foreignId, String urlAlias) throws HttpRequestException {

        return getMetadata(new DstvRequest(account, amount, apiToken, foreignId).getJsonObject(), urlAlias);
    }

    /**
     * Gets information about charges/commissions to be applied when performing
     * this transaction. Note: this does not debit your Broker wallet.
     *
     * @param account Must be valid DStv account number either the customer
     * number or smart card number
     * @param amount Must be valid DStv amount
     * @param foreignId The foreign Id
     * @return An instance of BrokerMetadata
     * @throws HttpRequestException
     */
    public BrokerMetadata getDstvMetadata(String account, double amount, String foreignId) throws HttpRequestException {
        return getDstvMetadata(account, amount, foreignId, "dstv");
    }

    /**
     * Gets request about charges/commissions to be applied when performing this
     * transaction. Note: this does not debit your Broker wallet.
     *
     * @param request Must be valid and not null
     * @param urlAlias The URL alias to which the payment will be made. e.g.
     * dstv, dstvbo, gotv
     * @return An instance of BrokerMetadata
     * @throws HttpRequestException
     */
    private BrokerMetadata getGotvMetadata(DstvRequest request, String urlAlias) throws HttpRequestException {

        return getDstvMetadata(request, urlAlias);
    }

    /**
     * Gets information about charges/commissions to be applied when performing
     * this transaction. Note: this does not debit your Broker wallet.
     *
     * @param account Must be valid DStv account number either the customer
     * number or smart card number
     * @param amount Must be valid DStv amount
     * @param foreignId The foreign Id
     * @return An instance of BrokerMetadata
     * @throws HttpRequestException
     */
    public BrokerMetadata getGotvMetadata(String account, double amount, String foreignId) throws HttpRequestException {
        return getDstvMetadata(account, amount, foreignId, "gotv");
    }

    /**
     * /**
     * Gets information about charges/commissions to be applied when performing
     * this transaction. Note: this does not debit your Broker wallet.
     *
     * @param account Must be valid DStv Box Office account number either the
     * customer number or smart card number
     * @param amount Must be valid DStv amount
     * @param foreignId The foreign Id
     * @return An instance of BrokerMetadata
     * @throws HttpRequestException
     */
    public BrokerMetadata getDstvBoMetadata(String account, double amount, String foreignId) throws HttpRequestException {
        return getDstvMetadata(account, amount, foreignId, "dstvbo");
    }

    /**
     * Gets request about charges/commissions to be applied when performing this
     * transaction. Note: this does not debit your Broker wallet.
     *
     * @param request Must be valid and not null
     * @return An instance of BrokerMetadata
     * @throws HttpRequestException
     */
    public BrokerMetadata getDstvBoMetadata(DstvRequest request) throws HttpRequestException {
        return getDstvMetadata(request, "dstvbo");
    }

    /**
     * Gets request about charges/commissions to be applied when performing this
     * transaction. Note: this does not debit your Broker wallet.
     *
     * @param account Must be valid Vodafone account number
     * @param service Must be valid Service eg postpaid, prepaid
     * @param amount Must be valid Vodafone amount
     * @param foreignId The foreign Id
     * @return An instance of BrokerMetadata
     * @throws HttpRequestException
     */
    public BrokerMetadata getVodafoneMetadata(String account, String service, double amount, String foreignId) throws HttpRequestException {

        return getMetadata(new VodafoneRequest(service, account, amount, apiToken, foreignId).getJsonObject(), "/vodafone");
    }

    /**
     * Gets request about charges/commissions to be applied when performing this
     * transaction. Note: this does not debit your Broker wallet.
     *
     * @param account Must be valid Hubtell account number
     * @param amount Must be valid Hubtell amount
     * @param foreignId The foreign Id
     * @return An instance of BrokerMetadata
     * @throws HttpRequestException
     */
    public BrokerMetadata getHubtellMetadata(String account, double amount, String foreignId) throws HttpRequestException {

        return getMetadata(new AccountBasedRequest(account, amount, apiToken, foreignId).getJsonObject(), "/hubtell");
    }

    
     /**
     * Gets request about charges/commissions to be applied when performing this
     * transaction. Note: this does not debit your Broker wallet.
     * @param account Must be valid Ecg account number
     * @param accountName Must be valid Ecg account name
     * @param amount Must be valid Ecg  amount
     * @param serviceType Must be valid Service eg postpaid
     * @param foreignId  The foreign Id
     * @return  An instance of BrokerMetadata
     * @throws HttpRequestException 
     */
    public BrokerMetadata getEcgMetadata(String account, String accountName, double amount,String serviceType, String foreignId) throws HttpRequestException {

        return getMetadata(new EcgRequest(account,amount,accountName,serviceType,apiToken,foreignId).getJsonObject(), "/ecg");
    }
    /**
     * Gets request about charges/commissions to be applied when performing this
     * transaction. Note: this does not debit your Broker wallet.
     * @param account Must be valid Ecg account number
     * @param accountName Must be valid Ecg account name
     * @param amount Must be valid Ecg  amount
     * @param foreignId  The foreign Id
     * @return  An instance of BrokerMetadata
     * @throws HttpRequestException 
     */
    public BrokerMetadata getEcgPostpaidMetadata(String account, String accountName, double amount, String foreignId) throws HttpRequestException {

        return getEcgMetadata(account,accountName,amount,"postpaid",foreignId);
    }
    //</editor-fold>
    //<editor-fold desc="Broker Common Functions">
    /**
     * general Post request for most broker request
     *
     * @param resource
     * @param jsonObject
     * @return
     * @throws HttpRequestException
     */
    public BrokerResponse sendPostBrokerRequest(String resource, JsonObject jsonObject) throws HttpRequestException {

       
        return new BrokerResponse(JsonObject.readFrom(sendPostBrokerRequestResponseAsString(resource, jsonObject)));

    }

    /**
     * Send post request and returns the response as a string
     *
     * @param resource
     * @param jsonObject
     * @return
     * @throws HttpRequestException
     */
    private String sendPostBrokerRequestResponseAsString(String resource, JsonObject jsonObject) throws HttpRequestException {
        String contentType = "application/json";
        HttpResponse response = this.httpClient.post(resource, contentType, jsonObject.toString().getBytes());
        if (response.getStatus() == HttpURLConnection.HTTP_CREATED) {
            return ((response.getBodyAsString()));
        } else {
            return response.getBodyAsString();
            // throw new HttpRequestException(new Exception("Request Failed"), response);
        }
    }

    /**
     * Get method for the Get request of Broker returns a json of the response
     *
     * @param resource
     * @param parameterMap
     * @return
     * @throws HttpRequestException
     */
    private JsonObject sendGetBrokerRequest(String resource, ParameterMap parameterMap) throws HttpRequestException {
        return (JsonObject.readFrom(sendGetBrokerRequestResponse(resource, parameterMap)));
    }

    /**
     * Get json array from a get json response
     *
     * @param resource
     * @param parameterMap
     * @return
     * @throws HttpRequestException
     */
    private JsonArray sendGetBrokerRequestAsJsonArray(String resource, ParameterMap parameterMap) throws HttpRequestException {
        return (JsonArray.readFrom(sendGetBrokerRequestResponse(resource, parameterMap)));
    }

    /**
     * Does a get and returns the respone as a string
     *
     * @param resource
     * @param parameterMap
     * @return
     */
    private String sendGetBrokerRequestResponse(String resource, ParameterMap parameterMap) {
        HttpResponse response = this.httpClient.get(resource, parameterMap);
        //   if (response.getStatus() == HttpURLConnection.HTTP_OK) {
        return ((response.getBodyAsString()));
//        } else {
//            throw new HttpRequestException(new Exception("Request Failed"), response);
//        }

    }

    /**
     * Gets all the metadata of a given service it states the service name the
     * stat ie online or not and the commisions and surcharges of that
     * particular service
     *
     * @param requestObject
     * @param serviceName
     * @return
     * @throws HttpRequestException
     */
    public BrokerMetadata getMetadata(JsonObject requestObject, String serviceName) throws HttpRequestException {
        String response = sendPostBrokerRequestResponseAsString("/metadata/" + serviceName, requestObject);
        return new BrokerMetadata(JsonObject.readFrom(response));
    }
    //</editor-fold>

}
