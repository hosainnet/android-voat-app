package net.hosain.voat.activity.subverse;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import net.hosain.voat.R;
import net.hosain.voat.VoatApp;
import net.hosain.voat.service.ApiService;

import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import timber.log.Timber;

public class SubverseActivity extends AppCompatActivity {

    @Inject
    ApiService mApiService;

    @InjectView(R.id.drawer)
    DrawerLayout mDrawerLayout;

    @InjectView(R.id.drawer_navigation_view)
    NavigationView mNavigationView;

    @InjectView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_list);
        VoatApp.component.inject(this);
        ButterKnife.inject(this);

        setSupportActionBar(mToolbar);

        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);

        getDefaultSubverses();
        setupDrawerItemsClickHandler();
    }

    private void setupDrawerItemsClickHandler() {
        mNavigationView.setNavigationItemSelectedListener(
                menuItem -> {
                    menuItem.setChecked(true);
                    mDrawerLayout.closeDrawers();
                    return true;
                });
    }

    private void getDefaultSubverses() {
        mApiService.listDefaultSubverses(new Callback<List<String>>() {
            @Override
            public void success(List<String> subverses, Response response) {
                Menu menu = mNavigationView.getMenu();
                for (String subverse : subverses) {
                    menu.add(R.id.drawer_navigation_view_group, Menu.NONE, Menu.NONE, subverse).setIcon(R.drawable.ic_web_white_24dp);
                }
            }

            @Override
            public void failure(RetrofitError error) {
                Timber.e("Failed to get list of default subverses");
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
