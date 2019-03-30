package in.semicolonindia.schoolcrm.adapters;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import in.semicolonindia.schoolcrm.R;

/**
 * Created by Faraz on 02/28/2018.
 */
@SuppressWarnings("ALL")
public class HomeNoticeRVAdapter extends RecyclerView.Adapter<HomeNoticeRVAdapter.ViewHolder> {

    private Activity activity;

    public HomeNoticeRVAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public HomeNoticeRVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.list_item_home_noticeboard,
                parent, false);
        return (new HomeNoticeRVAdapter.ViewHolder(view));
    }

    @Override
    public void onBindViewHolder(HomeNoticeRVAdapter.ViewHolder holder, final int position) {
        final Typeface appBold = Typeface.createFromAsset(activity.getAssets(), "fonts/app_bold.ttf");
        final Typeface appRegular = Typeface.createFromAsset(activity.getAssets(), "fonts/app_regular.ttf");
        holder.tvNoticeHeading.setTypeface(appBold);
        holder.tvNoticedBy.setTypeface(appBold);
        holder.tvNoticeDate.setTypeface(appRegular);
        holder.tvNotice.setTypeface(appRegular);
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvNoticeHeading;
        TextView tvNoticeDate;
        TextView tvNotice;
        TextView tvNoticedBy;

        public ViewHolder(View itemView) {
            super(itemView);
            tvNoticeHeading = (TextView) itemView.findViewById(R.id.tvNoticeHeading);
            tvNoticeDate = (TextView) itemView.findViewById(R.id.tvNoticeDate);
            tvNotice = (TextView) itemView.findViewById(R.id.tvNotice);
            tvNoticedBy = (TextView) itemView.findViewById(R.id.tvNoticedBy);
        }
    }
}