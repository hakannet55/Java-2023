package org.example;

import java.util.Objects;

public class AdressQuery {
    private Integer _id;
    private String _url;
    private String _type;
    private String _desc;
    private String _source;
    private String _date;
    private Integer _criticalityLevel;
    private String _connectionType;

    public AdressQuery() {
    }

    public void Adress(Integer id, String url, String type, String desc, String source, String date, Integer criticality_level, String connectiontype) {
        this._id = id;
        this._url = url;
        this._type = type;
        this._desc = desc;
        this._source = source;
        this._date = date;
        this._criticalityLevel = criticality_level;
        this._connectionType = connectiontype;
    }

    public Integer getId() {
        return _id;
    }

    public void setId(Integer id) {
        this._id = id;
    }

    public String getUrl() {
        return _url;
    }

    public void setUrl(String url) {
        this._url = url;
    }

    public String getType() {
        return _type;
    }

    public void setType(String type) {
        this._type = type;
    }

    public String getDesc() {
        return _desc;
    }

    public void setDesc(String desc) {
        this._desc = desc;
    }

    public String getSource() {
        return _source;
    }

    public void setSource(String source) {
        this._source = source;
    }

    public String getDate() {
        return _date;
    }

    public void setDate(String date) {
        this._date = date;
    }

    public Integer getCriticality_level() {
        return _criticalityLevel;
    }

    public void setCriticality_level(Integer criticality_level) {
        this._criticalityLevel = criticality_level;
    }

    public String getConnectiontype() {
        return _connectionType;
    }

    public void setConnectiontype(String connectiontype) {
        this._connectionType = connectiontype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(getUrl(), address.getUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUrl());
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + _id +
                ", url='" + _url + '\'' +
                ", type='" + _type + '\'' +
                ", desc='" + _desc + '\'' +
                ", source='" + _source + '\'' +
                ", date='" + _date + '\'' +
                ", criticalityLevel=" + _criticalityLevel +
                ", connectionType='" + _connectionType + '\'' +
                '}';
    }
}