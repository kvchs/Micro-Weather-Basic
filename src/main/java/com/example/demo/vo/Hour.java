package com.example.demo.vo;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "day",
        "wea",
        "tem",
        "win",
        "win_speed"
})
public class Hour {

    @JsonProperty("day")
    private String day;
    @JsonProperty("wea")
    private String wea;
    @JsonProperty("tem")
    private String tem;
    @JsonProperty("win")
    private String win;
    @JsonProperty("win_speed")
    private String winSpeed;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("day")
    public String getDay() {
        return day;
    }

    @JsonProperty("day")
    public void setDay(String day) {
        this.day = day;
    }

    @JsonProperty("wea")
    public String getWea() {
        return wea;
    }

    @JsonProperty("wea")
    public void setWea(String wea) {
        this.wea = wea;
    }

    @JsonProperty("tem")
    public String getTem() {
        return tem;
    }

    @JsonProperty("tem")
    public void setTem(String tem) {
        this.tem = tem;
    }

    @JsonProperty("win")
    public String getWin() {
        return win;
    }

    @JsonProperty("win")
    public void setWin(String win) {
        this.win = win;
    }

    @JsonProperty("win_speed")
    public String getWinSpeed() {
        return winSpeed;
    }

    @JsonProperty("win_speed")
    public void setWinSpeed(String winSpeed) {
        this.winSpeed = winSpeed;
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