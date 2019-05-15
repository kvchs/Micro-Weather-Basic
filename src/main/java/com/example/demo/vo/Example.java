package com.example.demo.vo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "cityid",
        "update_time",
        "city",
        "cityEn",
        "country",
        "countryEn",
        "data"
})
public class Example implements Serializable {


    private static final long serialVersionUID = -5616776144822830458L;
    @JsonProperty("cityid")
    private String cityid;
    @JsonProperty("update_time")
    private String updateTime;
    @JsonProperty("city")
    private String city;
    @JsonProperty("cityEn")
    private String cityEn;
    @JsonProperty("country")
    private String country;
    @JsonProperty("countryEn")
    private String countryEn;
    @JsonProperty("data")
    private List<Datum> data = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("cityid")
    public String getCityid() {
        return cityid;
    }

    @JsonProperty("cityid")
    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

    @JsonProperty("update_time")
    public String getUpdateTime() {
        return updateTime;
    }

    @JsonProperty("update_time")
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("cityEn")
    public String getCityEn() {
        return cityEn;
    }

    @JsonProperty("cityEn")
    public void setCityEn(String cityEn) {
        this.cityEn = cityEn;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("countryEn")
    public String getCountryEn() {
        return countryEn;
    }

    @JsonProperty("countryEn")
    public void setCountryEn(String countryEn) {
        this.countryEn = countryEn;
    }

    @JsonProperty("data")
    public List<Datum> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<Datum> data) {
        this.data = data;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

