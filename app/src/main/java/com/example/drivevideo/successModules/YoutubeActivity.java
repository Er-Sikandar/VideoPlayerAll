package com.example.drivevideo.successModules;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.drivevideo.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.YouTubePlayerTracker;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.ui.PlayerUiController;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.ui.views.YouTubePlayerSeekBarListener;

public class YoutubeActivity extends AppCompatActivity {
private YouTubePlayerView youTubePlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);
         youTubePlayerView = findViewById(R.id.youtube_player_view);
        youTubePlayerView.enterFullScreen();
        youTubePlayerView.exitFullScreen();
        youTubePlayerView.isFullScreen();
        youTubePlayerView.toggleFullScreen();
        getLifecycle().addObserver(youTubePlayerView);
        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                YouTubePlayerTracker tracker = new YouTubePlayerTracker();
                youTubePlayer.addListener(tracker);
                tracker.getState();
                tracker.getCurrentSecond();
                tracker.getVideoDuration();
                String videoId = "tzEF7JYuemI";
                youTubePlayer.loadVideo(videoId, 0);


            }
        });


       //live video
        PlayerUiController  playerUiController=youTubePlayerView.getPlayerUiController();

        //set background play........
        playerUiController.showUi(false);
        playerUiController.enableLiveVideoUi(true);
        youTubePlayerView.enableBackgroundPlayback(false);

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        youTubePlayerView.release();
    }
}