package com.andrei.profilematcher.repository;

import com.andrei.profilematcher.model.Player.PlayerProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerProfileRepository extends JpaRepository<PlayerProfile, String> {
    PlayerProfile findByPlayerId(String playerId);
}
