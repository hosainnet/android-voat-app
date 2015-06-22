package net.hosain.voat.activity.subverse;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import net.hosain.voat.R;
import net.hosain.voat.VoatApp;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class SubverseActivity extends AppCompatActivity {

    @InjectView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_list);
        VoatApp.component.inject(this);
        ButterKnife.inject(this);

        setSupportActionBar(mToolbar);

    }

}
