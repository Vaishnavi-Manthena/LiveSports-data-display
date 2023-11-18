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
import com.example.sportsdata.controller.MatchesController;
import com.example.sportsdata.model.Match;

import java.util.List;

public class TomorrowFragment extends Fragment {

    private RecyclerView recyclerView;
    private MatchesAdapter matchesAdapter;

    public static TomorrowFragment newInstance() {
        return new TomorrowFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tomorrow, container, false);
        recyclerView = view.findViewById(R.id.tomorrowRecyclerView);
        // Set up RecyclerView and adapter
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        matchesAdapter = new MatchesAdapter();
        recyclerView.setAdapter(matchesAdapter);
        // Fetch and display tomorrow's matches (you'll need to implement this logic)
        fetchTomorrowMatches();
        return view;
    }

    private void fetchTomorrowMatches() {
        // Implement logic to fetch tomorrow's matches from API and update the adapter
        // You can use the MatchesController to handle API calls and update the model
        // For example:
        MatchesController.getInstance().getTomorrowMatches(new MatchesController.MatchesCallback() {
          @Override
            public void onMatchesLoaded(List<Match> tomorrowMatches) {
                matchesAdapter.setMatches(tomorrowMatches);
            }
        });
    }
}
