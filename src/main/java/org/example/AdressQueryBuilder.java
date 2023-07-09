package org.example;
import java.util.List;

public class AdressQueryBuilder {
    private Integer _id;
    private String _url;
    private String _type;
    private String _desc;
    private String _source;
    private String _date;
    private Integer _criticalityLevel;
    private String _connectionType;

    public AdressQueryBuilder() {
    }



    public List<Address> get(){
        //TODO
        return null;
    }

    public AdressQueryBuilder url(String _url) {
        this._url = _url;
        return this;
    }

    public AdressQueryBuilder type(String _type) {
        this._type = _type;
        return this;
    }

    public AdressQueryBuilder desc(String _desc) {
        this._desc = _desc;
        return this;
    }

    public AdressQueryBuilder source(String _source) {
        this._source = _source;
        return this;
    }

    public AdressQueryBuilder date(String _date) {
        this._date = _date;
        return this;
    }

    public AdressQueryBuilder criticality_level(Integer _criticality_level) {
        this._criticalityLevel = _criticality_level;
        return this;
    }

    public AdressQueryBuilder connectiontype(String _connectiontype) {
        this._connectionType = _connectiontype;
        return this;
    }
}

/*
    public void Search() {
        // Adres sorgusu oluşturma
        AdressQueryBuilder builder = new AdressQueryBuilder();
        AdressQuery query = builder
                .type("domain")
                .source("IH")
                .url("t-teknosa.com")
                .build();

        List<Address> addresses = AdressQueryBuilder.searchAddresses("domain", "t-teknosa.com", query, "API Query");



        // Arama sonuçlarını konsola yazdırma
        if (addresses != null && addresses.size() > 0) {
            System.out.println("Arama sonuçları:");
            for (Address address : addresses) {
                System.out.println("Arama sonucu : " + address);
            }
        } else {
            System.out.println("Arama sonucu bulunamadı.");
        }
    }
    */