package net.hosain.voat.activity.thread;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.hosain.voat.R;


public class DetailCommentsFragment extends Fragment {

    public static DetailCommentsFragment newInstance(String threadId) {
        DetailCommentsFragment fragment = new DetailCommentsFragment();
        Bundle args = new Bundle();
        args.putString(Integer.toString(R.id.thread_id), threadId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_comments, container, false);
    }


}
