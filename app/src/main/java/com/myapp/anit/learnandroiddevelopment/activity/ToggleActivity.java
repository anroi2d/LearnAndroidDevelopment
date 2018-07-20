package com.myapp.anit.learnandroiddevelopment.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.myapp.anit.learnandroiddevelopment.R;

public class ToggleActivity extends AppCompatActivity {
    LinearLayout linearLayout;
    ToggleButton toggle;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createLinearView();
        setContentView(linearLayout);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        textView = new TextView(this);
        toggle = new ToggleButton(this);
        textView.setText("Sound");
        textView.setTextSize(20);

        linearLayout.addView(textView);
        linearLayout.addView(toggle);

        toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ToggleActivity.this, "Sound: "+toggle.getText(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void createLinearView() {
        linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(Gravity.CENTER);
    }
}
