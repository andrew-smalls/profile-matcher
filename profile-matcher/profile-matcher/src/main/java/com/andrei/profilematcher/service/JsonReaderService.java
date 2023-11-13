package com.andrei.profilematcher.service;

import com.andrei.profilematcher.model.Campaign.CampaignData;
import com.andrei.profilematcher.model.Player.PlayerProfile;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Service
public class JsonReaderService {
    Logger logger = LoggerFactory.getLogger(JsonReaderService.class);

    public Optional<PlayerProfile> mapPlayerProfileFromJson() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            PlayerProfile playerProfile = objectMapper.readValue(
                    new File("profile-matcher/profile-matcher/src/main/resources/player_profile.json"),
                    PlayerProfile.class
            );

            return Optional.of(playerProfile);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }

        return Optional.empty();
    }

    public Optional<CampaignData> mapCampaignDataFromJson() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            CampaignData campaignData = objectMapper.readValue(
                    new File("profile-matcher/profile-matcher/src/main/resources/campaign_data.json"),
                    CampaignData.class
            );

            return Optional.of(campaignData);
        } catch (IOException e) {
            logger.error(e.getMessage());
        }

        return Optional.empty();
    }

}
