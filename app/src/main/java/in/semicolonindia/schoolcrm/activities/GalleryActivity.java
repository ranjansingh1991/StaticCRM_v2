package in.semicolonindia.schoolcrm.activities;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import in.semicolonindia.schoolcrm.BaseActivity;
import in.semicolonindia.schoolcrm.R;
import in.semicolonindia.schoolcrm.adapters.GalleryRVAdapter;

/**
 * Created by Faraz on 03/04/2018.
 */
@SuppressWarnings("ALL")
public class GalleryActivity extends BaseActivity {

    private RecyclerView rvGallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getLayoutInflater().inflate(R.layout.activity_gallery, contentFrame);

        init();
    }

    private void init() {
        fabMsg.setVisibility(View.GONE);
        rvGallery = (RecyclerView) findViewById(R.id.rvGallery);
        rvGallery.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvGallery.setAdapter(new GalleryRVAdapter(GalleryActivity.this));
    }
}