package in.semicolonindia.schoolcrm.adapters;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import in.semicolonindia.schoolcrm.R;
import in.semicolonindia.schoolcrm.activities.FullScreenImageActivity;

/**
 * Created by Faraz on 03/04/2018.
 */
@SuppressWarnings("ALL")
public class GalleryInnerRVAdapter extends RecyclerView.Adapter<GalleryInnerRVAdapter.ViewHolder> {

    private Activity activity;

    public GalleryInnerRVAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public GalleryInnerRVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.list_item_images,
                parent, false);
        return (new GalleryInnerRVAdapter.ViewHolder(view));
    }

    @Override
    public void onBindViewHolder(final GalleryInnerRVAdapter.ViewHolder holder, final int position) {
        final Typeface appBold = Typeface.createFromAsset(activity.getAssets(), "fonts/app_bold.ttf");
        holder.tvImageCounts.setTypeface(appBold);
        holder.tvImageCounts.setText("+5");
        holder.imgItem.setImageDrawable(activity.getResources().getDrawable(R.drawable.dummy_image));
        holder.imgItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.startActivity(new Intent(activity, FullScreenImageActivity.class));
            }
        });

        if (position < 3) {
            holder.tvImageCounts.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgItem;
        TextView tvImageCounts;

        public ViewHolder(View itemView) {
            super(itemView);
            final RelativeLayout rlImagesParent = (RelativeLayout) itemView.findViewById(R.id.rlImagesParent);
            imgItem = (ImageView) itemView.findViewById(R.id.imgItem);
            tvImageCounts = (TextView) itemView.findViewById(R.id.tvImageCounts);
            tvImageCounts.bringToFront();
            rlImagesParent.invalidate();
        }
    }
}