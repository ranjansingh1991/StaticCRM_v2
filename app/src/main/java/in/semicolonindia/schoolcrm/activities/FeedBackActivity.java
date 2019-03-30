package in.semicolonindia.schoolcrm.activities;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.AppCompatRadioButton;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import in.semicolonindia.schoolcrm.BaseActivity;
import in.semicolonindia.schoolcrm.R;

/**
 * Created by Faraz on 03/12/2018.
 */
@SuppressWarnings("ALL")
public class FeedBackActivity extends BaseActivity implements View.OnClickListener {

    private TextView tvTitle;
    private TextView tvActionTitle;
    private AppCompatRadioButton rbFeedback;
    private AppCompatRadioButton rbEscalation;
    private EditText etMsg;
    private ImageButton imgBtnBack;
    private ImageButton imgBtnGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getLayoutInflater().inflate(R.layout.activity_feedback, contentFrame);

        init();
    }

    private void init() {
        fabMsg.setVisibility(View.GONE);
        final Typeface appBold = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/app_bold.ttf");
        final Typeface appRegular = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/app_regular.ttf");
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvActionTitle = (TextView) findViewById(R.id.tvActionTitle);
        rbFeedback = (AppCompatRadioButton) findViewById(R.id.rbFeedback);
        rbEscalation = (AppCompatRadioButton) findViewById(R.id.rbEscalation);
        etMsg = (EditText) findViewById(R.id.etMsg);
        imgBtnBack = (ImageButton) findViewById(R.id.imgBtnBack);
        imgBtnGo = (ImageButton) findViewById(R.id.imgBtnGo);
        tvTitle.setTypeface(appBold);
        tvActionTitle.setTypeface(appRegular);
        rbFeedback.setTypeface(appRegular);
        rbEscalation.setTypeface(appRegular);
        etMsg.setTypeface(appRegular);

        imgBtnBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgBtnGo:
                break;
            case R.id.imgBtnBack:
                finish();
                break;
        }
    }
}