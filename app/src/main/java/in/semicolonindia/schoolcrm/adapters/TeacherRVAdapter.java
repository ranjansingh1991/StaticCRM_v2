package in.semicolonindia.schoolcrm.adapters;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import in.semicolonindia.schoolcrm.R;
import in.semicolonindia.schoolcrm.widgets.civ.CircleImageView;

/**
 * Created by Faraz on 03/07/2018.
 */
@SuppressWarnings("ALL")
public class TeacherRVAdapter extends RecyclerView.Adapter<TeacherRVAdapter.ViewHolder> {

    private Activity activity;

    public TeacherRVAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public TeacherRVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.list_item_teachers,
                parent, false);
        return (new TeacherRVAdapter.ViewHolder(view));
    }

    @Override
    public void onBindViewHolder(final TeacherRVAdapter.ViewHolder holder, final int position) {
        final Typeface appBold = Typeface.createFromAsset(activity.getAssets(), "fonts/app_bold.ttf");
        final Typeface appRegular = Typeface.createFromAsset(activity.getAssets(), "fonts/app_regular.ttf");
        holder.tvTeacherName.setTypeface(appBold);
        holder.tvYrOfExp.setTypeface(appRegular);
        holder.tvQualification.setTypeface(appRegular);
        holder.tvRating.setTypeface(appRegular);
        holder.tvChat.setTypeface(appRegular);
        holder.tvCommentGiven.setTypeface(appRegular);
        holder.btnEdit.setTypeface(appRegular);
        holder.etComment.setTypeface(appRegular);

        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.llGiveRating.setVisibility(View.VISIBLE);
                holder.llGivenRating.setVisibility(View.GONE);
            }
        });

        holder.imgBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.llGiveRating.setVisibility(View.GONE);
                holder.llGivenRating.setVisibility(View.VISIBLE);
            }
        });
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

        CircleImageView civTeacherImage;
        TextView tvTeacherName;
        TextView tvYrOfExp;
        TextView tvQualification;
        TextView tvRating;
        TextView tvChat;
        TextView tvCommentGiven;
        LinearLayout llGivenRating;
        LinearLayout llGiveRating;
        RatingBar rbTeacherGiven;
        RatingBar rbTeacher;
        EditText etComment;
        Button btnEdit;
        ImageButton imgBtnBack;
        ImageButton imgBtnGo;

        public ViewHolder(View itemView) {
            super(itemView);
            civTeacherImage = (CircleImageView) itemView.findViewById(R.id.civTeacherImage);
            tvTeacherName = (TextView) itemView.findViewById(R.id.tvTeacherName);
            tvYrOfExp = (TextView) itemView.findViewById(R.id.tvYrOfExp);
            tvQualification = (TextView) itemView.findViewById(R.id.tvQualification);
            tvRating = (TextView) itemView.findViewById(R.id.tvRating);
            tvChat = (TextView) itemView.findViewById(R.id.tvChat);
            tvCommentGiven = (TextView) itemView.findViewById(R.id.tvCommentGiven);
            llGivenRating = (LinearLayout) itemView.findViewById(R.id.llGivenRating);
            llGiveRating = (LinearLayout) itemView.findViewById(R.id.llGiveRating);
            rbTeacherGiven = (RatingBar) itemView.findViewById(R.id.rbTeacherGiven);
            rbTeacher = (RatingBar) itemView.findViewById(R.id.rbTeacher);
            etComment = (EditText) itemView.findViewById(R.id.etComment);
            btnEdit = (Button) itemView.findViewById(R.id.btnEdit);
            imgBtnBack = (ImageButton) itemView.findViewById(R.id.imgBtnBack);
            imgBtnGo = (ImageButton) itemView.findViewById(R.id.imgBtnGo);
        }
    }
}