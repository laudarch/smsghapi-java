/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smsgh;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Seth_160
 */
public class Bundles {

    private List<SurfBundle> surfBundles;
    private List<SurfPlusBundle> surfPlusBundles;

    public Bundles(JsonObject bundlesJson) {
        processSurfBundle(bundlesJson.get("SurfBundle").asArray());
        processSurfPlusBundle(bundlesJson.get("SurfPlusBundle").asArray());
    }

    public void processSurfBundle(JsonArray jsonSurfBalances) {
        try {
            if (null != jsonSurfBalances) {
                surfBundles = new ArrayList<>();
                for (int i = 0; i < jsonSurfBalances.size(); i++) {
                    surfBundles.add(new SurfBundle(jsonSurfBalances.get(i).asObject()));
                }
            }
        } catch (Exception e) {
        }

    }

    public void processSurfPlusBundle(JsonArray jsonSurfPlusBundle) {
        try {
            if (null != jsonSurfPlusBundle) {
                surfPlusBundles = new ArrayList<>();
                for (int i = 0; i < jsonSurfPlusBundle.size(); i++) {
                    surfPlusBundles.add(new SurfPlusBundle(jsonSurfPlusBundle.get(i).asObject()));
                }
            }
        } catch (Exception e) {
        }
    }

    /**
     * @return the surfBundles
     */
    public List<SurfBundle> getSurfBundles() {
        return surfBundles;
    }

    /**
     * @param surfBundles the surfBundles to set
     */
    public void setSurfBundles(List<SurfBundle> surfBundles) {
        this.surfBundles = surfBundles;
    }

    /**
     * @return the surfPlusBundles
     */
    public List<SurfPlusBundle> getSurfPlusBundles() {
        return surfPlusBundles;
    }

    /**
     * @param surfPlusBundles the surfPlusBundles to set
     */
    public void setSurfPlusBundles(List<SurfPlusBundle> surfPlusBundles) {
        this.surfPlusBundles = surfPlusBundles;
    }
}
