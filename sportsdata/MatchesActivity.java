package com.example.sportsdata;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.sportsdata.adapter.ViewPagerAdapter;
import com.example.sportsdata.fragments.InPlayFragment;
import com.example.sportsdata.fragments.TodayFragment;
import com.example.sportsdata.fragments.TomorrowFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MatchesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matches);

        ViewPager2 viewPager = findViewById(R.id.viewPager);
        setupViewPager(viewPager);

        TabLayout tabLayout = findViewById(R.id.tabLayout);

        // Use TabLayoutMediator to connect TabLayout with ViewPager2
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText(getPageTitle(position))
        ).attach();
    }

    private void setupViewPager(ViewPager2 viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        adapter.addFragment(InPlayFragment.newInstance(), "In Play");
        adapter.addFragment(TodayFragment.newInstance(), "Today");
        adapter.addFragment(TomorrowFragment.newInstance(), "Tomorrow");
        viewPager.setAdapter(adapter);
    }
}




