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
public enum AirtimeNetwork {

    
    Mtn(62001),
    Vodafone(62002),
    Tigo(62003),
    Expresso(62004),
    Airtel(62006),
    Glo(62007),
    None(0);
    
    private int value;

    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(int value) {
        this.value = value;
    }

    AirtimeNetwork(int value) {
        this.value = value;
    }

    
}
