package in.semicolonindia.schoolcrm.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import in.semicolonindia.schoolcrm.R;

/**
 * Created by Faraz on 03/10/2018.
 */
@SuppressWarnings("ALL")
public class ChangePasswordDialog extends Dialog implements View.OnClickListener {

    private Activity activity;
    private ImageButton imgBtnGo;
    private ImageButton imgBtnBack;

    public ChangePasswordDialog(Activity activity, int themeResId) {
        super(activity, themeResId);
        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_change_password);

        init();
    }

    private void init() {
        final Typeface appRegular = Typeface.createFromAsset(activity.getAssets(), "fonts/app_regular.ttf");
        final Typeface appBold = Typeface.createFromAsset(activity.getAssets(), "fonts/app_bold.ttf");
        final DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
        final LinearLayout llParent = (LinearLayout) findViewById(R.id.llParent);
        final RelativeLayout rlParent = (RelativeLayout) findViewById(R.id.rlParent);
        llParent.setMinimumWidth(displayMetrics.widthPixels);
        imgBtnGo = (ImageButton) findViewById(R.id.imgBtnGo);
        imgBtnBack = (ImageButton) findViewById(R.id.imgBtnBack);
        final TextView tvTitle = (TextView) findViewById(R.id.tvTitle);
        imgBtnBack.bringToFront();
        rlParent.invalidate();
        imgBtnGo.bringToFront();
        rlParent.invalidate();

        tvTitle.setTypeface(appBold);

        imgBtnBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgBtnGo:
                break;
            case R.id.imgBtnBack:
                break;
        }
        dismiss();
    }
}