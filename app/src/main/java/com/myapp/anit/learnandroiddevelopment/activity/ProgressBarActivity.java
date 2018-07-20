package com.myapp.anit.learnandroiddevelopment.activity;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.myapp.anit.learnandroiddevelopment.R;

public class ProgressBarActivity extends AppCompatActivity {
    ProgressBar progressBar,progressBarHorizontal;
    Button buttonHorozontal,button;
    TextView tvPercent;
    private int status = 0;
    private Handler progressBarHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);

        progressBarHorizontal = (ProgressBar) findViewById(R.id.progress_bar_horizontal);
        progressBar= (ProgressBar) findViewById(R.id.progress_bar);
        buttonHorozontal = (Button) findViewById(R.id.btn_load2);
        button = (Button) findViewById(R.id.btn_load1);
        tvPercent = (TextView) findViewById(R.id.tv_percent);

        progressBar.setVisibility(View.GONE);

        progressBarHorizontal.setMax(100);
        progressBarHorizontal.setProgress(0);

        //set sự kiện click cho button Start để load progressbar
        buttonHorozontal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //tạo 1 thread để tăng trang thái status của progress
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (status < 100) {
                            //tăng trạng thái của progress
                            status = updateStatus();
                            try {
                                //nghỉ 0.5 giây trước khi update giá trị mới của progressbar
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            // sử dụng Handler để set lại giá trị mới cho progressbar trong 1 tiến trình khác
                            progressBarHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    //update giá trị progressbar
                                    progressBarHorizontal.setProgress(status);
                                    // update giá trị ở TextView
                                    tvPercent.setText(status + " %");
                                }
                            });
                        }
                        if (status >= 100) {
                            try {
                                //nghỉ 1 giây sau khi kết thúc update progressbar
                                Thread.sleep(1000);

                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            //set lại trạng thái cho progressbar để load lại khi bấm vào nút lần tiếp theo
                            status = 0;

                        }
                    }

                }).start();//start Thread
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                progressBar.setProgress(0);
                progressBar.setMax(100);
            }
        });

    }

    public int updateStatus() {
        if (status < 100) {
            status++;
        }
        return status;
    }
}
