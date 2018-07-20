package com.myapp.anit.learnandroiddevelopment.activity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

import com.myapp.anit.learnandroiddevelopment.R;

public class VideoViewActivity extends AppCompatActivity {
    VideoView videoView;
    MediaController mediaController;
    private int position =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);

        videoView= (VideoView) findViewById(R.id.video_view);

        if(mediaController==null){
            mediaController = new MediaController(this);
        }
        //neo
        mediaController.setAnchorView(videoView);
        //set
        videoView.setMediaController(mediaController);
        //id of file video
        try {
            int id = this.getRawResIdByName("xoxohali");
            videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + id));
            videoView.requestFocus();
        }catch (Exception e){
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }



        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                videoView.seekTo(position);
                if (position == 0) {
                    videoView.start();
                }

                mediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i1) {
                        mediaController.setAnchorView(videoView);
                    }
                });

            }
        });

    }
    public int getRawResIdByName(String resName) {
        String pkgName = this.getPackageName();

        // Trả về 0 nếu không tìm thấy.
        int resID = this.getResources().getIdentifier(resName, "raw", pkgName);
        Log.i("AndroidVideoView", "Res Name: " + resName + "==> Res ID = " + resID);
        return resID;
    }
//xoay
    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

        // Lưu lại vị trí file video đang chơi.
        outState.putInt("CurrentPosition", videoView.getCurrentPosition());
        videoView.pause();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // Lấy lại ví trí video đã chơi.
        position = savedInstanceState.getInt("CurrentPosition");
        videoView.seekTo(position);
    }
}
