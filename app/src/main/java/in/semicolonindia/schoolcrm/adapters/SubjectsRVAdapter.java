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
 * Created by Faraz on 03/08/2018.
 */
@SuppressWarnings("ALL")
public class SubjectsRVAdapter extends RecyclerView.Adapter<SubjectsRVAdapter.ViewHolder> {

    private Activity activity;

    public SubjectsRVAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public SubjectsRVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.list_item_subjects,
                parent, false);
        return (new SubjectsRVAdapter.ViewHolder(view));
    }

    @Override
    public void onBindViewHolder(final SubjectsRVAdapter.ViewHolder holder, final int position) {
        final Typeface appBold = Typeface.createFromAsset(activity.getAssets(), "fonts/app_bold.ttf");
        final Typeface appRegular = Typeface.createFromAsset(activity.getAssets(), "fonts/app_regular.ttf");
        holder.tvSubjectName.setTypeface(appBold);
        holder.tvTeacher.setTypeface(appRegular);
        holder.tvSession.setTypeface(appRegular);
        holder.tvClass.setTypeface(appRegular);
        holder.tvSection.setTypeface(appRegular);
        holder.btnDownload.setTypeface(appRegular);
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgSubjectIcon;
        TextView tvSubjectName;
        TextView tvTeacher;
        TextView tvSession;
        TextView tvClass;
        TextView tvSection;
        Button btnDownload;

        public ViewHolder(View itemView) {
            super(itemView);
            imgSubjectIcon = (ImageView) itemView.findViewById(R.id.imgSubjectIcon);
            tvSubjectName = (TextView) itemView.findViewById(R.id.tvSubjectName);
            tvTeacher = (TextView) itemView.findViewById(R.id.tvTeacher);
            tvSession = (TextView) itemView.findViewById(R.id.tvSession);
            tvClass = (TextView) itemView.findViewById(R.id.tvClass);
            tvSection = (TextView) itemView.findViewById(R.id.tvSection);
            btnDownload = (Button) itemView.findViewById(R.id.btnDownload);
        }
    }
}