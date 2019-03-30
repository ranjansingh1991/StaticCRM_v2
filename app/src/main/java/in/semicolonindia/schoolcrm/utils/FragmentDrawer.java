package in.semicolonindia.schoolcrm.utils;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import in.semicolonindia.schoolcrm.BuildConfig;
import in.semicolonindia.schoolcrm.R;
import in.semicolonindia.schoolcrm.adapters.DrawerRVAdapter;

/**
 * Created by Faraz on 02/27/2018.
 */
@SuppressWarnings("ALL")
public class FragmentDrawer extends Fragment implements View.OnClickListener {

    private DrawerLayout mDrawerLayout;
    private RecyclerView rvDrawer;
    private TextView tvVersionName;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);

        init(view);

        return view;
    }

    private void init(View view) {
        final Typeface appRegular = Typeface.createFromAsset(getActivity().getAssets(), "fonts/app_regular.ttf");
        rvDrawer = (RecyclerView) view.findViewById(R.id.rvDrawer);
        tvVersionName = (TextView) view.findViewById(R.id.tvVersionName);
        final DisplayMetrics displayMetrics = getActivity().getResources().getDisplayMetrics();
        final LinearLayout llDrawerParent = (LinearLayout) view.findViewById(R.id.llDrawerParent);
        llDrawerParent.setLayoutParams(new LinearLayout.LayoutParams(displayMetrics.widthPixels / 2,
                ViewGroup.LayoutParams.MATCH_PARENT));
        final RelativeLayout rlDrawerParent = (RelativeLayout) view.findViewById(R.id.rlDrawerParent);
        final ImageButton imgBtnBack = (ImageButton) view.findViewById(R.id.imgBtnBack);
        imgBtnBack.bringToFront();
        rlDrawerParent.invalidate();
        imgBtnBack.setOnClickListener(this);

        tvVersionName.setTypeface(appRegular);
        tvVersionName.setText("v" + BuildConfig.VERSION_NAME);
    }

    public void setUp(int fragmentId, DrawerLayout drawerLayout) {
        mDrawerLayout = drawerLayout;
        rvDrawer.setAdapter(new DrawerRVAdapter(getActivity(), mDrawerLayout));
        rvDrawer.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgBtnBack:
                mDrawerLayout.closeDrawers();
                break;
        }
    }
}
