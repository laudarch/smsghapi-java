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
public class BundleBaseRequest extends AccountBasedRequest {

    private String bundle;
    
    public BundleBaseRequest(String device,String bundle, double amount, String token, String foreignId) {
        super(device, amount, token, foreignId);
        this.bundle = bundle;
    }

    /**
     * @return the bundle
     */
    public String getBundle() {
        return bundle;
    }

    /**
     * @param bundle the bundle to set
     */
    public void setBundle(String bundle) {
        this.bundle = bundle;
    }
    
    /**
     * 
     * @return 
     */
    

    public JsonObject getJsonObject(){
        return super.getJsonObject()
                .add("bundle", bundle);
    }
}
