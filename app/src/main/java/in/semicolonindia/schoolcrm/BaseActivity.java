package in.semicolonindia.schoolcrm;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import in.semicolonindia.schoolcrm.utils.FragmentDrawer;
import in.semicolonindia.schoolcrm.widgets.civ.CircleImageView;

public class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    protected DrawerLayout drawerLayout;
    protected FrameLayout contentFrame;
    protected FloatingActionButton fabMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        init();
    }

    private void init() {
        final Typeface appBold = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/app_bold.ttf");
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        contentFrame = (FrameLayout) findViewById(R.id.contentFrame);
        RelativeLayout rlParent = (RelativeLayout) findViewById(R.id.rlParent);
        fabMsg = (FloatingActionButton) findViewById(R.id.fabMsg);
        fabMsg.bringToFront();
        rlParent.invalidate();
        FragmentDrawer drawerFragment = (FragmentDrawer) getSupportFragmentManager().findFragmentById(R.id.fragmentNavigationDrawer);
        drawerFragment.setUp(R.id.fragmentNavigationDrawer, (DrawerLayout) findViewById(R.id.drawerLayout));
        final TextView tvTitle = (TextView) findViewById(R.id.tvTitle);
        final CircleImageView civUser = (CircleImageView) findViewById(R.id.civUser);

        tvTitle.setTypeface(appBold);
        civUser.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.civUser:
                drawerLayout.openDrawer(Gravity.END);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(Gravity.END)) {
            drawerLayout.closeDrawers();
        } else {
            super.onBackPressed();
        }
    }
}