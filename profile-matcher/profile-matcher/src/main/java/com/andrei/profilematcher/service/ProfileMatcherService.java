package com.andrei.profilematcher.service;

import com.andrei.profilematcher.model.Campaign.CampaignData;
import com.andrei.profilematcher.model.Campaign.CampaignNonpermittedStats;
import com.andrei.profilematcher.model.Campaign.CampaignRequiredStats;
import com.andrei.profilematcher.model.Campaign.LevelMatcher;
import com.andrei.profilematcher.model.Campaign.Matchers;
import com.andrei.profilematcher.model.Player.PlayerProfile;
import com.andrei.profilematcher.repository.PlayerProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Service
public class ProfileMatcherService {
    private final PlayerProfileRepository playerProfileRepository;
    private final CampaignDataAPIService campaignDataAPIService;
    private final PlayerProfileService playerProfileService;
    public ProfileMatcherService(
            PlayerProfileRepository playerProfileRepository,
            CampaignDataAPIService campaignDataAPIService,
            PlayerProfileService playerProfileService
    ) {
        this.playerProfileRepository = playerProfileRepository;
        this.campaignDataAPIService = campaignDataAPIService;
        this.playerProfileService = playerProfileService;
    }

    public Optional<PlayerProfile> matchProfile(String playerId) throws Exception {
        // Retrieve player profile from the database (should be stored)
        PlayerProfile playerProfile = playerProfileRepository.findByPlayerId(playerId);

        if (playerProfile == null) {
            throw new Exception("Could not find this player in the db. (IMPOSSIBLE)");
        }

        // Mock API Service to get current campaign data
        CampaignData currentCampaign = campaignDataAPIService.getCurrentCampaignData();

        // Check match between campaign data and player profile
        if (!playerProfileMatchesWithCampaign(playerProfile, currentCampaign)) {
            return Optional.empty();
        }

        // In case of match, update player profile and return updated profile to client
        playerProfileService.updatePlayerProfile(playerProfile, currentCampaign.getName());
        return Optional.of(playerProfile);
    }
    /* This method works assuming the player is required to have "any" match between profile and campaign requirements.
     * */
    private boolean playerProfileMatchesWithCampaign(PlayerProfile playerProfile, CampaignData currentCampaign) {
        Matchers campaignMatchers = currentCampaign.getMatchers();
        return checkLevelMatch(campaignMatchers.getLevelMatcher(), playerProfile)
                || checkOtherMatchCriteria(campaignMatchers.getCampaignRequiredStats(), playerProfile)
                || checkNonMatchCriteria(campaignMatchers.getCampaignNonpermittedStats(), playerProfile);
    }

    private boolean checkLevelMatch(LevelMatcher levelMatcher, PlayerProfile playerProfile) {
        int playerLevel = playerProfile.getLevel();
        return playerLevel >= levelMatcher.getMin() && playerLevel <= levelMatcher.getMax();
    }

    /* This method works assuming the player is required to have either the correct items or the correct country.
    * */
    private boolean checkOtherMatchCriteria(CampaignRequiredStats campaignRequiredStats, PlayerProfile playerProfile) {
        return checkCountryMatch(campaignRequiredStats.getCountries(), playerProfile.getCountry())
                || checkItemsMatch(campaignRequiredStats.getItems(), playerProfile.getInventory());
    }

    /* This method works assuming the player is required to have all the items mentioned
        in the campaign "matchers.has.items" object.
    * */
    private boolean checkItemsMatch(List<String> campaignRequiredItems, Map<String, Integer> playerInventory) {
        Set<String> playerItems = playerInventory.keySet();
        return playerItems.containsAll(campaignRequiredItems);
    }

    private boolean checkCountryMatch(List<String> campaignRequiredCountries, String playerCountry) {
        return campaignRequiredCountries.contains(playerCountry);
    }

    /* This method works by checking if there exists any intersection between campaign non permitted items (does_not_have)
        and the items of the player.
    * */
    private boolean checkNonMatchCriteria(CampaignNonpermittedStats campaignNonpermittedStats, PlayerProfile playerProfile) {
        return checkNonIntersection(campaignNonpermittedStats.getItems(), playerProfile.getInventory().keySet());
    }

    private boolean checkNonIntersection(List<String> campaignNonpermittedStats, Set<String> playerInventory) {
        return playerInventory.stream().noneMatch(campaignNonpermittedStats::contains);
    }
}