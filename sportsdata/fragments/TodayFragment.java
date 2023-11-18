package com.example.sportsdata.fragments;


import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.fragment.app.Fragment;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

import com.example.sportsdata.adapter.MatchesAdapter;
import com.example.sportsdata.api.ApiClient;
import com.example.sportsdata.api.ApiService;
import com.example.sportsdata.controller.MatchesController;
import com.example.sportsdata.model.Match;

import java.util.List;

public class TodayFragment extends Fragment {

    private RecyclerView recyclerView;
    private MatchesAdapter matchesAdapter;

    public static TodayFragment newInstance() {
        return new TodayFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_today, container, false);
        recyclerView = view.findViewById(R.id.todayRecyclerView);
        // Set up RecyclerView and adapter
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        matchesAdapter = new MatchesAdapter();
        recyclerView.setAdapter(matchesAdapter);
        // Fetch and display today's matches (you'll need to implement this logic)
        fetchTodayMatches();
        return view;
    }

    private void fetchTodayMatches() {
        // Implement logic to fetch today's matches from API and update the adapter
        // You can use the MatchesController to handle API calls and update the model
        // For example:
        MatchesController matchesController = new MatchesController(ApiClient.getInstance().create(ApiService.class));

        matchesController.getTodayMatches(new MatchesController.OnMatchesLoadedListener() {
            @Override
            public void onMatchesLoaded(List<Match> todayMatches) {
                matchesAdapter.setMatches(todayMatches);
            }

            @Override
            public void onMatchesLoadError(String errorMessage) {
                // Handle error loading today's matches
                Toast.makeText(getContext(), errorMessage, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
