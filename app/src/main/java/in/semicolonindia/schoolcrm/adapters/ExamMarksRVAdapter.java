package in.semicolonindia.schoolcrm.adapters;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import in.semicolonindia.schoolcrm.R;
import in.semicolonindia.schoolcrm.widgets.npb.NumberProgressBar;

/**
 * Created by Faraz on 03/03/2018.
 */
@SuppressWarnings("ALL")
public class ExamMarksRVAdapter extends RecyclerView.Adapter<ExamMarksRVAdapter.ViewHolder> {

    String[] sTemp = new String[7];
    private Activity activity;

    public ExamMarksRVAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        ViewHolder mViewHolder;
        if (viewType == sTemp.length) {
            view = LayoutInflater.from(activity).inflate(R.layout.marks_graph,
                    parent, false);
            mViewHolder = new ViewHolder(view, viewType);
        } else {
            view = LayoutInflater.from(activity).inflate(R.layout.list_item_exam_marks,
                    parent, false);
            mViewHolder = new ViewHolder(view, viewType);
        }
        return (mViewHolder);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Typeface appRegular = Typeface.createFromAsset(activity.getAssets(), "fonts/app_regular.ttf");
        final Typeface appBold = Typeface.createFromAsset(activity.getAssets(), "fonts/app_bold.ttf");
        if (position == sTemp.length) {
            holder.tvPerformance.setTypeface(appBold);
            ArrayList<BarEntry> entries = new ArrayList<>();
            entries.add(new BarEntry(30f, 0));
            entries.add(new BarEntry(20f, 1));
            entries.add(new BarEntry(78f, 2));
            entries.add(new BarEntry(40f, 3));
            entries.add(new BarEntry(10f, 4));
            entries.add(new BarEntry(60f, 5));
            entries.add(new BarEntry(99f, 6));

            BarDataSet bardataset = new BarDataSet(entries, "MARKS");

            ArrayList<String> labels = new ArrayList<String>();
            labels.add("Maths");
            labels.add("Physics");
            labels.add("Chemistry");
            labels.add("Biology");
            labels.add("English");
            labels.add("Hindi");
            labels.add("Geography");

            BarData data = new BarData(labels, bardataset);
            holder.bcExamMarks.setData(data);
            holder.bcExamMarks.setDescription("EXAM MARKS");
            bardataset.setColors(new int[]{0xFF4FD2C2});
            holder.bcExamMarks.setBorderColor(0xFF4FD2C2);
            holder.bcExamMarks.animateY(1500);
        } else {
            holder.tvSubject.setTypeface(appBold);
            holder.tvGrade.setTypeface(appRegular);
            holder.tvTotal.setTypeface(appRegular);
            holder.tvRemarkTitle.setTypeface(appBold);
            holder.tvRemark.setTypeface(appRegular);
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            holder.npbMarks.incrementProgressBy(1);
                        }
                    });
                }
            }, 1000, 100);
        }
    }

    @Override
    public int getItemCount() {
        return sTemp.length + 1;
    }


    @Override
    public int getItemViewType(int position) {
        return position;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvSubject;
        TextView tvGrade;
        TextView tvTotal;
        TextView tvRemarkTitle;
        TextView tvRemark;
        TextView tvPerformance;
        NumberProgressBar npbMarks;
        BarChart bcExamMarks;

        public ViewHolder(View itemView, int viewType) {
            super(itemView);
            if (viewType == sTemp.length) {
                tvPerformance = (TextView) itemView.findViewById(R.id.tvPerformance);
                bcExamMarks = (BarChart) itemView.findViewById(R.id.bcExamMarks);
            } else {
                tvSubject = (TextView) itemView.findViewById(R.id.tvSubject);
                tvGrade = (TextView) itemView.findViewById(R.id.tvGrade);
                tvTotal = (TextView) itemView.findViewById(R.id.tvTotal);
                tvRemarkTitle = (TextView) itemView.findViewById(R.id.tvRemarkTitle);
                tvRemark = (TextView) itemView.findViewById(R.id.tvRemark);
                npbMarks = (NumberProgressBar) itemView.findViewById(R.id.npbMarks);
            }
        }
    }
}