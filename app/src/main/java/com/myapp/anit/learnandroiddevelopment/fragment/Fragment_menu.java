package com.myapp.anit.learnandroiddevelopment.fragment;

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
import com.myapp.anit.learnandroiddevelopment.adapter.UIAdapter;
import com.myapp.anit.learnandroiddevelopment.model.UIWidgets;

import java.util.ArrayList;

public class Fragment_menu extends Fragment {
    UIAdapter UIAdapter;
    ArrayList<UIWidgets> list = new ArrayList<>();
    View view;
    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_menu,container,false);
        list.add(new UIWidgets("Option Menu",R.drawable.textview));
        list.add(new UIWidgets("Context Menu",R.drawable.info_50));
        list.add(new UIWidgets("Popup Menu",R.drawable.info_50));

        UIAdapter = new UIAdapter(getActivity(),list);
        recyclerView= (RecyclerView) view.findViewById(R.id.recycler_view_menu);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(UIAdapter);
        return view;
    }
}
