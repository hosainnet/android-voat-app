package net.hosain.voat.activity.subverse;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import net.hosain.voat.R;
import net.hosain.voat.VoatApp;

public class SubverseActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_list);
        VoatApp.component.inject(this);

    }

}
