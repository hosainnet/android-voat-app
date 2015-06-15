package net.hosain.voat.activity.subverse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import net.hosain.voat.R;
import net.hosain.voat.VoatApp;
import net.hosain.voat.activity.thread.DetailActivity;
import net.hosain.voat.data.DataEntity;
import net.hosain.voat.data.Subverse;
import net.hosain.voat.utils.RecyclerItemClickListener;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class SubverseActivity extends FragmentActivity {

    @InjectView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_list);
        VoatApp.component.inject(this);
        ButterKnife.inject(this);

        mRecyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        DataEntity dataEntity = Subverse.MAIN.getData().get(position);
                        onItemSelected(Integer.toString(dataEntity.getId()));
                    }
                })
        );
    }

    public void onItemSelected(String id) {
        Intent detailIntent = new Intent(this, DetailActivity.class);
        detailIntent.putExtra(Integer.toString(R.id.thread_id), id);
        startActivity(detailIntent);
    }

}
