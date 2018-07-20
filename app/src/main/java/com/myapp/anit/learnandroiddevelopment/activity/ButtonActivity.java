package com.myapp.anit.learnandroiddevelopment.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.myapp.anit.learnandroiddevelopment.R;

public class ButtonActivity extends AppCompatActivity {
    LinearLayout linearLayoutRoot;
    Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createLinearLayoutView();
        setContentView(linearLayoutRoot);

        //back button
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        init();
        setEvents();

    }

    private void createLinearLayoutView() {
        linearLayoutRoot = new LinearLayout(this);
        linearLayoutRoot.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        linearLayoutRoot.setOrientation(LinearLayout.VERTICAL);
    }

    private void setEvents() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ButtonActivity.this, "you clicked button", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void init() {
        button = new Button(this);
        button.setText("Click me");
        linearLayoutRoot.addView(button);
    }

   

    
}
