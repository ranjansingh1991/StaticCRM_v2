package in.semicolonindia.schoolcrm.adapters;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import in.semicolonindia.schoolcrm.R;

/**
 * Created by Faraz on 03/04/2018.
 */
@SuppressWarnings("ALL")
public class GalleryRVAdapter extends RecyclerView.Adapter<GalleryRVAdapter.ViewHolder> {

    private Activity activity;

    public GalleryRVAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public GalleryRVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.list_item_gallery,
                parent, false);
        return (new GalleryRVAdapter.ViewHolder(view));
    }

    @Override
    public void onBindViewHolder(final GalleryRVAdapter.ViewHolder holder, final int position) {
        final Typeface appBold = Typeface.createFromAsset(activity.getAssets(), "fonts/app_bold.ttf");
        final Typeface appRegular = Typeface.createFromAsset(activity.getAssets(), "fonts/app_regular.ttf");
        holder.tvAlbum.setTypeface(appBold);
        holder.tvDate.setTypeface(appRegular);
        holder.rvImages.setLayoutManager(new GridLayoutManager(activity, 2));
        holder.rvImages.setAdapter(new GalleryInnerRVAdapter(activity));
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvAlbum;
        TextView tvDate;
        RecyclerView rvImages;

        public ViewHolder(View itemView) {
            super(itemView);
            tvAlbum = (TextView) itemView.findViewById(R.id.tvAlbum);
            tvDate = (TextView) itemView.findViewById(R.id.tvDate);
            rvImages = (RecyclerView) itemView.findViewById(R.id.rvImages);
        }
    }
}