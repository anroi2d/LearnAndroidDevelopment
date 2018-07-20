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

public class Fragment_widgets extends Fragment {
    UIAdapter adapter;
    ArrayList<UIWidgets> data;
    View view;
    RecyclerView recyclerViewWidget;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_widget,container,false);

        recyclerViewWidget= (RecyclerView) view.findViewById(R.id.recycler_view_widget);
        data = new ArrayList<>();
        data.add(new UIWidgets("ImageView",R.mipmap.ic_launcher));
//        data.add(new UIWidgets("VideoView",R.mipmap.ic_launcher));
        data.add(new UIWidgets("WebView",R.mipmap.ic_launcher));
        data.add(new UIWidgets("ProgressBar co 2 loai",R.mipmap.ic_launcher));
        data.add(new UIWidgets("SeekBar co 2 loai",R.mipmap.ic_launcher));
        data.add(new UIWidgets("RatingBar",R.mipmap.ic_launcher));
        data.add(new UIWidgets("SearchView",R.mipmap.ic_launcher));
        adapter = new UIAdapter(getActivity(),data);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerViewWidget.setLayoutManager(layoutManager);


        recyclerViewWidget.setAdapter(adapter);

        adapter.setOnItemClickedListener(new UIAdapter.OnItemClickedListener() {
            @Override
            public void onItemClick(String name) {
                switch (name){
                    case "ImageView":
                        Intent intentTextview = new Intent(getActivity(), TextActivity.class);
                        intentTextview.putExtra("tv",name);
                        startActivity(intentTextview);
                        break;
                }
            }
        });

        return view;
    }
}
