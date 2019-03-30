package in.semicolonindia.schoolcrm.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import in.semicolonindia.schoolcrm.R;
import in.semicolonindia.schoolcrm.activities.HomeActivity;
import in.semicolonindia.schoolcrm.activities.SupportActivity;

/**
 * Created by Faraz on 03/10/2018.
 */
@SuppressWarnings("ALL")
public class LoginDialog extends Dialog implements View.OnClickListener {

    private ImageButton imgBtnGo;
    private ImageButton imgBtnBack;
    private Activity activity;
    private LinearLayout llLoginSet;
    private TextView tvForgotPwd;
    private TextView tvNeedHelp;

    public LoginDialog(@NonNull Activity activity, @StyleRes int themeResId) {
        super(activity, themeResId);
        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_login);

        init();
    }

    private void init() {
        final Typeface appBold = Typeface.createFromAsset(activity.getAssets(), "fonts/app_bold.ttf");
        final DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
        final LinearLayout llParent = (LinearLayout) findViewById(R.id.llParent);
        llLoginSet = (LinearLayout) findViewById(R.id.llLoginSet);
        final RelativeLayout rlParent = (RelativeLayout) findViewById(R.id.rlParent);
        llParent.setMinimumWidth(displayMetrics.widthPixels);
        imgBtnGo = (ImageButton) findViewById(R.id.imgBtnGo);
        imgBtnBack = (ImageButton) findViewById(R.id.imgBtnBack);
        final TextView tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvForgotPwd = (TextView) findViewById(R.id.tvForgotPwd);
        tvNeedHelp = (TextView) findViewById(R.id.tvNeedHelp);
        imgBtnGo.bringToFront();
        rlParent.invalidate();

        tvTitle.setTypeface(appBold);
        tvForgotPwd.setTypeface(appBold, Typeface.BOLD);
        tvNeedHelp.setTypeface(appBold, Typeface.BOLD);

        tvForgotPwd.setOnClickListener(this);
        tvNeedHelp.setOnClickListener(this);
        imgBtnGo.setOnClickListener(this);
        imgBtnBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgBtnGo:
                activity.startActivity(new Intent(activity, HomeActivity.class));
                activity.finish();
                break;
            case R.id.tvForgotPwd:
                ForgetPasswordDialog mForgetPasswordDialog = new ForgetPasswordDialog(activity, R.style.DialogSlideAnim);
                mForgetPasswordDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                mForgetPasswordDialog.getWindow().setGravity(Gravity.BOTTOM);
                mForgetPasswordDialog.setCancelable(false);
                mForgetPasswordDialog.setCanceledOnTouchOutside(false);
                mForgetPasswordDialog.show();
                break;
            case R.id.tvNeedHelp:
                activity.startActivity(new Intent(activity, SupportActivity.class));
                break;
            case R.id.imgBtnBack:
                break;
        }
        dismiss();
    }
}