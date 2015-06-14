package net.hosain.voat.activity.subverse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import net.hosain.voat.R;
import net.hosain.voat.VoatApp;
import net.hosain.voat.activity.thread.DetailActivity;
import net.hosain.voat.activity.thread.DetailWebFragment;


/**
 * An activity representing a list of Threads. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link DetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 * <p/>
 * The activity makes heavy use of fragments. The list of items is a
 * {@link SubverseFragment} and the item details
 * (if present) is a {@link DetailWebFragment}.
 * <p/>
 * This activity also implements the required
 * {@link SubverseFragment.Callbacks} interface
 * to listen for item selections.
 */
public class SubverseActivity extends FragmentActivity
        implements SubverseFragment.Callbacks {


    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_list);
        VoatApp.component.inject(this);

        if (findViewById(R.id.thread_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-large and
            // res/values-sw600dp). If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;

            // In two-pane mode, list items should be given the
            // 'activated' state when touched.
            ((SubverseFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.thread_list))
                    .setActivateOnItemClick(true);
        }

        // TODO: If exposing deep links into your app, handle intents here.
    }

    /**
     * Callback method from {@link SubverseFragment.Callbacks}
     * indicating that the item with the given ID was selected.
     */
    @Override
    public void onItemSelected(String id) {
        if (mTwoPane) {
            // In two-pane mode, show the detail view in this activity by
            // adding or replacing the detail fragment using a
            // fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(Integer.toString(R.id.thread_id), id);
            DetailWebFragment fragment = new DetailWebFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.thread_detail_container, fragment)
                    .commit();

        } else {
            // In single-pane mode, simply start the detail activity
            // for the selected item ID.
            Intent detailIntent = new Intent(this, DetailActivity.class);
            detailIntent.putExtra(Integer.toString(R.id.thread_id), id);
            startActivity(detailIntent);
        }
    }


}