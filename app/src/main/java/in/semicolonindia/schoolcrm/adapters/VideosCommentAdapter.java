package in.semicolonindia.schoolcrm.adapters;

import android.app.Activity;
import android.graphics.Typeface;
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
import in.semicolonindia.schoolcrm.widgets.civ.CircleImageView;

/**
 * Created by Faraz on 03/06/2018.
 */
@SuppressWarnings("ALL")
public class VideosCommentAdapter extends RecyclerView.Adapter<VideosCommentAdapter.ViewHolder> {

    private Activity activity;

    public VideosCommentAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public VideosCommentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        ViewHolder mViewHolder;
        switch (viewType) {
            case 0:
                view = LayoutInflater.from(activity).inflate(R.layout.list_item_video_comment_header,
                        parent, false);
                mViewHolder = new VideosCommentAdapter.ViewHolder(view, viewType);
                break;
            default:
                view = LayoutInflater.from(activity).inflate(R.layout.list_item_comments,
                        parent, false);
                mViewHolder = new VideosCommentAdapter.ViewHolder(view, viewType);
                break;
        }
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(final VideosCommentAdapter.ViewHolder holder, final int position) {
        final Typeface appBold = Typeface.createFromAsset(activity.getAssets(), "fonts/app_bold.ttf");
        final Typeface appRegular = Typeface.createFromAsset(activity.getAssets(), "fonts/app_regular.ttf");
        switch (position) {
            case 0:
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
                break;
            default:
                holder.tvCommentName.setTypeface(appBold);
                holder.tvCommentTime.setTypeface(appRegular);
                holder.tvComment.setTypeface(appRegular);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 14;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements AdapterView.OnItemClickListener {

        CircleImageView civUser;
        CircleImageView civCommentImage;
        ImageView imgOptions;
        TextView tvVideoTitle;
        TextView tvTopic;
        TextView tvViews;
        TextView tvDuration;
        TextView tvComments;
        TextView tvCommentName;
        TextView tvCommentTime;
        TextView tvComment;
        ListPopupWindow listPopupWindow;

        public ViewHolder(View itemView, int viewType) {
            super(itemView);
            switch (viewType) {
                case 0:
                    civUser = (CircleImageView) itemView.findViewById(R.id.civUser);
                    imgOptions = (ImageView) itemView.findViewById(R.id.imgOptions);
                    tvVideoTitle = (TextView) itemView.findViewById(R.id.tvVideoTitle);
                    tvTopic = (TextView) itemView.findViewById(R.id.tvTopic);
                    tvViews = (TextView) itemView.findViewById(R.id.tvViews);
                    tvDuration = (TextView) itemView.findViewById(R.id.tvDuration);
                    tvComments = (TextView) itemView.findViewById(R.id.tvComments);
                    String[] kidNames = {"Save", "Save to"};
                    listPopupWindow = new ListPopupWindow(activity);
                    listPopupWindow.setAdapter(new ArrayAdapter(activity,
                            R.layout.pop_up_menu_item, kidNames));
                    listPopupWindow.setAnchorView(imgOptions);
                    listPopupWindow.setWidth(300);
                    listPopupWindow.setHeight(102 * kidNames.length);
                    listPopupWindow.setModal(true);
                    listPopupWindow.setOnItemClickListener(ViewHolder.this);
                    break;
                default:
                    civCommentImage = (CircleImageView) itemView.findViewById(R.id.civCommentImage);
                    tvCommentName = (TextView) itemView.findViewById(R.id.tvCommentName);
                    tvCommentTime = (TextView) itemView.findViewById(R.id.tvCommentTime);
                    tvComment = (TextView) itemView.findViewById(R.id.tvComment);
                    break;
            }
        }

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            listPopupWindow.dismiss();
        }
    }
}