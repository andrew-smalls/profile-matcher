package com.andrei.profilematcher;

import com.andrei.profilematcher.model.Player.PlayerProfile;
import com.andrei.profilematcher.repository.PlayerProfileRepository;
import com.andrei.profilematcher.service.JsonReaderService;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Optional;

/* Purpose of this class is to read the provided JSON, stored in a local file,
   map the JSON data to a PlayerProfile object and store the object in the H2 db.
   This triggers automatically on application start.
* */
@Component
public class StartupInitializer {

    private final JsonReaderService jsonReaderService;

    private final PlayerProfileRepository playerProfileRepository;

    public StartupInitializer(JsonReaderService jsonReaderService, PlayerProfileRepository playerProfileRepository) {
        this.jsonReaderService = jsonReaderService;
        this.playerProfileRepository = playerProfileRepository;
    }

    Logger logger = LoggerFactory.getLogger(StartupInitializer.class);
    @PostConstruct
    public void processPlayerProfileOnStartup() throws Exception {
        Optional<PlayerProfile> playerProfileOptional = jsonReaderService.mapPlayerProfileFromJson();
        if (playerProfileOptional.isPresent()) {
            try {
                playerProfileRepository.save(playerProfileOptional.get());
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        } else {
            throw new Exception("Could not map Player Profile.");
        }
    }
}