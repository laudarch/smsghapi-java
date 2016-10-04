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
public class BrokerUtil {
    
    
    
    public static String getJsonValue(String key, JsonObject jsonObject){
        
        try {
          return   jsonObject.get(key).asString();
        } catch (Exception e) {
        }
        return  "";
    }
    
     public static int getJsonIntValue(String key, JsonObject jsonObject){
        
        try {
          return   jsonObject.get(key).asInt();
        } catch (Exception e) {
        }
        return  0;
    } public static double getJsonDoubleValue(String key, JsonObject jsonObject){
        
        try {
          return   jsonObject.get(key).asDouble();
        } catch (Exception e) {
        }
        return  0;
    }
     public static boolean getJsonBooleanValue(String key, JsonObject jsonObject){
        
        try {
          return   jsonObject.get(key).asBoolean();
        } catch (Exception e) {
        }
        return  false;
    }
}
