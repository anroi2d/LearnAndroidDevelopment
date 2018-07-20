package com.myapp.anit.learnandroiddevelopment.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.myapp.anit.learnandroiddevelopment.R;

public class CheckBoxActivity extends AppCompatActivity {
    CheckBox chbCoffee,chbBeer,chbRedbull;
    String checkbox;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

        chbBeer= (CheckBox) findViewById(R.id.chb_beer);
        chbCoffee= (CheckBox) findViewById(R.id.chb_coffee);
        chbRedbull= (CheckBox) findViewById(R.id.chb_red);
        button= (Button) findViewById(R.id.buttonPanel);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCheckbox();
                Toast.makeText(CheckBoxActivity.this, "You choosed: \n"+checkbox, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void setCheckbox() {
        checkbox="";
        if(chbCoffee.isChecked()){
            checkbox += chbCoffee.getText()+"\n";
        }
        if(chbBeer.isChecked()){
            checkbox += chbBeer.getText()+"\n";
        }
        if(chbRedbull.isChecked()){
            checkbox += chbRedbull.getText()+"\n";
        }

    }
}
