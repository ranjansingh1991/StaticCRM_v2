package in.semicolonindia.schoolcrm.activities;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.CalendarView;
import android.widget.TextView;

import in.semicolonindia.schoolcrm.BaseActivity;
import in.semicolonindia.schoolcrm.R;
import in.semicolonindia.schoolcrm.adapters.HomeAdsVPAdapter;
import in.semicolonindia.schoolcrm.adapters.HomeGraphRVAdapter;
import in.semicolonindia.schoolcrm.adapters.HomeMenuRVAdapter;
import in.semicolonindia.schoolcrm.adapters.HomeNewsRVAdapter;
import in.semicolonindia.schoolcrm.adapters.HomeNoticeRVAdapter;
import in.semicolonindia.schoolcrm.dialogs.ProgressDialog;

/**
 * Created by Faraz on 02/28/2018.
 */
@SuppressWarnings("ALL")
public class HomeActivity extends BaseActivity {

    private ViewPager vpHomeAds;
    private RecyclerView rvMenu;
    private RecyclerView rvPerformance;
    private RecyclerView rvNews;
    private RecyclerView rvNoticeBoard;
    private CalendarView cvAcademicCalender;;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getLayoutInflater().inflate(R.layout.activity_home, contentFrame);

        init();
    }

    private void init() {
        final Typeface appBold = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/app_bold.ttf");
        final Typeface appRegular = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/app_regular.ttf");
        final TextView tvQuickAccess = (TextView) findViewById(R.id.tvQuickAccess);
        final TextView tvPerformance = (TextView) findViewById(R.id.tvPerformance);
        final TextView tvNews = (TextView) findViewById(R.id.tvNews);
        final TextView tvAcademicCalender = (TextView) findViewById(R.id.tvAcademicCalender);
        final TextView tvNoticeBoard = (TextView) findViewById(R.id.tvNoticeBoard);
        final TextView tvWordFromBench = (TextView) findViewById(R.id.tvWordFromBench);
        final TextView tvWFBCaption = (TextView) findViewById(R.id.tvWFBCaption);
        vpHomeAds = (ViewPager) findViewById(R.id.vpHomeAds);
        rvMenu = (RecyclerView) findViewById(R.id.rvMenu);
        rvPerformance = (RecyclerView) findViewById(R.id.rvPerformance);
        rvNews = (RecyclerView) findViewById(R.id.rvNews);
        rvNoticeBoard = (RecyclerView) findViewById(R.id.rvNoticeBoard);
        cvAcademicCalender = (CalendarView) findViewById(R.id.cvAcademicCalender);
        rvMenu.setLayoutManager(new GridLayoutManager(getApplicationContext(), 4));
        rvPerformance.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        rvNews.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        rvNoticeBoard.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));

        tvQuickAccess.setTypeface(appBold);
        tvPerformance.setTypeface(appBold);
        tvNews.setTypeface(appBold);
        tvAcademicCalender.setTypeface(appBold);
        tvNoticeBoard.setTypeface(appBold);
        tvWordFromBench.setTypeface(appBold);
        tvWFBCaption.setTypeface(appRegular);

        vpHomeAds.setAdapter(new HomeAdsVPAdapter(HomeActivity.this));
        rvMenu.setAdapter(new HomeMenuRVAdapter(HomeActivity.this));
        rvPerformance.setAdapter(new HomeGraphRVAdapter(HomeActivity.this));
        rvNews.setAdapter(new HomeNewsRVAdapter(HomeActivity.this));
        rvNoticeBoard.setAdapter(new HomeNoticeRVAdapter(HomeActivity.this));

        cvAcademicCalender.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {
            }
        });

        final ProgressDialog mProgressDialog = new ProgressDialog(HomeActivity.this, "");
        mProgressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mProgressDialog.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mProgressDialog.dismiss();
            }
        }, 4000);
    }
}