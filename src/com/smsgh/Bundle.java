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
public class Bundle {

    private String name;
    private String value;

    public Bundle(JsonObject bundleJson) {
        this.name = bundleJson.get("Name").asString();
        this.value = bundleJson.get("Value").asString();
    }

    /**
     * @return the Name
     */
    public String getName() {
        return name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.name = Name;
    }

    /**
     * @return the Value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param Value the Value to set
     */
    public void setValue(String Value) {
        this.value = Value;
    }
}
