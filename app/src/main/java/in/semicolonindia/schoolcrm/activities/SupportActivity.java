package in.semicolonindia.schoolcrm.activities;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import in.semicolonindia.schoolcrm.BaseActivity;
import in.semicolonindia.schoolcrm.R;
import in.semicolonindia.schoolcrm.adapters.SupportVPAdapter;
import in.semicolonindia.schoolcrm.widgets.stl.SlidingTabLayout;

/**
 * Created by Faraz on 03/09/2018.
 */
@SuppressWarnings("ALL")
public class SupportActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getLayoutInflater().inflate(R.layout.activity_support, contentFrame);

        init();
    }

    private void init() {
        fabMsg.setVisibility(View.GONE);
        final Typeface appBold = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/app_bold.ttf");
        final Typeface appRegular = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/app_regular.ttf");
        final TextView tvDevCompanyName = (TextView) findViewById(R.id.tvDevCompanyName);
        final TextView tvPoweredBy = (TextView) findViewById(R.id.tvPoweredBy);
        tvDevCompanyName.setTypeface(appBold);
        tvPoweredBy.setTypeface(appRegular);
        final SlidingTabLayout stLGTalking = (SlidingTabLayout) findViewById(R.id.stLGTalking);
        final ViewPager vpLGTalking = (ViewPager) findViewById(R.id.vpLGTalking);

        final SupportVPAdapter mSupportVPAdapter = new SupportVPAdapter(getSupportFragmentManager(),
                getApplicationContext());
        stLGTalking.setCustomTabView(R.layout.tab_title_item, R.id.tvTabName);
        stLGTalking.setDistributeEvenly(false);
        vpLGTalking.setAdapter(mSupportVPAdapter);
        try {
            stLGTalking.setViewPager(vpLGTalking);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}