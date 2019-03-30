package in.semicolonindia.schoolcrm.activities;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListPopupWindow;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import in.semicolonindia.schoolcrm.BaseActivity;
import in.semicolonindia.schoolcrm.R;
import in.semicolonindia.schoolcrm.adapters.ClassRoutineLVAdapter;
import in.semicolonindia.schoolcrm.widgets.civ.CircleImageView;

/**
 * Created by Faraz on 03/01/2018.
 */
@SuppressWarnings("ALL")
public class ClassRoutineActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    private View ivHeader;
    private LinearLayout stickyView;
    private ListView lvRoutine;
    private View stickyViewSpacer;
    private Button btnDaySun;
    private Button btnDayMon;
    private Button btnDayTue;
    private Button btnDayWed;
    private Button btnDayThu;
    private Button btnDayFri;
    private Button btnDaySat;
    private CircleImageView civKidPic;
    private TextView tvKidName;
    private Button btnChange;
    private ListPopupWindow listPopupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getLayoutInflater().inflate(R.layout.activity_class_routine, contentFrame);

        init();
    }

    private void init() {
        fabMsg.setVisibility(View.GONE);
        final Typeface appBold = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/app_bold.ttf");
        final Typeface appRegular = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/app_regular.ttf");
        lvRoutine = (ListView) findViewById(R.id.lvRoutine);
        ivHeader = findViewById(R.id.ivHeader);
        stickyView = (LinearLayout) findViewById(R.id.stickyView);
        btnDaySun = (Button) findViewById(R.id.btnDaySun);
        btnDayMon = (Button) findViewById(R.id.btnDayMon);
        btnDayTue = (Button) findViewById(R.id.btnDayTue);
        btnDayWed = (Button) findViewById(R.id.btnDayWed);
        btnDayThu = (Button) findViewById(R.id.btnDayThu);
        btnDayFri = (Button) findViewById(R.id.btnDayFri);
        btnDaySat = (Button) findViewById(R.id.btnDaySat);
        civKidPic = (CircleImageView) findViewById(R.id.civKidPic);
        tvKidName = (TextView) findViewById(R.id.tvKidName);
        btnChange = (Button) findViewById(R.id.btnChange);
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View listHeader = inflater.inflate(R.layout.list_item_parallex_header, null);
        stickyViewSpacer = listHeader.findViewById(R.id.stickyViewPlaceholder);
        lvRoutine.addHeaderView(listHeader);

        /* Handle list View scroll events */
        lvRoutine.setOnScrollListener(new AbsListView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                /* Check if the first item is already reached to top.*/
                if (lvRoutine.getFirstVisiblePosition() == 0) {
                    View firstChild = lvRoutine.getChildAt(0);
                    int topY = 0;
                    if (firstChild != null) {
                        topY = firstChild.getTop();
                    }
                    int heroTopY = stickyViewSpacer.getTop();
                    stickyView.setY(Math.max(0, heroTopY + topY));
                    /* Set the image to scroll half of the amount that of ListView */
                    ivHeader.setY(topY * 0.5f);
                }
            }
        });

        lvRoutine.setAdapter(new ClassRoutineLVAdapter(ClassRoutineActivity.this));

        SimpleDateFormat format = new SimpleDateFormat("dd/MM ");
        Calendar date = Calendar.getInstance();
        String[] sDates = new String[7];
        for (int i = 0; i < 7; i++) {
            sDates[i] = format.format(date.getTime());
            date.add(Calendar.DATE, 1);
        }
        btnDaySun.setText(btnDaySun.getText().toString() + "\n" + sDates[0]);
        btnDayMon.setText(btnDayMon.getText().toString() + "\n" + sDates[1]);
        btnDayTue.setText(btnDayTue.getText().toString() + "\n" + sDates[2]);
        btnDayWed.setText(btnDayWed.getText().toString() + "\n" + sDates[3]);
        btnDayThu.setText(btnDayThu.getText().toString() + "\n" + sDates[4]);
        btnDayFri.setText(btnDayFri.getText().toString() + "\n" + sDates[5]);
        btnDaySat.setText(btnDaySat.getText().toString() + "\n" + sDates[6]);

        btnDaySun.setTypeface(appBold);
        btnDayMon.setTypeface(appBold);
        btnDayTue.setTypeface(appBold);
        btnDayWed.setTypeface(appBold);
        btnDayThu.setTypeface(appBold);
        btnDayFri.setTypeface(appBold);
        btnDaySat.setTypeface(appBold);
        tvKidName.setTypeface(appRegular);
        btnChange.setTypeface(appRegular);

        btnDaySun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnDaySun.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorPrimary));
                btnDayMon.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorAppBG));
                btnDayTue.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorAppBG));
                btnDayWed.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorAppBG));
                btnDayThu.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorAppBG));
                btnDayFri.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorAppBG));
                btnDaySat.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorAppBG));
                btnDaySun.setTextColor(getApplicationContext().getResources().getColor(android.R.color.white));
                btnDayMon.setTextColor(getApplicationContext().getResources().getColor(R.color.colorTextPrimary));
                btnDayTue.setTextColor(getApplicationContext().getResources().getColor(R.color.colorTextPrimary));
                btnDayWed.setTextColor(getApplicationContext().getResources().getColor(R.color.colorTextPrimary));
                btnDayThu.setTextColor(getApplicationContext().getResources().getColor(R.color.colorTextPrimary));
                btnDayFri.setTextColor(getApplicationContext().getResources().getColor(R.color.colorTextPrimary));
                btnDaySat.setTextColor(getApplicationContext().getResources().getColor(R.color.colorTextPrimary));
            }
        });

        btnDayMon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnDaySun.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorAppBG));
                btnDayMon.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorPrimary));
                btnDayTue.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorAppBG));
                btnDayWed.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorAppBG));
                btnDayThu.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorAppBG));
                btnDayFri.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorAppBG));
                btnDaySat.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorAppBG));
                btnDaySun.setTextColor(getApplicationContext().getResources().getColor(R.color.colorTextPrimary));
                btnDayMon.setTextColor(getApplicationContext().getResources().getColor(android.R.color.white));
                btnDayTue.setTextColor(getApplicationContext().getResources().getColor(R.color.colorTextPrimary));
                btnDayWed.setTextColor(getApplicationContext().getResources().getColor(R.color.colorTextPrimary));
                btnDayThu.setTextColor(getApplicationContext().getResources().getColor(R.color.colorTextPrimary));
                btnDayFri.setTextColor(getApplicationContext().getResources().getColor(R.color.colorTextPrimary));
                btnDaySat.setTextColor(getApplicationContext().getResources().getColor(R.color.colorTextPrimary));
            }
        });

        btnDayTue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnDaySun.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorAppBG));
                btnDayMon.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorAppBG));
                btnDayTue.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorPrimary));
                btnDayWed.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorAppBG));
                btnDayThu.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorAppBG));
                btnDayFri.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorAppBG));
                btnDaySat.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorAppBG));
                btnDaySun.setTextColor(getApplicationContext().getResources().getColor(R.color.colorTextPrimary));
                btnDayMon.setTextColor(getApplicationContext().getResources().getColor(R.color.colorTextPrimary));
                btnDayTue.setTextColor(getApplicationContext().getResources().getColor(android.R.color.white));
                btnDayWed.setTextColor(getApplicationContext().getResources().getColor(R.color.colorTextPrimary));
                btnDayThu.setTextColor(getApplicationContext().getResources().getColor(R.color.colorTextPrimary));
                btnDayFri.setTextColor(getApplicationContext().getResources().getColor(R.color.colorTextPrimary));
                btnDaySat.setTextColor(getApplicationContext().getResources().getColor(R.color.colorTextPrimary));
            }
        });

        btnDayWed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnDaySun.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorAppBG));
                btnDayMon.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorAppBG));
                btnDayTue.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorAppBG));
                btnDayWed.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorPrimary));
                btnDayThu.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorAppBG));
                btnDayFri.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorAppBG));
                btnDaySat.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorAppBG));
                btnDaySun.setTextColor(getApplicationContext().getResources().getColor(R.color.colorTextPrimary));
                btnDayMon.setTextColor(getApplicationContext().getResources().getColor(R.color.colorTextPrimary));
                btnDayTue.setTextColor(getApplicationContext().getResources().getColor(R.color.colorTextPrimary));
                btnDayWed.setTextColor(getApplicationContext().getResources().getColor(android.R.color.white));
                btnDayThu.setTextColor(getApplicationContext().getResources().getColor(R.color.colorTextPrimary));
                btnDayFri.setTextColor(getApplicationContext().getResources().getColor(R.color.colorTextPrimary));
                btnDaySat.setTextColor(getApplicationContext().getResources().getColor(R.color.colorTextPrimary));
            }
        });

        btnDayThu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnDaySun.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorAppBG));
                btnDayMon.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorAppBG));
                btnDayTue.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorAppBG));
                btnDayWed.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorAppBG));
                btnDayThu.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorPrimary));
                btnDayFri.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorAppBG));
                btnDaySat.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorAppBG));
                btnDaySun.setTextColor(getApplicationContext().getResources().getColor(R.color.colorTextPrimary));
                btnDayMon.setTextColor(getApplicationContext().getResources().getColor(R.color.colorTextPrimary));
                btnDayTue.setTextColor(getApplicationContext().getResources().getColor(R.color.colorTextPrimary));
                btnDayWed.setTextColor(getApplicationContext().getResources().getColor(R.color.colorTextPrimary));
                btnDayThu.setTextColor(getApplicationContext().getResources().getColor(android.R.color.white));
                btnDayFri.setTextColor(getApplicationContext().getResources().getColor(R.color.colorTextPrimary));
                btnDaySat.setTextColor(getApplicationContext().getResources().getColor(R.color.colorTextPrimary));
            }
        });

        btnDayFri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnDaySun.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorAppBG));
                btnDayMon.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorAppBG));
                btnDayTue.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorAppBG));
                btnDayWed.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorAppBG));
                btnDayThu.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorAppBG));
                btnDayFri.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorPrimary));
                btnDaySat.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorAppBG));
                btnDaySun.setTextColor(getApplicationContext().getResources().getColor(R.color.colorTextPrimary));
                btnDayMon.setTextColor(getApplicationContext().getResources().getColor(R.color.colorTextPrimary));
                btnDayTue.setTextColor(getApplicationContext().getResources().getColor(R.color.colorTextPrimary));
                btnDayWed.setTextColor(getApplicationContext().getResources().getColor(R.color.colorTextPrimary));
                btnDayThu.setTextColor(getApplicationContext().getResources().getColor(R.color.colorTextPrimary));
                btnDayFri.setTextColor(getApplicationContext().getResources().getColor(android.R.color.white));
                btnDaySat.setTextColor(getApplicationContext().getResources().getColor(R.color.colorTextPrimary));
            }
        });

        btnDaySat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnDaySun.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorAppBG));
                btnDayMon.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorAppBG));
                btnDayTue.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorAppBG));
                btnDayWed.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorAppBG));
                btnDayThu.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorAppBG));
                btnDayFri.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorAppBG));
                btnDaySat.setBackgroundColor(getApplicationContext().getResources().getColor(R.color.colorPrimary));
                btnDaySun.setTextColor(getApplicationContext().getResources().getColor(R.color.colorTextPrimary));
                btnDayMon.setTextColor(getApplicationContext().getResources().getColor(R.color.colorTextPrimary));
                btnDayTue.setTextColor(getApplicationContext().getResources().getColor(R.color.colorTextPrimary));
                btnDayWed.setTextColor(getApplicationContext().getResources().getColor(R.color.colorTextPrimary));
                btnDayThu.setTextColor(getApplicationContext().getResources().getColor(R.color.colorTextPrimary));
                btnDayFri.setTextColor(getApplicationContext().getResources().getColor(R.color.colorTextPrimary));
                btnDaySat.setTextColor(getApplicationContext().getResources().getColor(android.R.color.white));
            }
        });

        String[] kidNames = {"Rupesh", "Ranjan"};
        listPopupWindow = new ListPopupWindow(ClassRoutineActivity.this);
        listPopupWindow.setAdapter(new ArrayAdapter(ClassRoutineActivity.this,
                R.layout.pop_up_menu_item, kidNames));
        listPopupWindow.setAnchorView(btnChange);
        listPopupWindow.setWidth(300);
        listPopupWindow.setHeight(102 * kidNames.length);
        listPopupWindow.setModal(true);
        listPopupWindow.setOnItemClickListener(ClassRoutineActivity.this);

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listPopupWindow.show();
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        tvKidName.setText(((TextView)view.findViewById(R.id.tvItem)).getText().toString());
        listPopupWindow.dismiss();
    }
}