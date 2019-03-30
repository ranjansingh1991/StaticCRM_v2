package in.semicolonindia.schoolcrm.adapters;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.CountDownTimer;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import in.semicolonindia.schoolcrm.R;
import in.semicolonindia.schoolcrm.widgets.ap.ArcProgress;

/**
 * Created by Faraz on 02/28/2018.
 */
@SuppressWarnings("ALL")
public class HomeGraphRVAdapter extends RecyclerView.Adapter<HomeGraphRVAdapter.ViewHolder> {

    private Activity activity;

    public HomeGraphRVAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public HomeGraphRVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.list_item_home_performance,
                parent, false);
        return (new HomeGraphRVAdapter.ViewHolder(view));
    }

    @Override
    public void onBindViewHolder(final HomeGraphRVAdapter.ViewHolder holder, final int position) {
        final Typeface appRegular = Typeface.createFromAsset(activity.getAssets(), "fonts/app_regular.ttf");
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        holder.tvAveragePerformance.setTypeface(appRegular);
        holder.tvAveragePerformance.setText("Rupesh's " + holder.tvAveragePerformance.getText().toString());
        new CountDownTimer(2000, 10) {

            @Override
            public void onTick(long l) {
                if (holder.apPerformanceRation.getProgress() < 80) {
                    holder.apPerformanceRation.setProgress(holder.apPerformanceRation.getProgress() + 1);
                }
            }

            @Override
            public void onFinish() {

            }
        }.start();
        holder.performanceGraph.addSeries(series);
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvAveragePerformance;
        ArcProgress apPerformanceRation;
        GraphView performanceGraph;

        public ViewHolder(View itemView) {
            super(itemView);
            tvAveragePerformance = (TextView) itemView.findViewById(R.id.tvAveragePerformance);
            apPerformanceRation = (ArcProgress) itemView.findViewById(R.id.apPerformanceRation);
            performanceGraph = (GraphView) itemView.findViewById(R.id.performanceGraph);
        }
    }
}