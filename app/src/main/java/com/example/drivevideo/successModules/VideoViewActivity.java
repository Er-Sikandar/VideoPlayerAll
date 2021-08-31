package com.example.drivevideo.successModules;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.drivevideo.R;

public class VideoViewActivity extends AppCompatActivity {
    private String[] videoArray;
    private VideoView video_player;
    private String video_url2 = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4";
    private String video_url="https://drive.google.com/file/d/1CJwyboPZGTS28kyaaiSaj7-molVtyqRo";
    private ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);
        video_player=findViewById(R.id.video_player);
        pd=new ProgressDialog(VideoViewActivity.this);
        pd.setCancelable(false);
        pd.show();
        Uri uri= Uri.parse(video_url2);

        video_player.setVideoURI(uri);
        video_player.start();
        video_player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                pd.dismiss();
                //media controller here............
                MediaController mediaController=new MediaController(VideoViewActivity.this);
                mediaController.setAnchorView(video_player);
                video_player.setMediaController(mediaController);
            }
        });


    }
}