package org.example;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Address {
    StringBuffer response;

    public void requestApi() {
        USOMApi usomApi = new USOMApi();
        try {
            String baseUrl = usomApi.getApiUrl() + "address/index";
            String Url = baseUrl;

            // Adres endpoint'i için bağlantı oluşturma ve yanıtı okuma
            URL addressUrl = new URL(Url);
            HttpURLConnection addressCon = (HttpURLConnection) addressUrl.openConnection();
            addressCon.setRequestMethod("GET");


            StringBuffer addressResponse = new StringBuffer();
            BufferedReader addressIn = new BufferedReader(new InputStreamReader(addressCon.getInputStream()));
            String inputLine;
            while ((inputLine = addressIn.readLine()) != null) {
                addressResponse.append(inputLine);
            }
            addressIn.close();
            this.response = addressResponse;
            // Yanıtları ekrana yazdırma
            System.out.println("Address Endpoint Yanıtı:");
            System.out.println(addressResponse);

        } catch (Exception e) {
            System.out.println("Hata oluştu: " + e.getMessage());
        }


    }

    public JSONObject getMock() {
        return new JSONObject("{'models':[{'url':'aa.com','criticality_level':3},{'url':'aa.com','criticality_level':4},{'url':'bc.com','criticality_level':3}]}");
    }

    public JSONObject getResponse() {
        return new JSONObject(this.response.toString());
    }

    public Object findObject(String search) {
        Object foundObject = null;
        JSONObject jsonObj = new JSONObject(this.response.toString());
        JSONArray resList = jsonObj.getJSONArray("models");

        for (Object line1 : resList) {
            ModelsV1Data itmModelsV1Data = new ModelsV1Data();
            JSONObject temp = (JSONObject) line1;
            if (search.contains(temp.get("url").toString())) {
                System.out.println(temp);
                foundObject = temp;
            }
        }

        return foundObject;
    }

    public Object getConnectionType() {

        return null;
    }

    public Object getCriticalityLevel() {
        return null;
    }

    public Object getDate() {
        return null;
    }

    public Object getSource() {
        return null;
    }

    public Object getUrl() {
        return null;
    }

    public Object getType() {
        return null;
    }

    public Object getDesc() {
        return null;
    }

}
