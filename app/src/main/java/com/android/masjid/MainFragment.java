package com.android.masjid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hanani on 2/3/2016.
 */
public class MainFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private List<Event> events;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static MainFragment newInstance(int sectionNumber) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_main, null);

        RecyclerView mRecyclerView = (RecyclerView) root.findViewById(R.id.recyclerView);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        initializeData();

        // specify an adapter (see also next example)
        EventAdapter mAdapter = new EventAdapter(events);
        mRecyclerView.setAdapter(mAdapter);

        return root;
    }

    private void initializeData(){
        events = new ArrayList<>();
        events.add(new Event("Ceramah Bulanan", "7 March 2016"));
        events.add(new Event("Kuliah Maghrib", "10 March 2016"));
        events.add(new Event("Akad Nikah Hanani & Faris", "19 March 2016"));
        events.add(new Event("Ceramah Bulanan", "1 April 2016"));
    }
}
