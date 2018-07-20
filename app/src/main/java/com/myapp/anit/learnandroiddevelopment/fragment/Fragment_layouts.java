package com.myapp.anit.learnandroiddevelopment.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myapp.anit.learnandroiddevelopment.R;
import com.myapp.anit.learnandroiddevelopment.activity.TextActivity;
import com.myapp.anit.learnandroiddevelopment.adapter.UIAdapter;
import com.myapp.anit.learnandroiddevelopment.model.UIWidgets;

import java.util.ArrayList;

public class Fragment_layouts extends Fragment {
    UIAdapter adapter;
    ArrayList<UIWidgets> data;
    View view;
    RecyclerView recyclerViewLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_layout,container,false);

        recyclerViewLayout= (RecyclerView) view.findViewById(R.id.recycler_view_layout);
        data = new ArrayList<>();
        data.add(new UIWidgets("ConstrainLayout",R.mipmap.ic_launcher));
        data.add(new UIWidgets("LinearLayout",R.mipmap.ic_launcher));
        data.add(new UIWidgets("TableLayout",R.mipmap.ic_launcher));
        data.add(new UIWidgets("FrameLayout",R.mipmap.ic_launcher));
        data.add(new UIWidgets("AppBarLayout",R.mipmap.ic_launcher));
        data.add(new UIWidgets("TabLayout",R.mipmap.ic_launcher));

        adapter = new UIAdapter(getActivity(),data);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerViewLayout.setLayoutManager(layoutManager);


        recyclerViewLayout.setAdapter(adapter);

        adapter.setOnItemClickedListener(new UIAdapter.OnItemClickedListener() {
            @Override
            public void onItemClick(String name) {

            }
        });

        return view;
    }
}
