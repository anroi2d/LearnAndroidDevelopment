package com.myapp.anit.learnandroiddevelopment.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.myapp.anit.learnandroiddevelopment.R;

public class ImageButtonActivity extends AppCompatActivity {
    ImageButton imageButton;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_button);

        imageButton= (ImageButton) findViewById(R.id.image_btn);
        textView= (TextView) findViewById(R.id.textView_btn);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=getIntent();
                String imgBtn = intent.getStringExtra("btn");
                textView.setText("You clicked "+imgBtn);
            }
        });

    }
}
