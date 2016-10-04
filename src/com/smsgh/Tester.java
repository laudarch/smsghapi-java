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
public class Tester {

    public static void main(String[] args) {

        String str = "[\n"
                + "  {\n"
                + "    \"Name\": \"Airtime\",\n"
                + "    \"Online\": true,\n"
                + "    \"UrlAlias\": \"airtime\",\n"
                + "    \"Country\": \"Ghana\",\n"
                + "    \"MinimumAmount\": 1,\n"
                + "    \"MaximumAmount\": 1000,\n"
                + "    \"AmountOptions\": \"\"\n"
                + "  },\n"
                + "  {\n"
                + "    \"Name\": \"Surfline\",\n"
                + "    \"Online\": true,\n"
                + "    \"UrlAlias\": \"surfline\",\n"
                + "    \"Country\": \"Ghana\",\n"
                + "    \"MinimumAmount\": 25,\n"
                + "    \"MaximumAmount\": 445,\n"
                + "    \"AmountOptions\": \"25,75,125,225,445\"\n"
                + "  },\n"
                + "  {\n"
                + "    \"Name\": \"Vodafone Internet\",\n"
                + "    \"Online\": true,\n"
                + "    \"UrlAlias\": \"vodafone\",\n"
                + "    \"Country\": \"Ghana\",\n"
                + "    \"MinimumAmount\": 1,\n"
                + "    \"MaximumAmount\": 10000,\n"
                + "    \"AmountOptions\": null\n"
                + "  },\n"
                + "  {\n"
                + "    \"Name\": \"SurflinePlus\",\n"
                + "    \"Online\": true,\n"
                + "    \"UrlAlias\": \"surflineplus\",\n"
                + "    \"Country\": \"Ghana\",\n"
                + "    \"MinimumAmount\": 9.9,\n"
                + "    \"MaximumAmount\": 499,\n"
                + "    \"AmountOptions\": \"9.9,19,69,129,239,499\"\n"
                + "  },\n"
                + "  {\n"
                + "    \"Name\": \"Hubtell\",\n"
                + "    \"Online\": true,\n"
                + "    \"UrlAlias\": \"hubtell\",\n"
                + "    \"Country\": \"Ghana\",\n"
                + "    \"MinimumAmount\": 5,\n"
                + "    \"MaximumAmount\": 2000,\n"
                + "    \"AmountOptions\": \"5,10,20,50,100,200,500,1000,1500,2000\"\n"
                + "  },\n"
                + "  {\n"
                + "    \"Name\": \"DSTV regular\",\n"
                + "    \"Online\": true,\n"
                + "    \"UrlAlias\": \"dstv\",\n"
                + "    \"Country\": \"Ghana\",\n"
                + "    \"MinimumAmount\": 50,\n"
                + "    \"MaximumAmount\": 3000,\n"
                + "    \"AmountOptions\": null\n"
                + "  },\n"
                + "  {\n"
                + "    \"Name\": \"DSTV box office\",\n"
                + "    \"Online\": true,\n"
                + "    \"UrlAlias\": \"dstvbo\",\n"
                + "    \"Country\": \"Ghana\",\n"
                + "    \"MinimumAmount\": 50,\n"
                + "    \"MaximumAmount\": 3000,\n"
                + "    \"AmountOptions\": null\n"
                + "  },\n"
                + "  {\n"
                + "    \"Name\": \"MPower Mobile Money\",\n"
                + "    \"Online\": true,\n"
                + "    \"UrlAlias\": \"mobilemoney\",\n"
                + "    \"Country\": \"Ghana\",\n"
                + "    \"MinimumAmount\": 1,\n"
                + "    \"MaximumAmount\": 2000,\n"
                + "    \"AmountOptions\": null\n"
                + "  },\n"
                + "  {\n"
                + "    \"Name\": \"GOtv\",\n"
                + "    \"Online\": true,\n"
                + "    \"UrlAlias\": \"gotv\",\n"
                + "    \"Country\": \"Ghana\",\n"
                + "    \"MinimumAmount\": 45,\n"
                + "    \"MaximumAmount\": 1000,\n"
                + "    \"AmountOptions\": null\n"
                + "  }\n"
                + "]";

        JsonArray jsonArray = JsonArray.readFrom(str);
        int arraySize = jsonArray.size();
        for (int i = 0; i < arraySize; i++) {
            JsonObject jsonObject = (JsonObject) jsonArray.get(i);
            BrokerService service = new BrokerService(jsonObject);
            System.out.println("Service name     : " + service.getName());
            System.out.println("Service UrlAlias : " + service.getUrlAlias());
        }
        System.out.println("Array Sixe : " + jsonArray.size());
    }
}
