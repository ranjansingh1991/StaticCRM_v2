package in.semicolonindia.schoolcrm.adapters;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import in.semicolonindia.schoolcrm.R;

/**
 * Created by Faraz on 03/01/2018.
 */
@SuppressWarnings("ALL")
public class ClassRoutineLVAdapter extends BaseAdapter {

    private Activity activity;

    public ClassRoutineLVAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return 20;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = LayoutInflater.from(activity).inflate(R.layout.list_item_class_routine, null);
            holder.tvRoutineHeading = (TextView) view.findViewById(R.id.tvRoutineHeading);
            holder.tvRoutineTime = (TextView) view.findViewById(R.id.tvRoutineTime);
            holder.imgSubjectPic = (ImageView) view.findViewById(R.id.imgSubjectPic);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        Typeface appFontBold = Typeface.createFromAsset(activity.getAssets(), "fonts/app_bold.ttf");
        Typeface appFontRegular = Typeface.createFromAsset(activity.getAssets(), "fonts/app_regular.ttf");
        holder.tvRoutineHeading.setTypeface(appFontBold);
        holder.tvRoutineTime.setTypeface(appFontRegular);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

            }
        });

        return view;
    }

    public class ViewHolder {

        TextView tvRoutineHeading;
        TextView tvRoutineTime;
        ImageView imgSubjectPic;
    }
}