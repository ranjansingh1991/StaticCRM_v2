package in.semicolonindia.schoolcrm.adapters;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.CountDownTimer;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import in.semicolonindia.schoolcrm.R;
import in.semicolonindia.schoolcrm.widgets.ap.ArcProgress;

/**
 * Created by Faraz on 03/02/2018.
 */
@SuppressWarnings("ALL")
public class AttendanceRVAdapter extends RecyclerView.Adapter<AttendanceRVAdapter.ViewHolder> {

    private Activity activity;

    public AttendanceRVAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public AttendanceRVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.list_item_attendance,
                parent, false);
        return (new AttendanceRVAdapter.ViewHolder(view));
    }

    @Override
    public void onBindViewHolder(final AttendanceRVAdapter.ViewHolder holder, final int position) {
        final Typeface appBold = Typeface.createFromAsset(activity.getAssets(), "fonts/app_bold.ttf");
        final Typeface appRegular = Typeface.createFromAsset(activity.getAssets(), "fonts/app_regular.ttf");
        new CountDownTimer(2000, 10) {

            @Override
            public void onTick(long l) {
                if (holder.apAttendanceRation.getProgress() < 80) {
                    holder.apAttendanceRation.setProgress(holder.apAttendanceRation.getProgress() + 1);
                }
            }

            @Override
            public void onFinish() {

            }
        }.start();

        holder.tvKidName.setTypeface(appBold);
        holder.tvSubjectName.setTypeface(appRegular);
        holder.tvTeacherName.setTypeface(appRegular);
        holder.tvMonthYear.setTypeface(appBold);

        holder.rvAttendanceCalender.setLayoutManager(new GridLayoutManager(activity, 7));
        holder.rvAttendanceCalender.setAdapter(new AttendanceCalenderRVAdapter(activity));
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvKidName;
        TextView tvSubjectName;
        TextView tvTeacherName;
        TextView tvMonthYear;
        ArcProgress apAttendanceRation;
        ImageButton imgBtnRight;
        ImageButton imgBtnLeft;
        RecyclerView rvAttendanceCalender;

        public ViewHolder(View itemView) {
            super(itemView);
            tvKidName = (TextView) itemView.findViewById(R.id.tvKidName);
            tvSubjectName = (TextView) itemView.findViewById(R.id.tvSubjectName);
            tvTeacherName = (TextView) itemView.findViewById(R.id.tvTeacherName);
            tvMonthYear = (TextView) itemView.findViewById(R.id.tvMonthYear);
            apAttendanceRation = (ArcProgress) itemView.findViewById(R.id.apAttendanceRation);
            imgBtnRight = (ImageButton) itemView.findViewById(R.id.imgBtnRight);
            imgBtnLeft = (ImageButton) itemView.findViewById(R.id.imgBtnLeft);
            rvAttendanceCalender = (RecyclerView) itemView.findViewById(R.id.rvAttendanceCalender);
        }
    }
}