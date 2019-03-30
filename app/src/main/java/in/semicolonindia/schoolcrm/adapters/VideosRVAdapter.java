package in.semicolonindia.schoolcrm.adapters;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListPopupWindow;
import android.widget.TextView;

import in.semicolonindia.schoolcrm.R;
import in.semicolonindia.schoolcrm.activities.VideoLibActivity;
import in.semicolonindia.schoolcrm.widgets.civ.CircleImageView;

/**
 * Created by Faraz on 03/06/2018.
 */
@SuppressWarnings("ALL")
public class VideosRVAdapter extends RecyclerView.Adapter<VideosRVAdapter.ViewHolder> {

    private Activity activity;

    public VideosRVAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public VideosRVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.list_item_videos,
                parent, false);
        return (new VideosRVAdapter.ViewHolder(view));
    }

    @Override
    public void onBindViewHolder(final VideosRVAdapter.ViewHolder holder, final int position) {
        final Typeface appBold = Typeface.createFromAsset(activity.getAssets(), "fonts/app_bold.ttf");
        final Typeface appRegular = Typeface.createFromAsset(activity.getAssets(), "fonts/app_regular.ttf");
        holder.tvVideoTitle.setTypeface(appBold);
        holder.tvTopic.setTypeface(appRegular);
        holder.tvViews.setTypeface(appRegular);
        holder.tvDuration.setTypeface(appRegular);
        holder.tvComments.setTypeface(appRegular);

        holder.imgOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.listPopupWindow.show();
            }
        });

        holder.imgThumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.startActivity(new Intent(activity, VideoLibActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return 11;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements AdapterView.OnItemClickListener {

        CircleImageView civUser;
        TextView tvVideoTitle;
        TextView tvTopic;
        TextView tvViews;
        TextView tvDuration;
        TextView tvComments;
        AppCompatImageView imgOptions;
        ImageView imgThumbnail;
        ListPopupWindow listPopupWindow;

        public ViewHolder(View itemView) {
            super(itemView);
            civUser = (CircleImageView) itemView.findViewById(R.id.civUser);
            tvVideoTitle = (TextView) itemView.findViewById(R.id.tvVideoTitle);
            tvTopic = (TextView) itemView.findViewById(R.id.tvTopic);
            tvViews = (TextView) itemView.findViewById(R.id.tvViews);
            tvDuration = (TextView) itemView.findViewById(R.id.tvDuration);
            tvComments = (TextView) itemView.findViewById(R.id.tvComments);
            imgOptions = (AppCompatImageView) itemView.findViewById(R.id.imgOptions);
            imgThumbnail = (ImageView) itemView.findViewById(R.id.imgThumbnail);
            String[] optionNames = {"Save", "Save to"};
            listPopupWindow = new ListPopupWindow(activity);
            listPopupWindow.setAdapter(new ArrayAdapter(activity,
                    R.layout.pop_up_menu_item, optionNames));
            listPopupWindow.setAnchorView(imgOptions);
            listPopupWindow.setWidth(300);
            listPopupWindow.setHeight(102 * optionNames.length);
            listPopupWindow.setModal(true);
            listPopupWindow.setOnItemClickListener(ViewHolder.this);
        }

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            listPopupWindow.dismiss();
        }
    }
}