/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smsgh;

import com.smsgh.Details;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Seth_160
 */
public class SurflineCommon extends BrokerErrorCode {

    private String serviceName;
    private String device;
    private List<String> endPoint;
    private Details details;

    public SurflineCommon(JsonObject jsonObject) {
        super(jsonObject);
        this.serviceName = jsonObject.get("ServiceName").asString();
        this.device = jsonObject.get("Device").asString();
        processEndPoint(jsonObject.get("EndPoint").asArray());
        details = new Details(jsonObject.get("Details").asObject());
    }

    public void processEndPoint(JsonArray endPointJson) {
        int size = endPointJson.size();
        endPoint = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            endPoint.add(endPointJson.get(i).asString());
        }
    }

    public void processDetails(JsonObject detailsJson) {
        try {
            details.setAccountStatus(detailsJson.get("AccountStatus").asString());
            details.setAccountType(detailsJson.get("AccountType").asString());

        } catch (Exception e) {
        }
    }

    /**
     * @return the ServiceName
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * @param ServiceName the ServiceName to set
     */
    public void setServiceName(String ServiceName) {
        this.serviceName = ServiceName;
    }

    /**
     * @return the Device
     */
    public String getDevice() {
        return device;
    }

    /**
     * @param Device the Device to set
     */
    public void setDevice(String Device) {
        this.device = Device;
    }

    /**
     * @return the EndPoint
     */
    public List<String> getEndPoint() {
        return endPoint;
    }

    /**
     * @param EndPoint the EndPoint to set
     */
    public void setEndPoint(List<String> EndPoint) {
        this.endPoint = EndPoint;
    }

    /**
     * @return the Details
     */
    public Details getDetails() {
        return details;
    }

    /**
     * @param Details the Details to set
     */
    public void setDetails(Details Details) {
        this.details = Details;
    }
}
