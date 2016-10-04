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
public class AccountInfo {
    private String address1;
    private String address2;
    private String address3;
    private String address4;

    
     public AccountInfo(JsonObject jsonData) {
        this.address1 = jsonData.get("Address1").asString();
        this.address2 = jsonData.get("Address2").asString();
        this.address3 = jsonData.get("Address3").asString();
        this.address4 = jsonData.get("Address4").asString();
    }
     
     public String getAddress(){
         return  new StringBuilder(address1)
                        .append("\n")
                        .append(address2)
                        .append("\n")
                        .append(address3)
                        .append("\n")
                        .append(address4).toString();
     }
    /**
     * @return the address1
     */
    public String getAddress1() {
        return address1;
    }

    /**
     * @param address1 the address1 to set
     */
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    /**
     * @return the address2
     */
    public String getAddress2() {
        return address2;
    }

    /**
     * @param address2 the address2 to set
     */
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    /**
     * @return the address3
     */
    public String getAddress3() {
        return address3;
    }

    /**
     * @param address3 the address3 to set
     */
    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    /**
     * @return the address4
     */
    public String getAddress4() {
        return address4;
    }

    /**
     * @param address4 the address4 to set
     */
    public void setAddress4(String address4) {
        this.address4 = address4;
    }
}
