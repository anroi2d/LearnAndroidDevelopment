package com.myapp.anit.learnandroiddevelopment.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.Toast;

import com.myapp.anit.learnandroiddevelopment.R;

public class RatingBarActivity extends AppCompatActivity {
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_bar);

        ratingBar= (RatingBar) findViewById(R.id.rating_bar);
        ratingBar.setNumStars(5);

    }
}
