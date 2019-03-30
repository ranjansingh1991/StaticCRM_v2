package in.semicolonindia.schoolcrm.activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ListPopupWindow;
import android.widget.TextView;

import in.semicolonindia.schoolcrm.BaseActivity;
import in.semicolonindia.schoolcrm.R;
import in.semicolonindia.schoolcrm.adapters.ScholarshipRVAdapter;
import in.semicolonindia.schoolcrm.widgets.civ.CircleImageView;

/**
 * Created by Faraz on 03/08/2018.
 */
@SuppressWarnings("ALL")
public class ScholarshipActivity extends BaseActivity {

    private RecyclerView rvScholarship;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getLayoutInflater().inflate(R.layout.activity_scholarship, contentFrame);

        init();
    }

    private void init() {
        fabMsg.setVisibility(View.GONE);
        rvScholarship = (RecyclerView) findViewById(R.id.rvScholarship);
        rvScholarship.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvScholarship.setAdapter(new ScholarshipRVAdapter(ScholarshipActivity.this));
    }
}