package net.hosain.voat.activity.submission;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import net.hosain.voat.R;
import net.hosain.voat.data.Submission;
import net.hosain.voat.data.Subverse;

import java.util.Locale;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class DetailActivity extends AppCompatActivity {

    SectionsPagerAdapter mSectionsPagerAdapter;
    CustomViewPager mViewPager;

    @InjectView(R.id.toolbar)
    Toolbar mToolbar;

    @InjectView(R.id.view_comments_button)
    FloatingActionButton mViewCommentsButton;

    @InjectView(R.id.view_web_link_button)
    FloatingActionButton mViewWebLinkButton;

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

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), submissionId);
        mViewPager = (CustomViewPager) findViewById(R.id.detail_view_holder);
        mViewPager.setPagingEnabled(false);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        if (submission.isLink()) {
            mViewCommentsButton.setVisibility(View.VISIBLE);
        }
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

    @OnClick(R.id.view_comments_button)
    public void viewCommentsOnClick(FloatingActionButton button) {
        mViewPager.setCurrentItem(1);
        button.setVisibility(View.GONE);
        mViewWebLinkButton.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.view_web_link_button)
    public void viewWebLinkButton(FloatingActionButton button) {
        mViewPager.setCurrentItem(0);
        button.setVisibility(View.GONE);
        mViewCommentsButton.setVisibility(View.VISIBLE);
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        String mSubmissionId;
        Submission mSubmission;

        public SectionsPagerAdapter(FragmentManager fm, String submissionId) {
            super(fm);
            this.mSubmissionId = submissionId;
            this.mSubmission = Subverse.getSubmissionWithId(submissionId);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).

            if (mSubmission.isSelf()) {
                return DetailCommentsFragment.newInstance(mSubmissionId);
            }

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
            if (mSubmission.isSelf()) {
                return 1;
            }
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
