package in.semicolonindia.schoolcrm.adapters;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import in.semicolonindia.schoolcrm.R;

/**
 * Created by Faraz on 02/28/2018.
 */
@SuppressWarnings("ALL")
public class HomeNewsRVAdapter extends RecyclerView.Adapter<HomeNewsRVAdapter.ViewHolder> {

    private Activity activity;

    public HomeNewsRVAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.list_item_home_news,
                parent, false);
        return (new ViewHolder(view));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Typeface appRegular = Typeface.createFromAsset(activity.getAssets(), "fonts/app_regular.ttf");
        final DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                ((displayMetrics.widthPixels) - ((displayMetrics.widthPixels) / 4)),
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(20, 0, 0, 0);
        holder.rlItemParent.setLayoutParams(layoutParams);
        holder.llNewsParent.bringToFront();
        holder.rlItemParent.invalidate();
        holder.tvNews.setTypeface(appRegular);
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout rlItemParent;
        ImageView imgItem;
        LinearLayout llNewsParent;
        TextView tvNews;

        public ViewHolder(View itemView) {
            super(itemView);
            rlItemParent = (RelativeLayout) itemView.findViewById(R.id.rlItemParent);
            imgItem = (ImageView) itemView.findViewById(R.id.imgItem);
            llNewsParent = (LinearLayout) itemView.findViewById(R.id.llNewsParent);
            tvNews = (TextView) itemView.findViewById(R.id.tvNews);
        }
    }
}