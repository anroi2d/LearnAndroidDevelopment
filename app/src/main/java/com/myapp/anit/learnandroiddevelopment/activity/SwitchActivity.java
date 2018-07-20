package com.myapp.anit.learnandroiddevelopment.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

import com.myapp.anit.learnandroiddevelopment.R;

public class SwitchActivity extends AppCompatActivity {
    Switch aSwitch;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createlinearLayoutView();
        setContentView(linearLayout);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    private void createlinearLayoutView() {
        linearLayout=new LinearLayout(this);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        aSwitch=new Switch(this);
        aSwitch.setText("Notification");
        aSwitch.setTextSize(20);

        linearLayout.addView(aSwitch);

        aSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(aSwitch.isChecked()){
                    Toast.makeText(SwitchActivity.this, "Notification is "+aSwitch.getTextOn(), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(SwitchActivity.this, "Notification is "+aSwitch.getTextOff(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
