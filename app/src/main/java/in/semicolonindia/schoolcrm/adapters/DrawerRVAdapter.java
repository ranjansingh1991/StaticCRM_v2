package in.semicolonindia.schoolcrm.adapters;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import in.semicolonindia.schoolcrm.R;
import in.semicolonindia.schoolcrm.SplashActivity;
import in.semicolonindia.schoolcrm.activities.FeedBackActivity;
import in.semicolonindia.schoolcrm.activities.MapActivity;
import in.semicolonindia.schoolcrm.activities.ProfileActivity;
import in.semicolonindia.schoolcrm.activities.SupportActivity;
import in.semicolonindia.schoolcrm.activities.TeacherActivity;
import in.semicolonindia.schoolcrm.widgets.civ.CircleImageView;

/**
 * Created by Faraz on 02/28/2018.
 */
@SuppressWarnings("ALL")
public class DrawerRVAdapter extends RecyclerView.Adapter<DrawerRVAdapter.ViewHolder> {

    private Activity activity;
    private Drawable[] images = new Drawable[10];
    private String[] sTitles = new String[10];
    private DrawerLayout mDrawerLayout;

    public DrawerRVAdapter(Activity activity, DrawerLayout mDrawerLayout) {
        this.activity = activity;
        this.mDrawerLayout = mDrawerLayout;
        images[0] = activity.getResources().getDrawable(R.drawable.ic_person_24px);
        images[1] = activity.getResources().getDrawable(R.drawable.ic_directions_bus_48px);
        images[2] = activity.getResources().getDrawable(R.drawable.ic_person_pin_circle_48px);
        images[3] = activity.getResources().getDrawable(R.drawable.ic_group_24px);
        images[4] = activity.getResources().getDrawable(R.drawable.ic_file_download_24px);
        images[5] = activity.getResources().getDrawable(R.drawable.ic_feedback_24px);
        images[6] = activity.getResources().getDrawable(R.drawable.ic_help_24px);
        images[7] = activity.getResources().getDrawable(R.drawable.ic_update_24px);
        images[8] = activity.getResources().getDrawable(R.drawable.ic_star_24px);
        images[9] = activity.getResources().getDrawable(R.drawable.ic_power_settings_new_24px);
        sTitles[0] = activity.getResources().getString(R.string.profile);
        sTitles[1] = activity.getResources().getString(R.string.transport);
        sTitles[2] = activity.getResources().getString(R.string.kids_location);
        sTitles[3] = activity.getResources().getString(R.string.teachers);
        sTitles[4] = activity.getResources().getString(R.string.downloads);
        sTitles[5] = activity.getResources().getString(R.string.feedback);
        sTitles[6] = activity.getResources().getString(R.string.support);
        sTitles[7] = activity.getResources().getString(R.string.check_for_update);
        sTitles[8] = activity.getResources().getString(R.string.rate_the_app);
        sTitles[9] = activity.getResources().getString(R.string.logout);
    }

    @Override
    public DrawerRVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder mViewHolder;
        View view;
        switch (viewType) {
            case 0:
                view = LayoutInflater.from(activity).inflate(R.layout.list_item_drawer_header,
                        parent, false);
                mViewHolder = new ViewHolder(view, viewType);
                break;
            default:
                view = LayoutInflater.from(activity).inflate(R.layout.list_item_drawer,
                        parent, false);
                mViewHolder = new ViewHolder(view, viewType);
                break;
        }

        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(DrawerRVAdapter.ViewHolder holder, final int position) {
        final Typeface appRegular = Typeface.createFromAsset(activity.getAssets(), "fonts/app_regular.ttf");
        final Typeface appBold = Typeface.createFromAsset(activity.getAssets(), "fonts/app_bold.ttf");
        switch (position) {
            case 0:
                holder.tvUserName.setTypeface(appBold);
                break;
            default:
                images[position - 1].setBounds(0, 0, 60, 60);
                holder.tvDrawerItem.setCompoundDrawables(images[position - 1], null, null, null);
                holder.tvDrawerItem.setText(sTitles[position - 1]);
                holder.tvDrawerItem.setTypeface(appRegular);
                holder.tvDrawerItem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        switch (position) {
                            case 1:
                                activity.startActivity(new Intent(activity, ProfileActivity.class));
                                break;
                            case 2:
                                //  activity.startActivity(new Intent(activity, DonationActivity.class));
                                break;
                            case 3:
                                activity.startActivity(new Intent(activity, MapActivity.class));
                                break;
                            case 4:
                                activity.startActivity(new Intent(activity, TeacherActivity.class));
                                break;
                            case 5:
                                // activity.startActivity(new Intent(activity, SupportActivity.class));
                                break;
                            case 6:
                                 activity.startActivity(new Intent(activity, FeedBackActivity.class));
                                break;
                            case 7:
                                 activity.startActivity(new Intent(activity, SupportActivity.class));
                                break;
                            case 8:
                                // activity.startActivity(new Intent(activity, SupportActivity.class));
                                break;
                            case 9:
                                // activity.startActivity(new Intent(activity, SupportActivity.class));
                                break;
                            case 10:
                                activity.finishAffinity();
                                activity.startActivity(new Intent(activity, SplashActivity.class));
                                break;
                        }
                        mDrawerLayout.closeDrawers();
                    }
                });
                break;
        }
    }

    @Override
    public int getItemCount() {
        return images.length + 1;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView imgUserPic;
        TextView tvUserName;
        TextView tvDrawerItem;

        public ViewHolder(View itemView, int viewType) {
            super(itemView);
            switch (viewType) {
                case 0:
                    imgUserPic = (CircleImageView) itemView.findViewById(R.id.imgUserPic);
                    tvUserName = (TextView) itemView.findViewById(R.id.tvUserName);
                    break;
                default:
                    tvDrawerItem = (TextView) itemView.findViewById(R.id.tvDrawerItem);
                    break;
            }
        }
    }
}