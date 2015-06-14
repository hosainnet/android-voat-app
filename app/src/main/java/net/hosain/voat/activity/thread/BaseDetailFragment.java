package net.hosain.voat.activity.thread;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import net.hosain.voat.R;
import net.hosain.voat.data.DataEntity;
import net.hosain.voat.data.Subverse;

public abstract class BaseDetailFragment extends Fragment {

    DataEntity mItem;

    protected static Fragment newInstance(String threadId, Fragment fragment) {
        Bundle args = new Bundle();
        args.putString(Integer.toString(R.id.thread_id), threadId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(Integer.toString(R.id.thread_id))) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = Subverse.getThreadWithId(getArguments().getString(Integer.toString(R.id.thread_id)));
        }
    }

}
