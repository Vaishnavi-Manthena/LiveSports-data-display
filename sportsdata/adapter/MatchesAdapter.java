package com.example.sportsdata.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sportsdata.R;
import com.example.sportsdata.model.Match;

import java.util.List;

    public class MatchesAdapter extends RecyclerView.Adapter<MatchesAdapter.MatchViewHolder> {

        private List<Match> matches;

        public MatchesAdapter(List<Match> matches) {
            this.matches = matches;
        }

        @NonNull
        @Override
        public MatchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.match_item, parent, false);
            return new MatchViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MatchViewHolder holder, int position) {
            Match match = matches.get(position);
            holder.bind(match);
        }

        @Override
        public int getItemCount() {
            return matches.size();
        }

        static class MatchViewHolder extends RecyclerView.ViewHolder {

            private TextView eventNameTextView;
            private TextView sportIdTextView;

            public MatchViewHolder(@NonNull View itemView) {
                super(itemView);
                eventNameTextView = itemView.findViewById(R.id.eventNameTextView);
                sportIdTextView = itemView.findViewById(R.id.sportIdTextView);
            }

            public void bind(Match match) {
                eventNameTextView.setText("Event: " + match.getEventName());
                sportIdTextView.setText("Sport ID: " + match.getSportId());
                // Add bindings for other fields as needed
            }
        }
    }


