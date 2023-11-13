package com.andrei.profilematcher.model.Player;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
class Device {

    @Id
    @JsonProperty("id")
    private Long id;
    @JsonProperty("model")
    private String model;
    @JsonProperty("carrier")
    private String carrier;
    @JsonProperty("firmware")
    private String firmware;

}