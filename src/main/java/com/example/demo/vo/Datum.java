package com.example.demo.vo;

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
        "day",
        "date",
        "week",
        "wea",
        "wea_img",
        "air",
        "humidity",
        "air_level",
        "air_tips",
        "alarm",
        "tem1",
        "tem2",
        "tem",
        "win",
        "win_speed",
        "hours",
        "index"
})
public class Datum {

    @JsonProperty("day")
    private String day;
    @JsonProperty("date")
    private String date;
    @JsonProperty("week")
    private String week;
    @JsonProperty("wea")
    private String wea;
    @JsonProperty("wea_img")
    private String weaImg;
    @JsonProperty("air")
    private Integer air;
    @JsonProperty("humidity")
    private Integer humidity;
    @JsonProperty("air_level")
    private String airLevel;
    @JsonProperty("air_tips")
    private String airTips;
    @JsonProperty("alarm")
    private Alarm alarm;
    @JsonProperty("tem1")
    private String tem1;
    @JsonProperty("tem2")
    private String tem2;
    @JsonProperty("tem")
    private String tem;
    @JsonProperty("win")
    private List<String> win = null;
    @JsonProperty("win_speed")
    private String winSpeed;
    @JsonProperty("hours")
    private List<Hour> hours = null;
    @JsonProperty("index")
    private List<Index> index = null;
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

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("week")
    public String getWeek() {
        return week;
    }

    @JsonProperty("week")
    public void setWeek(String week) {
        this.week = week;
    }

    @JsonProperty("wea")
    public String getWea() {
        return wea;
    }

    @JsonProperty("wea")
    public void setWea(String wea) {
        this.wea = wea;
    }

    @JsonProperty("wea_img")
    public String getWeaImg() {
        return weaImg;
    }

    @JsonProperty("wea_img")
    public void setWeaImg(String weaImg) {
        this.weaImg = weaImg;
    }

    @JsonProperty("air")
    public Integer getAir() {
        return air;
    }

    @JsonProperty("air")
    public void setAir(Integer air) {
        this.air = air;
    }

    @JsonProperty("humidity")
    public Integer getHumidity() {
        return humidity;
    }

    @JsonProperty("humidity")
    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    @JsonProperty("air_level")
    public String getAirLevel() {
        return airLevel;
    }

    @JsonProperty("air_level")
    public void setAirLevel(String airLevel) {
        this.airLevel = airLevel;
    }

    @JsonProperty("air_tips")
    public String getAirTips() {
        return airTips;
    }

    @JsonProperty("air_tips")
    public void setAirTips(String airTips) {
        this.airTips = airTips;
    }

    @JsonProperty("alarm")
    public Alarm getAlarm() {
        return alarm;
    }

    @JsonProperty("alarm")
    public void setAlarm(Alarm alarm) {
        this.alarm = alarm;
    }

    @JsonProperty("tem1")
    public String getTem1() {
        return tem1;
    }

    @JsonProperty("tem1")
    public void setTem1(String tem1) {
        this.tem1 = tem1;
    }

    @JsonProperty("tem2")
    public String getTem2() {
        return tem2;
    }

    @JsonProperty("tem2")
    public void setTem2(String tem2) {
        this.tem2 = tem2;
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
    public List<String> getWin() {
        return win;
    }

    @JsonProperty("win")
    public void setWin(List<String> win) {
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

    @JsonProperty("hours")
    public List<Hour> getHours() {
        return hours;
    }

    @JsonProperty("hours")
    public void setHours(List<Hour> hours) {
        this.hours = hours;
    }

    @JsonProperty("index")
    public List<Index> getIndex() {
        return index;
    }

    @JsonProperty("index")
    public void setIndex(List<Index> index) {
        this.index = index;
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