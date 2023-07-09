package org.example;

import java.util.List;

public class USOMApi {

    public USOMApi() {
        this.apiUrl = "https://www.usom.gov.tr/api/";
    }

    public USOMApi(String apiUrl) {
        this.apiUrl = apiUrl;
    }
    private String apiUrl;
    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }


}
