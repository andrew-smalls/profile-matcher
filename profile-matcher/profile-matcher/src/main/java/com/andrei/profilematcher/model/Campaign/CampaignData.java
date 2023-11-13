package com.andrei.profilematcher.model.Campaign;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class CampaignData {

    @JsonProperty("game")
    private String game;

    @JsonProperty("name")
    private String name;

    @JsonProperty("priority")
    private double priority;

    @JsonProperty("matchers")
    private Matchers matchers;

    @JsonProperty("start_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ssX")
    private Date startDate;

    @JsonProperty("end_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ssX")
    private Date endDate;

    @JsonProperty("enabled")
    private boolean enabled;

    @JsonProperty("last_updated")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ssX")
    private Date lastUpdated;

    public String getName() {
        return name;
    }

    public Matchers getMatchers() {
        return matchers;
    }
}
