package com.example.sportsdata.api;

import com.example.sportsdata.model.Match;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("getLiveMatches")
    Call<List<Match>> getLiveMatches();

    @GET("getTodayMatches")
    Call<List<Match>> getTodayMatches();

    @GET("getTomorrowMatches")
    Call<List<Match>> getTomorrowMatches();

    // Add additional methods for other API endpoints

    // Example:
    // @GET("getUpcomingMatches")
    // Call<List<Match>> getUpcomingMatches();
}
