/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smsgh;

import com.smsgh.Bundle;
import com.smsgh.Bundles;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Seth_160
 */
public class SurflineDetails extends SurflineCommon {

    private List<Bundle> bundles;
    private Bundles surfBundles;

    public SurflineDetails(JsonObject jsonObject) {
        super(jsonObject);
        
        processBundleList(jsonObject.get("Bundles"));
    }

    void processBundleList(JsonValue bundlesObj) {
        bundles = new ArrayList<>();
        if (bundlesObj.isArray()) {
            JsonArray bundlesArray = bundlesObj.asArray();
            for (int i = 0; i < bundlesArray.size(); i++) {
                bundles.add(new Bundle(bundlesArray.get(i).asObject()));
            }
        } else {
            surfBundles = new Bundles(bundlesObj.asObject());
        }

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

    /**
     * @return the surfBundles
     */
    public Bundles getSurfBundles() {
        return surfBundles;
    }

    /**
     * @param surfBundles the surfBundles to set
     */
    public void setSurfBundles(Bundles surfBundles) {
        this.surfBundles = surfBundles;
    }
}
