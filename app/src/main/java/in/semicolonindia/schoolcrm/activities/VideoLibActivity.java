package in.semicolonindia.schoolcrm.activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import in.semicolonindia.schoolcrm.BaseActivity;
import in.semicolonindia.schoolcrm.R;
import in.semicolonindia.schoolcrm.adapters.VideosCommentAdapter;

/**
 * Created by Faraz on 03/06/2018.
 */
@SuppressWarnings("ALL")
public class VideoLibActivity extends BaseActivity {

    private TextView tvVideoTitle;
    private ImageView imgThumbnail;
    private RecyclerView rvComments;
    private Button btnPostComment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_video_lib, contentFrame);

        init();
    }

    private void init() {
        fabMsg.setVisibility(View.GONE);
        final Typeface appRegular = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/app_regular.ttf");
        imgThumbnail = (ImageView) findViewById(R.id.imgThumbnail);
        tvVideoTitle = (TextView) findViewById(R.id.tvVideoTitle);
        rvComments = (RecyclerView) findViewById(R.id.rvComments);
        btnPostComment = (Button) findViewById(R.id.btnPostComment);

        btnPostComment.setTypeface(appRegular);
        rvComments.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvComments.setAdapter(new VideosCommentAdapter(VideoLibActivity.this));

        imgThumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), VideoPlayerActivity.class));
            }
        });
    }
}