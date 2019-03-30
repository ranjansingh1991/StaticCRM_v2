package in.semicolonindia.schoolcrm.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.ablanco.zoomy.TapListener;
import com.ablanco.zoomy.Zoomy;

import in.semicolonindia.schoolcrm.R;

/**
 * Created by Faraz on 03/04/2018.
 */
@SuppressWarnings("ALL")
public class FullSctreenVPAdapter extends PagerAdapter {

    private Activity activity;
    private Drawable[] images;
    private LayoutInflater inflater;

    // constructor
    public FullSctreenVPAdapter(Activity activity, Drawable[] images) {
        this.activity = activity;
        this.images = images;
    }

    @Override
    public int getCount() {
        return this.images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewLayout = inflater.inflate(R.layout.list_item_full_screen, container, false);
        ImageView imgDisplay = (ImageView) viewLayout.findViewById(R.id.imgDisplay);
        imgDisplay.setImageDrawable(images[position]);
        Zoomy.Builder builder = new Zoomy.Builder(activity)
                .target(imgDisplay)
                .interpolator(new OvershootInterpolator())
                .tapListener(new TapListener() {
                    @Override
                    public void onTap(View v) {

                    }
                });
        builder.register();

        ((ViewPager) container).addView(viewLayout);

        return viewLayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((RelativeLayout) object);
    }
}