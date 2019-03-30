package in.semicolonindia.schoolcrm.fragments;

import android.animation.ValueAnimator;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import in.semicolonindia.schoolcrm.R;

/**
 * Created by Faraz on 03/05/2018.
 */
@SuppressWarnings("ALL")
public class FragmentLibHome extends Fragment {

    TextView tvTitle;
    TextView tvCaption;
    TextView tvPDFCount;
    TextView tvVideoCount;
    TextView tvSubscriptionTitle;
    TextView tvExpDate;
    TextView tvReadCount;
    TextView tvReadTitle;
    TextView tvSavedBookCount;
    TextView tvSavedBookTitle;
    TextView tvWatchedCount;
    TextView tvWatchedTitle;
    TextView tvSavedVideoCount;
    TextView tvSavedVideoTitle;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_library_home, container, false);

        init(rootView);

        return rootView;
    }

    private void init(View view) {
        final Typeface appBold = Typeface.createFromAsset(getActivity().getAssets(), "fonts/app_bold.ttf");
        final Typeface appRegular = Typeface.createFromAsset(getActivity().getAssets(), "fonts/app_regular.ttf");

        tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        tvCaption = (TextView) view.findViewById(R.id.tvCaption);
        tvPDFCount = (TextView) view.findViewById(R.id.tvPDFCount);
        tvVideoCount = (TextView) view.findViewById(R.id.tvVideoCount);
        tvSubscriptionTitle = (TextView) view.findViewById(R.id.tvSubscriptionTitle);
        tvExpDate = (TextView) view.findViewById(R.id.tvExpDate);
        tvReadCount = (TextView) view.findViewById(R.id.tvReadCount);
        tvReadTitle = (TextView) view.findViewById(R.id.tvReadTitle);
        tvSavedBookCount = (TextView) view.findViewById(R.id.tvSavedBookCount);
        tvSavedBookTitle = (TextView) view.findViewById(R.id.tvSavedBookTitle);
        tvWatchedCount = (TextView) view.findViewById(R.id.tvWatchedCount);
        tvWatchedTitle = (TextView) view.findViewById(R.id.tvWatchedTitle);
        tvSavedVideoCount = (TextView) view.findViewById(R.id.tvSavedVideoCount);
        tvSavedVideoTitle = (TextView) view.findViewById(R.id.tvSavedVideoTitle);

        tvTitle.setTypeface(appBold);
        tvCaption.setTypeface(appRegular);
        tvPDFCount.setTypeface(appRegular);
        tvVideoCount.setTypeface(appRegular);
        tvSubscriptionTitle.setTypeface(appBold);
        tvExpDate.setTypeface(appRegular);
        tvReadCount.setTypeface(appRegular);
        tvReadTitle.setTypeface(appRegular);
        tvSavedBookCount.setTypeface(appRegular);
        tvSavedBookTitle.setTypeface(appRegular);
        tvWatchedCount.setTypeface(appRegular);
        tvWatchedTitle.setTypeface(appRegular);
        tvSavedVideoCount.setTypeface(appRegular);
        tvSavedVideoTitle.setTypeface(appRegular);

        startCountAnimation(tvPDFCount, Integer.parseInt(tvPDFCount.getText().toString()));
        startCountAnimation(tvVideoCount, Integer.parseInt(tvVideoCount.getText().toString()));
        startCountAnimation(tvReadCount, Integer.parseInt(tvReadCount.getText().toString()));
        startCountAnimation(tvSavedBookCount, Integer.parseInt(tvSavedBookCount.getText().toString()));
        startCountAnimation(tvWatchedCount, Integer.parseInt(tvWatchedCount.getText().toString()));
        startCountAnimation(tvSavedVideoCount, Integer.parseInt(tvSavedVideoCount.getText().toString()));
    }

    /* Count Animator*/
    private void startCountAnimation(final TextView target, final int to) {
        ValueAnimator animator = ValueAnimator.ofInt(0, to);
        animator.setDuration(2500);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                target.setText(animation.getAnimatedValue().toString());
            }
        });
        animator.start();
    }
}