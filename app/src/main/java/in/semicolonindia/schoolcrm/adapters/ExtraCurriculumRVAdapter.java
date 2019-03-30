package in.semicolonindia.schoolcrm.adapters;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import in.semicolonindia.schoolcrm.R;

/**
 * Created by Faraz on 03/09/2018.
 */
@SuppressWarnings("ALL")
public class ExtraCurriculumRVAdapter extends RecyclerView.Adapter<ExtraCurriculumRVAdapter.ViewHolder> {

    private Activity activity;

    public ExtraCurriculumRVAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public ExtraCurriculumRVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.list_item_extra_curriculum,
                parent, false);
        return (new ExtraCurriculumRVAdapter.ViewHolder(view));
    }

    @Override
    public void onBindViewHolder(final ExtraCurriculumRVAdapter.ViewHolder holder, final int position) {
        final Typeface appBold = Typeface.createFromAsset(activity.getAssets(), "fonts/app_bold.ttf");
        final Typeface appRegular = Typeface.createFromAsset(activity.getAssets(), "fonts/app_regular.ttf");
        holder.tvCurriculumName.setTypeface(appBold);
        holder.tvDetails.setTypeface(appRegular);
        holder.tvEligibility.setTypeface(appRegular);
        holder.tvPaymentDate.setTypeface(appRegular);
    }

    @Override
    public int getItemCount() {
        return 9;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgCurriculumIcon;
        TextView tvCurriculumName;
        TextView tvDetails;
        TextView tvEligibility;
        TextView tvPaymentDate;

        public ViewHolder(View itemView) {
            super(itemView);
            imgCurriculumIcon = (ImageView) itemView.findViewById(R.id.imgCurriculumIcon);
            tvCurriculumName = (TextView) itemView.findViewById(R.id.tvCurriculumName);
            tvDetails = (TextView) itemView.findViewById(R.id.tvDetails);
            tvEligibility = (TextView) itemView.findViewById(R.id.tvEligibility);
            tvPaymentDate = (TextView) itemView.findViewById(R.id.tvPaymentDate);
        }
    }
}