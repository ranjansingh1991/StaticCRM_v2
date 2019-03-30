package in.semicolonindia.schoolcrm.activities;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListPopupWindow;
import android.widget.TextView;

import in.semicolonindia.schoolcrm.BaseActivity;
import in.semicolonindia.schoolcrm.R;
import in.semicolonindia.schoolcrm.adapters.AttendanceRVAdapter;
import in.semicolonindia.schoolcrm.widgets.civ.CircleImageView;

/**
 * Created by Faraz on 03/02/2018.
 */
@SuppressWarnings("ALL")
public class AttendanceActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    private RecyclerView rvAttendance;
    private ListPopupWindow listPopupWindow;
    private CircleImageView civKidPic;
    private TextView tvKidName;
    private Button btnChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getLayoutInflater().inflate(R.layout.activity_attendance, contentFrame);

        init();
    }

    private void init() {
        fabMsg.setVisibility(View.GONE);
        final Typeface appRegular = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/app_regular.ttf");
        rvAttendance = (RecyclerView) findViewById(R.id.rvAttendance);
        civKidPic = (CircleImageView) findViewById(R.id.civKidPic);
        tvKidName = (TextView) findViewById(R.id.tvKidName);
        btnChange = (Button) findViewById(R.id.btnChange);

        tvKidName.setTypeface(appRegular);
        btnChange.setTypeface(appRegular);

        String[] kidNames = {"Rupesh", "Ranjan"};
        listPopupWindow = new ListPopupWindow(AttendanceActivity.this);
        listPopupWindow.setAdapter(new ArrayAdapter(AttendanceActivity.this,
                R.layout.pop_up_menu_item, kidNames));
        listPopupWindow.setAnchorView(btnChange);
        listPopupWindow.setWidth(300);
        listPopupWindow.setHeight(102 * kidNames.length);
        listPopupWindow.setModal(true);
        listPopupWindow.setOnItemClickListener(AttendanceActivity.this);

        rvAttendance.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvAttendance.setAdapter(new AttendanceRVAdapter(AttendanceActivity.this));

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