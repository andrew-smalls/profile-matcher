package com.andrei.profilematcher.model.Campaign;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LevelMatcher {

    @JsonProperty("min")
    private int min;

    @JsonProperty("max")
    private int max;

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}
