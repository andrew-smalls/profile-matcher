package com.andrei.profilematcher.model.Campaign;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Matchers {

    @JsonProperty("level")
    private LevelMatcher levelMatcher;

    @JsonProperty("has")
    private CampaignRequiredStats campaignRequiredStats;

    @JsonProperty("does_not_have")
    private CampaignNonpermittedStats campaignNonpermittedStats;

    public LevelMatcher getLevelMatcher() {
        return levelMatcher;
    }
    public CampaignRequiredStats getCampaignRequiredStats() {
        return campaignRequiredStats;
    }
    public CampaignNonpermittedStats getCampaignNonpermittedStats() {
        return campaignNonpermittedStats;
    }

}
