package in.semicolonindia.schoolcrm.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.semicolonindia.schoolcrm.R;

/**
 * Created by Faraz on 03/07/2018.
 */
@SuppressWarnings("ALL")
public class FragmentPDFs extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_pdfs, container, false);

        init(rootView);

        return rootView;
    }

    private void init(View view) {

    }
}