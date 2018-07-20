package com.myapp.anit.learnandroiddevelopment.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.myapp.anit.learnandroiddevelopment.R;

public class RadioActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton rdc,rdAndroid,rdJava,rdIos,rdPhp;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        init();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                setCheckRadioBtn(radioGroup,checkedId);

            }
        });



    }

    private void setCheckRadioBtn(RadioGroup radioGroup, int checked) {
        checked = radioGroup.getCheckedRadioButtonId();
        if(checked == R.id.rd_c){
            linearLayout.setBackgroundColor(Color.RED);
            Toast.makeText(RadioActivity.this, "You choosed: "+rdc.getText(), Toast.LENGTH_SHORT).show();
        }
        if(checked == R.id.rd_android){
            linearLayout.setBackgroundColor(Color.WHITE);
            Toast.makeText(RadioActivity.this, "You choosed: "+rdAndroid.getText(), Toast.LENGTH_SHORT).show();
        }
        if(checked == R.id.rd_ios){
            linearLayout.setBackgroundColor(Color.YELLOW);
            Toast.makeText(RadioActivity.this, "You choosed: "+rdIos.getText(), Toast.LENGTH_SHORT).show();
        }
        if(checked == R.id.rd_java){
            linearLayout.setBackgroundColor(Color.BLUE);
            Toast.makeText(RadioActivity.this, "You choosed: "+rdJava.getText(), Toast.LENGTH_SHORT).show();
        }
        if(checked == R.id.rd_php){
            linearLayout.setBackgroundColor(Color.GREEN);
            Toast.makeText(RadioActivity.this, "You choosed: "+rdPhp.getText(), Toast.LENGTH_SHORT).show();
        }
    }

    private void init() {
        radioGroup= (RadioGroup) findViewById(R.id.radio_group);
        rdAndroid= (RadioButton) findViewById(R.id.rd_android);
        rdc= (RadioButton) findViewById(R.id.rd_c);
        rdJava= (RadioButton) findViewById(R.id.rd_java);
        rdIos= (RadioButton) findViewById(R.id.rd_ios);
        rdPhp= (RadioButton) findViewById(R.id.rd_php);
        linearLayout= (LinearLayout) findViewById(R.id.linear_radio);
    }


}
