package net.hosain.voat.activity.thread;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import net.hosain.voat.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class DetailWebFragment extends BaseDetailFragment {

    @InjectView(R.id.thread_webview)
    WebView mThreadWebView;


    public static Fragment newInstance(String threadId) {
        DetailWebFragment fragment = new DetailWebFragment();
        return newInstance(threadId, fragment);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail_web, container, false);

        ButterKnife.inject(this, rootView);

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            WebSettings webSettings = mThreadWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webSettings.setDomStorageEnabled(true);
            mThreadWebView.loadUrl(mItem.getUrl());
        }

        return rootView;
    }
}
