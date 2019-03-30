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
 * Created by Faraz on 03/04/2018.
 */
@SuppressWarnings("ALL")
public class StudyMatRVAdapter extends RecyclerView.Adapter<StudyMatRVAdapter.ViewHolder> {

    private Activity activity;

    public StudyMatRVAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public StudyMatRVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.list_item_study_mat,
                parent, false);
        return (new StudyMatRVAdapter.ViewHolder(view));
    }

    @Override
    public void onBindViewHolder(final StudyMatRVAdapter.ViewHolder holder, final int position) {
        final Typeface appBold = Typeface.createFromAsset(activity.getAssets(), "fonts/app_bold.ttf");
        final Typeface appRegular = Typeface.createFromAsset(activity.getAssets(), "fonts/app_regular.ttf");
        holder.tvTopic.setTypeface(appBold);
        holder.tvUpDate.setTypeface(appRegular);
        holder.tvSubject.setTypeface(appRegular);
        holder.tvClass.setTypeface(appRegular);
        holder.tvContent.setTypeface(appRegular);
        holder.btnDownload.setTypeface(appRegular);
    }

    @Override
    public int getItemCount() {
        return 11;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTopic;
        TextView tvUpDate;
        TextView tvSubject;
        TextView tvClass;
        TextView tvContent;
        Button btnDownload;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTopic = (TextView) itemView.findViewById(R.id.tvTopic);
            tvUpDate = (TextView) itemView.findViewById(R.id.tvUpDate);
            tvSubject = (TextView) itemView.findViewById(R.id.tvSubject);
            tvClass = (TextView) itemView.findViewById(R.id.tvClass);
            tvContent = (TextView) itemView.findViewById(R.id.tvContent);
            btnDownload = (Button) itemView.findViewById(R.id.btnDownload);
        }
    }
}