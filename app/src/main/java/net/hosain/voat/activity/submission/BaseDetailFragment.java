package net.hosain.voat.activity.submission;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import net.hosain.voat.R;
import net.hosain.voat.data.Submission;
import net.hosain.voat.data.Subverse;

public abstract class BaseDetailFragment extends Fragment {

    Submission mItem;

    static Fragment newInstance(String submissionId, Fragment fragment) {
        Bundle args = new Bundle();
        args.putString(Integer.toString(R.id.thread_id), submissionId);
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
            mItem = Subverse.getSubmissionWithId(getArguments().getString(Integer.toString(R.id.thread_id)));
        }
    }

}
