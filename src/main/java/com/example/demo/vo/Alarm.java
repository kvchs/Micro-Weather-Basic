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
        "alarm_type",
        "alarm_level",
        "alarm_content"
})
public class Alarm {

    @JsonProperty("alarm_type")
    private String alarmType;
    @JsonProperty("alarm_level")
    private String alarmLevel;
    @JsonProperty("alarm_content")
    private String alarmContent;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("alarm_type")
    public String getAlarmType() {
        return alarmType;
    }

    @JsonProperty("alarm_type")
    public void setAlarmType(String alarmType) {
        this.alarmType = alarmType;
    }

    @JsonProperty("alarm_level")
    public String getAlarmLevel() {
        return alarmLevel;
    }

    @JsonProperty("alarm_level")
    public void setAlarmLevel(String alarmLevel) {
        this.alarmLevel = alarmLevel;
    }

    @JsonProperty("alarm_content")
    public String getAlarmContent() {
        return alarmContent;
    }

    @JsonProperty("alarm_content")
    public void setAlarmContent(String alarmContent) {
        this.alarmContent = alarmContent;
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