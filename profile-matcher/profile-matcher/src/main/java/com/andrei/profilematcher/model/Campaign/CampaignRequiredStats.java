package com.andrei.profilematcher.model.Campaign;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;

import java.util.List;

public class CampaignRequiredStats {
    @ElementCollection
    @CollectionTable(name = "country")
    @JsonProperty("country")
    private List<String> countries;

    @ElementCollection
    @CollectionTable(name = "items")
    @JsonProperty("items")
    private List<String> items;

    public List<String> getCountries() {
        return countries;
    }

    public List<String> getItems() {
        return items;
    }
}
