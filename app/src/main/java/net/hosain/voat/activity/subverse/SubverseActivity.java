package net.hosain.voat.activity.subverse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import net.hosain.voat.R;
import net.hosain.voat.VoatApp;
import net.hosain.voat.activity.thread.DetailActivity;

public class SubverseActivity extends FragmentActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_list);
        VoatApp.component.inject(this);

    }

    public void onItemSelected(String id) {
        Intent detailIntent = new Intent(this, DetailActivity.class);
        detailIntent.putExtra(Integer.toString(R.id.thread_id), id);
        startActivity(detailIntent);
    }

}
