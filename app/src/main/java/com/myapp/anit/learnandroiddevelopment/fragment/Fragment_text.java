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

public class Fragment_text extends Fragment {
    UIAdapter UIAdapter;
    ArrayList<UIWidgets> list;
    RecyclerView recyclerView;
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_text, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_ui);

        list = new ArrayList<>();

        list.add(new UIWidgets("TextView", R.drawable.textview));
        list.add(new UIWidgets("EditText", R.mipmap.ic_launcher));

        UIAdapter = new UIAdapter(getActivity(), list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(UIAdapter);

        UIAdapter.setOnItemClickedListener(new UIAdapter.OnItemClickedListener() {
            @Override
            public void onItemClick(String name) {
                Intent intentTextview = new Intent(getActivity(), TextActivity.class);
                intentTextview.putExtra("tv",name);
                startActivity(intentTextview);
            }
        });


        return view;
    }


}
