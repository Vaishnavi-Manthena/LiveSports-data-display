package com.example.sportsdata.controller;

import com.example.sportsdata.api.ApiService;
import com.example.sportsdata.model.Match;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MatchesController {

    private ApiService apiService;

    public MatchesController(ApiService apiService) {
        this.apiService = apiService;
    }

    public void getInPlayMatches(final OnMatchesLoadedListener listener) {
        Call<List<Match>> call = apiService.getLiveMatches();
        call.enqueue(new Callback<List<Match>>() {
            @Override
            public void onResponse(Call<List<Match>> call, Response<List<Match>> response) {
                if (response.isSuccessful()) {
                    List<Match> inPlayMatches = response.body();
                    // You can perform additional processing here if needed
                    listener.onMatchesLoaded(inPlayMatches);
                } else {
                    listener.onMatchesLoadError("Failed to fetch in-play matches: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Match>> call, Throwable t) {
                listener.onMatchesLoadError("Error fetching in-play matches: " + t.getMessage());
            }
        });
    }

    // Similar methods for getting today's and tomorrow's matches
    // You can create separate methods for each type of match

    public interface OnMatchesLoadedListener {
        void onMatchesLoaded(List<Match> matches);

        void onMatchesLoadError(String errorMessage);
    }
}
