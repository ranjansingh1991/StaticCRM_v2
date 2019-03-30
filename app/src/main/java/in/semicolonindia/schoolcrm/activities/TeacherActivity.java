package in.semicolonindia.schoolcrm.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import in.semicolonindia.schoolcrm.BaseActivity;
import in.semicolonindia.schoolcrm.R;
import in.semicolonindia.schoolcrm.adapters.TeacherRVAdapter;

/**
 * Created by Faraz on 03/07/2018.
 */
@SuppressWarnings("ALL")
public class TeacherActivity extends BaseActivity {

    private RelativeLayout rlParent;
    private RecyclerView rvTeacher;
    private LinearLayout llRubberIndicator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_teachers, contentFrame);

        init();
    }

    private void init() {
        fabMsg.setVisibility(View.GONE);
        rlParent = (RelativeLayout) findViewById(R.id.rlParent);
        rvTeacher = (RecyclerView) findViewById(R.id.rvTeacher);
        llRubberIndicator = (LinearLayout) findViewById(R.id.llRubberIndicator);
        llRubberIndicator.bringToFront();
        rlParent.invalidate();
        rvTeacher.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        rvTeacher.setAdapter(new TeacherRVAdapter(TeacherActivity.this));
    }
}