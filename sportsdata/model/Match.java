package com.example.sportsdata.model;

import com.google.gson.annotations.SerializedName;

public class Match {

    @SerializedName("event_name")
    private String eventName;

    @SerializedName("sport_id")
    private int sportId;

    // Add other fields as needed

    public String getEventName() {
        return eventName;
    }

    public int getSportId() {
        return sportId;
    }

    // Add getters for other fields
}

