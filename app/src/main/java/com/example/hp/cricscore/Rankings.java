package com.example.hp.cricscore;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.Toolbar;

/**
 * A simple {@link Fragment} subclass.
 */
public class Rankings extends Fragment {
    public Rankings() { }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_rankings, container, false);
        final TabLayout tablayout= (TabLayout) v.findViewById(R.id.tabLayout);
        //final ViewPager viewPager=(ViewPager)v.findViewById(R.id.viewPager);
        Toolbar toolbar = (Toolbar)v. findViewById(R.id.toolbar);
        tablayout.addTab(tablayout.newTab().setText("TEST"));
        tablayout.addTab(tablayout.newTab().setText("ODI"));
        tablayout.addTab(tablayout.newTab().setText("T20"));
        tablayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //Initializing viewPager
       final ViewPager viewPager = (ViewPager)v. findViewById(R.id.pager);

        //Creating our pager adapter
       // Pager adapter = new Pager(getChildFragmentManager(), tablayout.getTabCount());

        //Adding adapter to pager
        //viewPager.setAdapter(adapter);

        //Adding onTabSelectedListener to swipe views
        //tablayout.setOnTabSelectedListener((TabLayout.BaseOnTabSelectedListener) this);
        //   tablayout.setOnTabSelectedListener();
        viewPager.setAdapter(new PagerAdapter
                (getFragmentManager(), tablayout.getTabCount()));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));
        tablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
            
            
            
        });
        return v;
    }

}
