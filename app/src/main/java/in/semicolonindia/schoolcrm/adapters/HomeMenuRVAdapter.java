package in.semicolonindia.schoolcrm.adapters;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import in.semicolonindia.schoolcrm.R;
import in.semicolonindia.schoolcrm.activities.AssignmentActivity;
import in.semicolonindia.schoolcrm.activities.AttendanceActivity;
import in.semicolonindia.schoolcrm.activities.ClassRoutineActivity;
import in.semicolonindia.schoolcrm.activities.ExamMarksActivity;
import in.semicolonindia.schoolcrm.activities.ExtraCurriculumActivity;
import in.semicolonindia.schoolcrm.activities.GalleryActivity;
import in.semicolonindia.schoolcrm.activities.LeaderBoardActivity;
import in.semicolonindia.schoolcrm.activities.LibraryActivity;
import in.semicolonindia.schoolcrm.activities.PaymentsActivity;
import in.semicolonindia.schoolcrm.activities.ScholarshipActivity;
import in.semicolonindia.schoolcrm.activities.StudyMaterialActivity;
import in.semicolonindia.schoolcrm.activities.SubjectsActivity;

/**
 * Created by Faraz on 02/28/2018.
 */
@SuppressWarnings("ALL")
public class HomeMenuRVAdapter extends RecyclerView.Adapter<HomeMenuRVAdapter.ViewHolder> {

    private Activity activity;
    private Drawable[] drawables = new Drawable[12];
    private String[] title = new String[12];

    public HomeMenuRVAdapter(Activity activity) {
        this.activity = activity;
        drawables[0] = activity.getResources().getDrawable(R.drawable.ic_assignment);
        drawables[1] = activity.getResources().getDrawable(R.drawable.ic_attendence_24px);
        drawables[2] = activity.getResources().getDrawable(R.drawable.ic_class_routine);
        drawables[3] = activity.getResources().getDrawable(R.drawable.ic_exam_marks);
        drawables[4] = activity.getResources().getDrawable(R.drawable.ic_study_mat);
        drawables[5] = activity.getResources().getDrawable(R.drawable.ic_library);
        drawables[6] = activity.getResources().getDrawable(R.drawable.ic_payment);
        drawables[7] = activity.getResources().getDrawable(R.drawable.ic_book);
        drawables[8] = activity.getResources().getDrawable(R.drawable.ic_badge);
        drawables[9] = activity.getResources().getDrawable(R.drawable.ic_gallery);
        drawables[10] = activity.getResources().getDrawable(R.drawable.ic_money);
        drawables[11] = activity.getResources().getDrawable(R.drawable.ic_extra_activities);
        title[0] = activity.getResources().getString(R.string.assignment);
        title[1] = activity.getResources().getString(R.string.attendance);
        title[2] = activity.getResources().getString(R.string.class_routine);
        title[3] = activity.getResources().getString(R.string.exam_marks);
        title[4] = activity.getResources().getString(R.string.study_material);
        title[5] = activity.getResources().getString(R.string.library);
        title[6] = activity.getResources().getString(R.string.payment);
        title[7] = activity.getResources().getString(R.string.subjects);
        title[8] = activity.getResources().getString(R.string.leader_board);
        title[9] = activity.getResources().getString(R.string.gallery);
        title[10] = activity.getResources().getString(R.string.scholarship);
        title[11] = activity.getResources().getString(R.string.extra_curriculum_activities);
    }

    @Override
    public HomeMenuRVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.list_item_home_menu,
                parent, false);
        return (new ViewHolder(view));
    }

    @Override
    public void onBindViewHolder(HomeMenuRVAdapter.ViewHolder holder, final int position) {
        final Typeface appRegular = Typeface.createFromAsset(activity.getAssets(), "fonts/app_regular.ttf");
        holder.tvItem.setText(title[position]);
        drawables[position].setBounds(0, 0, 60, 60);
        holder.tvItem.setCompoundDrawables(null, drawables[position], null, null);
        holder.tvItem.setTypeface(appRegular);
        holder.tvItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (position) {
                    case 0:
                        activity.startActivity(new Intent(activity, AssignmentActivity.class));
                        break;
                    case 1:
                        activity.startActivity(new Intent(activity, AttendanceActivity.class));
                        break;
                    case 2:
                        activity.startActivity(new Intent(activity, ClassRoutineActivity.class));
                        break;
                    case 3:
                        activity.startActivity(new Intent(activity, ExamMarksActivity.class));
                        break;
                    case 4:
                        activity.startActivity(new Intent(activity, StudyMaterialActivity.class));
                        break;
                    case 5:
                        activity.startActivity(new Intent(activity, LibraryActivity.class));
                        break;
                    case 6:
                        activity.startActivity(new Intent(activity, PaymentsActivity.class));
                        break;
                    case 7:
                        activity.startActivity(new Intent(activity, SubjectsActivity.class));
                        break;
                    case 8:
                        activity.startActivity(new Intent(activity, LeaderBoardActivity.class));
                        break;
                    case 9:
                        activity.startActivity(new Intent(activity, GalleryActivity.class));
                        break;
                    case 10:
                        activity.startActivity(new Intent(activity, ScholarshipActivity.class));
                        break;
                    case 11:
                        activity.startActivity(new Intent(activity, ExtraCurriculumActivity.class));
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return title.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvItem;

        public ViewHolder(View itemView) {
            super(itemView);
            tvItem = (TextView) itemView.findViewById(R.id.tvItem);
        }
    }
}