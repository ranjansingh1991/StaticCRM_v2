package in.semicolonindia.schoolcrm.activities;

import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import in.semicolonindia.schoolcrm.R;

/**
 * Created by Faraz on 03/06/2018.
 */
@SuppressWarnings("ALL")
public class VideoPlayerActivity extends AppCompatActivity {

    private VideoView videoView;
    private ProgressBar pbLoading;
    private RelativeLayout rlVideoContainer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_video_player);

        init();
    }

    private void init() {
        videoView = (VideoView) findViewById(R.id.videoView);
        pbLoading = (ProgressBar) findViewById(R.id.pbLoading);
        rlVideoContainer = (RelativeLayout) findViewById(R.id.rlVideoContainer);
        pbLoading.bringToFront();
        rlVideoContainer.invalidate();
        String vidAddress = "http://www.sample-videos.com/video/mp4/720/big_buck_bunny_720p_10mb.mp4";
        Uri vidUri = Uri.parse(vidAddress);
        videoView.setVideoURI(vidUri);
        videoView.start();
        MediaController vidControl = new MediaController(VideoPlayerActivity.this);
        vidControl.setAnchorView(videoView);
        videoView.setMediaController(vidControl);
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                pbLoading.setVisibility(View.GONE);
            }
        });
    }
}