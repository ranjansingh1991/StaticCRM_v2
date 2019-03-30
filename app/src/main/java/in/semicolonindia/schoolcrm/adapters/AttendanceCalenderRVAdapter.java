package in.semicolonindia.schoolcrm.adapters;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import in.semicolonindia.schoolcrm.R;

/**
 * Created by Faraz on 03/03/2018.
 */
@SuppressWarnings("ALL")
public class AttendanceCalenderRVAdapter extends RecyclerView.Adapter<AttendanceCalenderRVAdapter.ViewHolder> {

    private Activity activity;

    public AttendanceCalenderRVAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public AttendanceCalenderRVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.list_item_calender,
                parent, false);
        return (new AttendanceCalenderRVAdapter.ViewHolder(view));
    }

    @Override
    public void onBindViewHolder(final AttendanceCalenderRVAdapter.ViewHolder holder, final int position) {
        final Typeface appRegular = Typeface.createFromAsset(activity.getAssets(), "fonts/app_regular.ttf");
        holder.tvDate.setTypeface(appRegular);
        holder.tvDate.setText(String.valueOf(position + 1));
        if ((position / 5) == 0) {
            holder.imgIndicator.setImageDrawable(activity.getResources().getDrawable(R.drawable.indicator_failer));
        } else if ((position / 7) == 0) {
            holder.imgIndicator.setImageDrawable(activity.getResources().getDrawable(R.drawable.indicator_undefined));
        } else {
            holder.imgIndicator.setImageDrawable(activity.getResources().getDrawable(R.drawable.indicator_success));
        }
    }

    @Override
    public int getItemCount() {
        Calendar mCal = new GregorianCalendar(Integer.parseInt(new SimpleDateFormat("yyyy")
                .format(new Date())), Integer.parseInt(new SimpleDateFormat("MM")
                .format(new Date())), 1);
        return mCal.getActualMaximum(Calendar.DAY_OF_MONTH) + 1;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgIndicator;
        TextView tvDate;

        public ViewHolder(View itemView) {
            super(itemView);
            imgIndicator = (ImageView) itemView.findViewById(R.id.imgIndicator);
            tvDate = (TextView) itemView.findViewById(R.id.tvDate);
        }
    }
}