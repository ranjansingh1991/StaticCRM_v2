package in.semicolonindia.schoolcrm.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import in.semicolonindia.schoolcrm.R;

/**
 * Created by Faraz on 03/10/2018.
 */
@SuppressWarnings("ALL")
public class AboutUsFragment extends Fragment {

    private WebView webView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.webview, container, false);
        init(rootView);
        return rootView;
    }

    private void init(View rootView) {
        webView = (WebView) rootView.findViewById(R.id.webView);
        String url = "http://semicolonindia.in/";
        webView.loadUrl(url);
    }
}