package com.example.sportsdata.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sportsdata.R;
import com.example.sportsdata.adapter.MatchesAdapter;


import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.fragment.app.Fragment;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;
        import java.util.List;

public class InPlayFragment extends Fragment {

    private RecyclerView recyclerView;
    private MatchesAdapter matchesAdapter;

    public static InPlayFragment newInstance() {
        return new InPlayFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_in_play, container, false);
        recyclerView = view.findViewById(R.id.inPlayRecyclerView);
        // Set up RecyclerView and adapter
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        matchesAdapter = new MatchesAdapter();
        recyclerView.setAdapter(matchesAdapter);
        // Fetch and display in-play matches (you'll need to implement this logic)
        fetchInPlayMatches();
        return view;
    }

    private void fetchInPlayMatches() {
        // Implement logic to fetch in-play matches from API and update the adapter
        // You can use the MatchesController to handle API calls and update the model
        // For example:
        // MatchesController.getInstance().getInPlayMatches(new MatchesController.MatchesCallback() {
        //     @Override
        //     public void onMatchesLoaded(List<Match> inPlayMatches) {
        //         matchesAdapter.setMatches(inPlayMatches);
        //     }
        // });
    }
}
