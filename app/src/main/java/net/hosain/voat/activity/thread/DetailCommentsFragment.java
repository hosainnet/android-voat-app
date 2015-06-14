package net.hosain.voat.activity.thread;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.hosain.voat.R;


public class DetailCommentsFragment extends BaseDetailFragment {


    public static Fragment newInstance(String threadId) {
        DetailCommentsFragment fragment = new DetailCommentsFragment();
        return newInstance(threadId, fragment);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail_comments, container, false);


        return view;
    }

}
