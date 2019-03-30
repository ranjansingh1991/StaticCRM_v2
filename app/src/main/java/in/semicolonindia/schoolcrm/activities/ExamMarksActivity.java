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
import in.semicolonindia.schoolcrm.adapters.ExamMarksRVAdapter;
import in.semicolonindia.schoolcrm.widgets.civ.CircleImageView;

/**
 * Created by Faraz on 03/03/2018.
 */
@SuppressWarnings("ALL")
public class ExamMarksActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    private RecyclerView rvExamMarks;
    private ListPopupWindow listPopupWindow;
    private CircleImageView civKidPic;
    private TextView tvKidName;
    private Button btnChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getLayoutInflater().inflate(R.layout.activity_exam_marks, contentFrame);

        init();
    }

    private void init() {
        fabMsg.setVisibility(View.GONE);
        final Typeface appRegular = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/app_regular.ttf");
        rvExamMarks = (RecyclerView) findViewById(R.id.rvExamMarks);
        civKidPic = (CircleImageView) findViewById(R.id.civKidPic);
        tvKidName = (TextView) findViewById(R.id.tvKidName);
        btnChange = (Button) findViewById(R.id.btnChange);

        tvKidName.setTypeface(appRegular);
        btnChange.setTypeface(appRegular);

        String[] kidNames = {"Rupesh", "Ranjan"};
        listPopupWindow = new ListPopupWindow(ExamMarksActivity.this);
        listPopupWindow.setAdapter(new ArrayAdapter(ExamMarksActivity.this,
                R.layout.pop_up_menu_item, kidNames));
        listPopupWindow.setAnchorView(btnChange);
        listPopupWindow.setWidth(300);
        listPopupWindow.setHeight(102 * kidNames.length);
        listPopupWindow.setModal(true);
        listPopupWindow.setOnItemClickListener(ExamMarksActivity.this);

        rvExamMarks.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvExamMarks.setAdapter(new ExamMarksRVAdapter(ExamMarksActivity.this));

        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listPopupWindow.show();
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        tvKidName.setText(((TextView) view.findViewById(R.id.tvItem)).getText().toString());
        listPopupWindow.dismiss();
    }
}