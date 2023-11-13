package com.andrei.profilematcher.model.Player;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Entity
public class PlayerProfile {

    @Id
    @Column(name = "player_id", nullable = false, unique = true)
    @JsonProperty("player_id")
    private String playerId;

    @JsonProperty("credential")
    private String credential;

    @JsonProperty("created")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ssX")
    private Date created;

    @JsonProperty("modified")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ssX")
    private Date modified;

    @Column(name = "last_session")
    @JsonProperty("last_session")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ssX")
    private Date lastSession;

    @Column(name = "total_spent")
    @JsonProperty("total_spent")
    private int totalSpent;

    @Column(name = "total_refund")
    @JsonProperty("total_refund")
    private int totalRefund;

    @Column(name = "total_transactions")
    @JsonProperty("total_transactions")
    private int totalTransactions;

    @Column(name = "last_purchase")
    @JsonProperty("last_purchase")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ssX")
    private Date lastPurchase;

    @ElementCollection(fetch = FetchType.EAGER)
    @JsonProperty("active_campaigns")
    private List<String> activeCampaigns;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "player_profile_id")
    @JsonProperty("devices")
    private List<Device> devices;
    @JsonProperty("level")
    private int level;

    @JsonProperty("xp")
    private int xp;

    @Column(name = "total_playtime")
    @JsonProperty("total_playtime")
    private int totalPlaytime;

    @JsonProperty("country")
    private String country;

    @JsonProperty("language")
    private String language;

    @JsonProperty("birthdate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ssX")
    private Date birthdate;

    @JsonProperty("gender")
    private String gender;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "inventory")
    @MapKeyColumn(name = "item_name")
    @JsonProperty("inventory")
    private Map<String, Integer> inventory;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "clan_id")
    @JsonProperty("clan")
    private Clan clan;

    @Column(name = "_customfield")
    @JsonProperty("_customfield")
    private String customField;

    public List<Device> getDevices() {
        return devices;
    }

    public List<String> getActiveCampaigns() {
        return activeCampaigns;
    }

    public void setActiveCampaigns(List<String> activeCampaigns) {
        this.activeCampaigns = activeCampaigns;
    }

    public int getLevel() {
        return level;
    }

    public String getCountry() {
        return country;
    }

    public Map<String, Integer> getInventory() {
        return inventory;
    }
}