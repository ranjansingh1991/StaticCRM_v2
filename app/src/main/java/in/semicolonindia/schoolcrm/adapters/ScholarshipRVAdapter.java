package in.semicolonindia.schoolcrm.adapters;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import in.semicolonindia.schoolcrm.R;

/**
 * Created by Faraz on 03/09/2018.
 */
@SuppressWarnings("ALL")
public class ScholarshipRVAdapter extends RecyclerView.Adapter<ScholarshipRVAdapter.ViewHolder> {

    private Activity activity;

    public ScholarshipRVAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public ScholarshipRVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.list_item_scholarship,
                parent, false);
        return (new ScholarshipRVAdapter.ViewHolder(view));
    }

    @Override
    public void onBindViewHolder(final ScholarshipRVAdapter.ViewHolder holder, final int position) {
        final Typeface appBold = Typeface.createFromAsset(activity.getAssets(), "fonts/app_bold.ttf");
        final Typeface appRegular = Typeface.createFromAsset(activity.getAssets(), "fonts/app_regular.ttf");
        holder.tvScholarshipName.setTypeface(appBold);
        holder.tvDetails.setTypeface(appRegular);
        holder.tvEligibility.setTypeface(appRegular);
        holder.tvScholarshipDate.setTypeface(appRegular);
        holder.btnApplyNow.setTypeface(appRegular);
    }

    @Override
    public int getItemCount() {
        return 9;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgScholarshipIcon;
        TextView tvScholarshipName;
        TextView tvDetails;
        TextView tvEligibility;
        TextView tvScholarshipDate;
        Button btnApplyNow;

        public ViewHolder(View itemView) {
            super(itemView);
            imgScholarshipIcon = (ImageView) itemView.findViewById(R.id.imgScholarshipIcon);
            tvScholarshipName = (TextView) itemView.findViewById(R.id.tvScholarshipName);
            tvDetails = (TextView) itemView.findViewById(R.id.tvDetails);
            tvEligibility = (TextView) itemView.findViewById(R.id.tvEligibility);
            tvScholarshipDate = (TextView) itemView.findViewById(R.id.tvScholarshipDate);
            btnApplyNow = (Button) itemView.findViewById(R.id.btnApplyNow);
        }
    }
}