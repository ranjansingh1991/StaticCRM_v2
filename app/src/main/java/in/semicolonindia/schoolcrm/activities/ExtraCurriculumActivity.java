package in.semicolonindia.schoolcrm.activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import in.semicolonindia.schoolcrm.BaseActivity;
import in.semicolonindia.schoolcrm.R;
import in.semicolonindia.schoolcrm.adapters.ExtraCurriculumRVAdapter;

/**
 * Created by Faraz on 03/08/2018.
 */
@SuppressWarnings("ALL")
public class ExtraCurriculumActivity extends BaseActivity {

    private RecyclerView rvExtraCurriculum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getLayoutInflater().inflate(R.layout.activity_extra_curriculum, contentFrame);

        init();
    }

    private void init() {
        fabMsg.setVisibility(View.GONE);
        rvExtraCurriculum = (RecyclerView) findViewById(R.id.rvExtraCurriculum);
        rvExtraCurriculum.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvExtraCurriculum.setAdapter(new ExtraCurriculumRVAdapter(ExtraCurriculumActivity.this));
    }
}