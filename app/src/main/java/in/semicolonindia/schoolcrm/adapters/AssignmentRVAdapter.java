package in.semicolonindia.schoolcrm.adapters;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import in.semicolonindia.schoolcrm.R;

/**
 * Created by Faraz on 03/03/2018.
 */
@SuppressWarnings("ALL")
public class AssignmentRVAdapter extends RecyclerView.Adapter<AssignmentRVAdapter.ViewHolder> {

    private Activity activity;

    public AssignmentRVAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public AssignmentRVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.list_item_assignment,
                parent, false);
        return (new AssignmentRVAdapter.ViewHolder(view));
    }

    @Override
    public void onBindViewHolder(final AssignmentRVAdapter.ViewHolder holder, final int position) {
        final Typeface appBold = Typeface.createFromAsset(activity.getAssets(), "fonts/app_bold.ttf");
        final Typeface appRegular = Typeface.createFromAsset(activity.getAssets(), "fonts/app_regular.ttf");
        holder.tvSubject.setTypeface(appBold);
        holder.tvMarks.setTypeface(appRegular);
        holder.tvUpDate.setTypeface(appRegular);
        holder.tvSubmitDate.setTypeface(appRegular);
        holder.tvContent.setTypeface(appRegular);
        holder.btnDownload.setTypeface(appRegular);
    }

    @Override
    public int getItemCount() {
        return 11;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvSubject;
        TextView tvMarks;
        TextView tvUpDate;
        TextView tvSubmitDate;
        TextView tvContent;
        Button btnDownload;

        public ViewHolder(View itemView) {
            super(itemView);
            tvSubject = (TextView) itemView.findViewById(R.id.tvSubject);
            tvMarks = (TextView) itemView.findViewById(R.id.tvMarks);
            tvUpDate = (TextView) itemView.findViewById(R.id.tvUpDate);
            tvSubmitDate = (TextView) itemView.findViewById(R.id.tvSubmitDate);
            tvContent = (TextView) itemView.findViewById(R.id.tvContent);
            btnDownload = (Button) itemView.findViewById(R.id.btnDownload);
        }
    }
}