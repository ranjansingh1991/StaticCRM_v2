package in.semicolonindia.schoolcrm.activities;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import in.semicolonindia.schoolcrm.R;
import in.semicolonindia.schoolcrm.adapters.FullSctreenVPAdapter;

/**
 * Created by Faraz on 03/04/2018.
 */
@SuppressWarnings("ALL")
public class FullScreenImageActivity extends AppCompatActivity {

    private ViewPager vpImages;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_full_screen_image);

        init();
    }

    private void init() {
        vpImages = (ViewPager) findViewById(R.id.vpImages);
        final Drawable[] images = {
                getApplicationContext().getResources().getDrawable(R.drawable.dummy_image),
                getApplicationContext().getResources().getDrawable(R.drawable.dummy_image),
                getApplicationContext().getResources().getDrawable(R.drawable.dummy_image),
                getApplicationContext().getResources().getDrawable(R.drawable.dummy_image),
                getApplicationContext().getResources().getDrawable(R.drawable.dummy_image),
                getApplicationContext().getResources().getDrawable(R.drawable.dummy_image),
                getApplicationContext().getResources().getDrawable(R.drawable.dummy_image),
                getApplicationContext().getResources().getDrawable(R.drawable.dummy_image)
        };
        vpImages.setAdapter(new FullSctreenVPAdapter(FullScreenImageActivity.this, images));
    }
}