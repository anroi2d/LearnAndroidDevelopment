package com.myapp.anit.learnandroiddevelopment.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.myapp.anit.learnandroiddevelopment.R;

public class ImageViewActivity extends AppCompatActivity {
    TextView textView;
    ImageView imageView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        textView= (TextView) findViewById(R.id.textView_imgview);
        imageView= (ImageView) findViewById(R.id.iImg_view);
        button= (Button) findViewById(R.id.button_show_img);
        button.setText("Click me");


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setBackgroundResource(R.mipmap.ic_launcher);
                textView.setText("This is ImageView");

            }
        });
    }
}
