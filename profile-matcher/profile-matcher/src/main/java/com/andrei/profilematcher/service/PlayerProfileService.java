package com.andrei.profilematcher.service;

import com.andrei.profilematcher.model.Player.PlayerProfile;
import com.andrei.profilematcher.repository.PlayerProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerProfileService {

    private final PlayerProfileRepository playerProfileRepository;
    public PlayerProfileService(PlayerProfileRepository playerProfileRepository) {
        this.playerProfileRepository = playerProfileRepository;
    }

    public void updatePlayerProfile(PlayerProfile playerProfile, String campaignName) {
        List<String> activePlayerCompaigns = playerProfile.getActiveCampaigns();
        if (!activePlayerCompaigns.contains(campaignName)) {
            activePlayerCompaigns.add(campaignName);
        }
        playerProfile.setActiveCampaigns(activePlayerCompaigns);
        playerProfileRepository.save(playerProfile);
    }
}
