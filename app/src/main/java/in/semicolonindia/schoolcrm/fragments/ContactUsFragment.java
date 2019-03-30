package in.semicolonindia.schoolcrm.fragments;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import in.semicolonindia.schoolcrm.R;
import in.semicolonindia.schoolcrm.utils.Constraints;

/**
 * Created by Faraz on 03/10/2018.
 */
@SuppressWarnings("ALL")
public class ContactUsFragment extends Fragment implements View.OnClickListener{

    private TextView tvTitle;
    private TextView tvCompanyNo;
    private TextView tvCompanyEmail;
    private TextView tvCompanyAddress;
    private TextView tvGoToMap;
    private ImageButton imgBtnFacebook;
    private ImageButton imgBtnGPlus;
    private ImageButton imgBtnTwitter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_contact_us, container, false);
        init(rootView);
        return rootView;
    }

    private void init(View rootView) {
        final Typeface appBold = Typeface.createFromAsset(getActivity().getAssets(), "fonts/app_bold.ttf");
        Typeface appRegular = Typeface.createFromAsset(getActivity().getAssets(), "fonts/app_regular.ttf");
        tvTitle = (TextView) rootView.findViewById(R.id.tvTitle);
        tvCompanyNo = (TextView) rootView.findViewById(R.id.tvCompanyNo);
        tvCompanyEmail = (TextView) rootView.findViewById(R.id.tvCompanyEmail);
        tvCompanyAddress = (TextView) rootView.findViewById(R.id.tvCompanyAddress);
        tvGoToMap = (TextView) rootView.findViewById(R.id.tvGoToMap);
        imgBtnFacebook = (ImageButton) rootView.findViewById(R.id.imgBtnFacebook);
        imgBtnGPlus = (ImageButton) rootView.findViewById(R.id.imgBtnGPlus);
        imgBtnTwitter = (ImageButton) rootView.findViewById(R.id.imgBtnTwitter);
        final RelativeLayout rlMap = (RelativeLayout) rootView.findViewById(R.id.rlMap);
        final View viewLocation = (View) rootView.findViewById(R.id.viewLocation);
        final LinearLayout llMap = (LinearLayout) rootView.findViewById(R.id.llMap);
        tvTitle.setTypeface(appBold);
        tvCompanyNo.setTypeface(appRegular);
        tvCompanyEmail.setTypeface(appRegular);
        tvCompanyAddress.setTypeface(appRegular);
        tvGoToMap.setTypeface(appRegular);
        llMap.bringToFront();
        rlMap.invalidate();
        tvTitle.setTypeface(appRegular);
        tvCompanyNo.setTypeface(appRegular);
        tvCompanyEmail.setTypeface(appRegular);
        tvCompanyAddress.setTypeface(appRegular);
        tvGoToMap.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvGoToMap:
                String geoUri = "http://maps.google.com/maps?q=loc:" + Constraints.Latitute + "," +
                        Constraints.Longitute + " (" + getActivity().getResources().getString(R.string.app_name) + ")";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(geoUri));
                getActivity().startActivity(intent);
                break;
        }
    }
}