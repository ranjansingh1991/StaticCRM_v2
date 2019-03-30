package in.semicolonindia.schoolcrm.fragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.semicolonindia.schoolcrm.R;
import in.semicolonindia.schoolcrm.adapters.VideosRVAdapter;

/**
 * Created by Faraz on 03/06/2018.
 */
@SuppressWarnings("ALL")
public class FragmentVideos extends Fragment {

    private RecyclerView rvVideos;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_library_video, container, false);

        init(rootView);

        return rootView;
    }

    private void init(View view) {
        final Typeface appBold = Typeface.createFromAsset(getActivity().getAssets(), "fonts/app_bold.ttf");
        final Typeface appRegular = Typeface.createFromAsset(getActivity().getAssets(), "fonts/app_regular.ttf");
        rvVideos = (RecyclerView) view.findViewById(R.id.rvVideos);
        rvVideos.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvVideos.setAdapter(new VideosRVAdapter(getActivity()));
    }
}
