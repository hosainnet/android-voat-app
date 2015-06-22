package net.hosain.voat.activity.submission;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ViewSwitcher;

import net.hosain.voat.R;
import net.hosain.voat.data.Submission;
import net.hosain.voat.data.Subverse;

import java.util.Locale;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class DetailActivity extends AppCompatActivity {

    SectionsPagerAdapter mSectionsPagerAdapter;
    ViewPager mViewPager;

    @InjectView(R.id.detail_view_switcher)
    ViewSwitcher mDetailViewSwitcher;

    @InjectView(R.id.comments_fragment_placeholder)
    FrameLayout mCommentsFragmentPlaceholder;

    @InjectView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ButterKnife.inject(this);

        setSupportActionBar(mToolbar);
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        String submissionId = getIntent().getStringExtra(Integer.toString(R.id.thread_id));
        Submission submission = Subverse.getSubmissionWithId(submissionId);
        setTitle(submission.getTitle());

        if (submission.isLink()) {
            setupLinkView(mToolbar, submissionId);
        } else {
            setupSelfView(mToolbar, submissionId);
        }

    }

    private void setupSelfView(Toolbar mToolbar, String submissionId) {

        mDetailViewSwitcher.showNext();

        Fragment commentsFragment = DetailCommentsFragment.newInstance(submissionId);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.comments_fragment_placeholder, commentsFragment);
        fragmentTransaction.commit();
    }

    private void setupLinkView(final Toolbar mToolbar, String submissionId) {

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), submissionId);

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.detail_view_holder);
        mViewPager.setAdapter(mSectionsPagerAdapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        String mSubmissionId;

        public SectionsPagerAdapter(FragmentManager fm, String submissionId) {
            super(fm);
            this.mSubmissionId = submissionId;
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).

            switch (position) {
                case 0:
                    return DetailWebFragment.newInstance(mSubmissionId);

                case 1:
                    return DetailCommentsFragment.newInstance(mSubmissionId);

                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.title_link).toUpperCase(l);
                case 1:
                    return getString(R.string.title_comments).toUpperCase(l);
            }
            return null;
        }
    }

}
