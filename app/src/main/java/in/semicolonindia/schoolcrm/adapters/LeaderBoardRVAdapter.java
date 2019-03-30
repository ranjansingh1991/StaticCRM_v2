package in.semicolonindia.schoolcrm.adapters;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.ablanco.zoomy.TapListener;
import com.ablanco.zoomy.Zoomy;

import in.semicolonindia.schoolcrm.R;

/**
 * Created by Faraz on 03/08/2018.
 */
@SuppressWarnings("ALL")
public class LeaderBoardRVAdapter extends RecyclerView.Adapter<LeaderBoardRVAdapter.ViewHolder> {

    private Activity activity;

    public LeaderBoardRVAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public LeaderBoardRVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.list_item_leaderboard,
                parent, false);
        return (new LeaderBoardRVAdapter.ViewHolder(view));
    }

    @Override
    public void onBindViewHolder(final LeaderBoardRVAdapter.ViewHolder holder, final int position) {
        final Typeface appBold = Typeface.createFromAsset(activity.getAssets(), "fonts/app_bold.ttf");
        final Typeface appRegular = Typeface.createFromAsset(activity.getAssets(), "fonts/app_regular.ttf");
        holder.tvTitle.setTypeface(appBold);
        holder.tvGoldWinner.setTypeface(appBold);
        holder.tvSilverWinner.setTypeface(appBold);
        holder.tvBronzeWinner.setTypeface(appBold);
        holder.tvGoldWinClass.setTypeface(appRegular);
        holder.tvGoldWinDate.setTypeface(appRegular);
        holder.tvSilverWinClass.setTypeface(appRegular);
        holder.tvSilverWinDate.setTypeface(appRegular);
        holder.tvBronzeWinClass.setTypeface(appRegular);
        holder.tvBronzeWinDate.setTypeface(appRegular);
        Zoomy.Builder builderGold = new Zoomy.Builder(activity)
                .target(holder.imgGoldWinner)
                .interpolator(new OvershootInterpolator())
                .tapListener(new TapListener() {
                    @Override
                    public void onTap(View v) {

                    }
                });
        builderGold.register();
        Zoomy.Builder builderSilver = new Zoomy.Builder(activity)
                .target(holder.imgSilverWinner)
                .interpolator(new OvershootInterpolator())
                .tapListener(new TapListener() {
                    @Override
                    public void onTap(View v) {

                    }
                });
        builderSilver.register();
        Zoomy.Builder builderBronze = new Zoomy.Builder(activity)
                .target(holder.imgBronzeWinner)
                .interpolator(new OvershootInterpolator())
                .tapListener(new TapListener() {
                    @Override
                    public void onTap(View v) {

                    }
                });
        builderBronze.register();
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

        ImageView imgGoldWinner;
        ImageView imgSilverWinner;
        ImageView imgBronzeWinner;
        TextView tvTitle;
        TextView tvGoldWinner;
        TextView tvGoldWinClass;
        TextView tvGoldWinDate;
        TextView tvSilverWinner;
        TextView tvSilverWinClass;
        TextView tvSilverWinDate;
        TextView tvBronzeWinner;
        TextView tvBronzeWinClass;
        TextView tvBronzeWinDate;

        public ViewHolder(View itemView) {
            super(itemView);
            imgGoldWinner = (ImageView) itemView.findViewById(R.id.imgGoldWinner);
            imgSilverWinner = (ImageView) itemView.findViewById(R.id.imgSilverWinner);
            imgBronzeWinner = (ImageView) itemView.findViewById(R.id.imgBronzeWinner);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvGoldWinner = (TextView) itemView.findViewById(R.id.tvGoldWinner);
            tvGoldWinClass = (TextView) itemView.findViewById(R.id.tvGoldWinClass);
            tvGoldWinDate = (TextView) itemView.findViewById(R.id.tvGoldWinDate);
            tvSilverWinner = (TextView) itemView.findViewById(R.id.tvSilverWinner);
            tvSilverWinClass = (TextView) itemView.findViewById(R.id.tvSilverWinClass);
            tvSilverWinDate = (TextView) itemView.findViewById(R.id.tvSilverWinDate);
            tvBronzeWinner = (TextView) itemView.findViewById(R.id.tvBronzeWinner);
            tvBronzeWinClass = (TextView) itemView.findViewById(R.id.tvBronzeWinClass);
            tvBronzeWinDate = (TextView) itemView.findViewById(R.id.tvBronzeWinDate);
        }
    }
}