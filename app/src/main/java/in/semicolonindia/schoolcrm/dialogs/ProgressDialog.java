package in.semicolonindia.schoolcrm.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import in.semicolonindia.schoolcrm.R;

/**
 * Created by Faraz on 03/08/2018.
 */
@SuppressWarnings("ALL")
public class ProgressDialog extends Dialog {

    private Activity activity;
    private String sMsg;
    private ImageView imgLoading;
    private TextView tvDialogMsg;

    public ProgressDialog(@NonNull Activity activity, String sMsg) {
        super(activity);
        this.activity = activity;
        this.sMsg = sMsg;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_progress_bar);

        init();
    }

    private void init() {
        final Typeface appRegular = Typeface.createFromAsset(activity.getAssets(), "fonts/app_regular.ttf");
        imgLoading = (ImageView) findViewById(R.id.imgLoading);
        tvDialogMsg = (TextView) findViewById(R.id.tvDialogMsg);
        tvDialogMsg.setTypeface(appRegular);
        tvDialogMsg.setText(sMsg);
        imgLoading.startAnimation(AnimationUtils.loadAnimation(activity, R.anim.rotate_infinite) );
    }
}