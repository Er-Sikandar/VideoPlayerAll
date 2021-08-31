package com.example.drivevideo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.drivevideo.successModules.ExoPlayerActivity;
import com.example.drivevideo.successModules.VideoViewActivity;
import com.example.drivevideo.successModules.YoutubeActivity;

public class MainActivity extends AppCompatActivity {
    private Button wv_btn, youtube_btn, expo_btn,VideoViewbtn,api_btn;
    private String video_url = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wv_btn = findViewById(R.id.wv_btn);
        expo_btn = findViewById(R.id.expo_btn);
        youtube_btn = findViewById(R.id.youtube_btn);
        VideoViewbtn=findViewById(R.id.VideoViewbtn);
        api_btn=findViewById(R.id.api_btn);
        youtube_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, YoutubeActivity.class));
            }
        });
        expo_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, ExoPlayerActivity.class);
                intent.putExtra("video_uri", video_url);
                startActivity(intent);
            }
        });
        VideoViewbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, VideoViewActivity.class));
            }
        });

        wv_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, WebViewActivity.class));
            }
        });
        api_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ApiDriveActivity.class));

            }
        });

    }
}