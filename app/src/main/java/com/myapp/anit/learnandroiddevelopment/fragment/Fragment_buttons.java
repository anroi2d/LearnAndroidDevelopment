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
import com.myapp.anit.learnandroiddevelopment.activity.ButtonActivity;
import com.myapp.anit.learnandroiddevelopment.activity.CheckBoxActivity;
import com.myapp.anit.learnandroiddevelopment.activity.ImageButtonActivity;
import com.myapp.anit.learnandroiddevelopment.activity.RadioActivity;
import com.myapp.anit.learnandroiddevelopment.activity.SwitchActivity;
import com.myapp.anit.learnandroiddevelopment.activity.ToggleActivity;
import com.myapp.anit.learnandroiddevelopment.adapter.UIAdapter;
import com.myapp.anit.learnandroiddevelopment.model.UIWidgets;

import java.util.ArrayList;

public class Fragment_buttons extends Fragment {
    UIAdapter UIAdapter;
    RecyclerView recyclerView;
    ArrayList<UIWidgets> list;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_buttons,container,false);
        recyclerView= (RecyclerView) view.findViewById(R.id.recycler_view_view);
        list = new ArrayList<>();
        list.add(new UIWidgets("Button",R.mipmap.ic_launcher));
        list.add(new UIWidgets("Image Button",R.mipmap.ic_launcher));
        list.add(new UIWidgets("Checkbox",R.mipmap.ic_launcher));
        list.add(new UIWidgets("RadioGroup & RadioButton",R.mipmap.ic_launcher));
        list.add(new UIWidgets("Toggle Button",R.mipmap.ic_launcher));
        list.add(new UIWidgets("Switch",R.mipmap.ic_launcher));

        UIAdapter = new UIAdapter(getActivity(),list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(UIAdapter);

        UIAdapter.setOnItemClickedListener(new UIAdapter.OnItemClickedListener() {
            @Override
            public void onItemClick(String name) {
                switch (name){
                    case "Button":
                        Intent intentTextview = new Intent(getActivity(), ButtonActivity.class);
                        intentTextview.putExtra("btn",name);
                        startActivity(intentTextview);
                        break;
                    case "Image Button":
                        Intent intentImageButton = new Intent(getActivity(), ImageButtonActivity.class);
                        intentImageButton.putExtra("btn",name);
                        startActivity(intentImageButton);
                        break;
                    case "Checkbox":
                        Intent intentcheckBox = new Intent(getActivity(), CheckBoxActivity.class);
                        startActivity(intentcheckBox);
                        break;
                    case "RadioGroup & RadioButton":
                        Intent intentRadio = new Intent(getActivity(), RadioActivity.class);
                        startActivity(intentRadio);
                        break;
                    case "Toggle Button":
                        Intent intentToggle = new Intent(getActivity(), ToggleActivity.class);
                        startActivity(intentToggle);
                        break;
                    case "Switch":
                        Intent intentSwitch = new Intent(getActivity(), SwitchActivity.class);
                        startActivity(intentSwitch);
                        break;

                }

            }
        });

        return view;
    }
}
