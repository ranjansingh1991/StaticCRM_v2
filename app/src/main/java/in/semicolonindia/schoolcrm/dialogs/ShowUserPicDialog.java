package in.semicolonindia.schoolcrm.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;

import com.ablanco.zoomy.TapListener;
import com.ablanco.zoomy.Zoomy;

import in.semicolonindia.schoolcrm.R;

/**
 * Created by Faraz on 03/10/2018.
 */
@SuppressWarnings("ALL")
public class ShowUserPicDialog extends Dialog {

    private Activity activity;
    private Drawable image;

    public ShowUserPicDialog(Activity activity, int themeResId, Drawable image) {
        super(activity, themeResId);
        this.activity = activity;
        this.image = image;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.list_item_full_screen);

        init();
    }

    private void init() {
        ImageView imgDisplay = (ImageView) findViewById(R.id.imgDisplay);
        imgDisplay.setImageDrawable(image);
        Zoomy.Builder builder = new Zoomy.Builder(activity)
                .target(imgDisplay)
                .interpolator(new OvershootInterpolator())
                .tapListener(new TapListener() {
                    @Override
                    public void onTap(View v) {

                    }
                });
        builder.register();
    }
}