package net.hosain.voat.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.hosain.voat.R;
import net.hosain.voat.data.DataEntity;
import net.hosain.voat.data.Subverse;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * A fragment representing a single Thread detail screen.
 * This fragment is either contained in a {@link ThreadListActivity}
 * in two-pane mode (on tablets) or a {@link ThreadDetailActivity}
 * on handsets.
 */
public class ThreadDetailFragment extends Fragment {

    @InjectView(R.id.thread_title)
    TextView mThreadTitle;

    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private DataEntity mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ThreadDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = Subverse.getThreadWithId(getArguments().getString(ARG_ITEM_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_thread_detail, container, false);

        ButterKnife.inject(this, rootView);

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            mThreadTitle.setText(mItem.getContent());
        }

        return rootView;
    }
}
