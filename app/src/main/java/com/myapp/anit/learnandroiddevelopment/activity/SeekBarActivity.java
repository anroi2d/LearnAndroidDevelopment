package com.myapp.anit.learnandroiddevelopment.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import com.myapp.anit.learnandroiddevelopment.R;

public class SeekBarActivity extends AppCompatActivity {
    TextView textView;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar);
        // TODO: 20/07/2018

        seekBar= (SeekBar) findViewById(R.id.seek_bar);
        textView= (TextView) findViewById(R.id.text_view);
        textView.setText("SeekBar by anroi2d");

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textView.setTextColor(Color.YELLOW);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textView.setTextColor(Color.RED);
            }
        });
    }
}
