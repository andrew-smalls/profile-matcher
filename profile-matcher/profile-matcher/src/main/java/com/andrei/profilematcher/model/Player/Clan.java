package com.andrei.profilematcher.model.Player;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Clan {

    @Id
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;

}
