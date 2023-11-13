package com.andrei.profilematcher.controller;

import com.andrei.profilematcher.model.Player.PlayerProfile;
import com.andrei.profilematcher.service.ProfileMatcherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ClientController {

    private final ProfileMatcherService profileMatcherService;

    public ClientController(ProfileMatcherService profileMatcherService) {
        this.profileMatcherService = profileMatcherService;
    }

    @GetMapping("/")
    public String home(){
        return "Hello World!";
    }

    @GetMapping("/get_client_config/{player_id}")
    public ResponseEntity<PlayerProfile> getClientConfig(@PathVariable String player_id) throws Exception {
        Optional<PlayerProfile> updatedProfileOpt = profileMatcherService.matchProfile(player_id);
        return updatedProfileOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
