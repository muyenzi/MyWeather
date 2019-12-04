package com.moringaschool.myweather;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TimeFragment extends Fragment {

    RecyclerView recyclerView_time;

    static TimeFragment instance;

    public static TimeFragment getInstance(){

        if (instance == null)
            instance = new TimeFragment();
        return instance;
    }


    public TimeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView = inflater.inflate(R.layout.fragment_forecast, container, false);

        recyclerView_time = (RecyclerView) itemView.findViewById(R.id.recycler_time);
        recyclerView_time.setHasFixedSize(true);
        recyclerView_time.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));

        return itemView;
    }

}
