package in.semicolonindia.schoolcrm.adapters;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import in.semicolonindia.schoolcrm.R;

/**
 * Created by Faraz on 02/28/2018.
 */
@SuppressWarnings("ALL")
public class HomeAdsVPAdapter extends PagerAdapter {

    private Activity activity;
    private Drawable[] mImages = new Drawable[4];

    public HomeAdsVPAdapter(Activity activity) {
        this.activity = activity;
        mImages[0] = activity.getDrawable(R.drawable.dummy_image);
        mImages[1] = activity.getDrawable(R.drawable.dummy_image);
        mImages[2] = activity.getDrawable(R.drawable.dummy_image);
        mImages[3] = activity.getDrawable(R.drawable.dummy_image);
    }

    @Override
    public int getCount() {
        return mImages.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View view = android.view.View.inflate(activity, R.layout.home_vp_images, null);
        ImageView imgBackground = (ImageView) view.findViewById(R.id.imgBackground);
        imgBackground.setImageDrawable(mImages[position]);
        ((ViewPager) container).addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);
    }
}