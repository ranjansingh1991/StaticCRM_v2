package in.semicolonindia.schoolcrm.activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import in.semicolonindia.schoolcrm.BaseActivity;
import in.semicolonindia.schoolcrm.R;
import in.semicolonindia.schoolcrm.adapters.LeaderBoardRVAdapter;

/**
 * Created by Faraz on 03/08/2018.
 */
@SuppressWarnings("ALL")
public class LeaderBoardActivity extends BaseActivity {

    private RecyclerView rvLeaderBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getLayoutInflater().inflate(R.layout.activity_leaderboard, contentFrame);

        init();
    }

    private void init() {
        fabMsg.setVisibility(View.GONE);
        rvLeaderBoard = (RecyclerView) findViewById(R.id.rvLeaderBoard);
        rvLeaderBoard.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvLeaderBoard.setAdapter(new LeaderBoardRVAdapter(LeaderBoardActivity.this));
    }
}