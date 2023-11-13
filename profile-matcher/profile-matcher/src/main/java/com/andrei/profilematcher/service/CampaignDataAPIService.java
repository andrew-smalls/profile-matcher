package com.andrei.profilematcher.service;

import com.andrei.profilematcher.model.Campaign.CampaignData;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CampaignDataAPIService {

    private final JsonReaderService jsonReaderService;
    public CampaignDataAPIService(JsonReaderService jsonReaderService) {
        this.jsonReaderService = jsonReaderService;
    }

    public CampaignData getCurrentCampaignData() throws Exception {
        Optional<CampaignData> campaignDataOptional = jsonReaderService.mapCampaignDataFromJson();
        return campaignDataOptional.orElseThrow(() -> new Exception("No campaign data found."));
    }
}
