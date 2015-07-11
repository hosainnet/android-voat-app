package net.hosain.voat.activity.subverse;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.hosain.voat.R;
import net.hosain.voat.VoatApp;
import net.hosain.voat.activity.submission.DetailActivity;
import net.hosain.voat.data.Submission;
import net.hosain.voat.data.Subverse;
import net.hosain.voat.service.ApiService;
import net.hosain.voat.utils.DividerItemDecoration;
import net.hosain.voat.utils.RecyclerItemClickListener;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import timber.log.Timber;

public class SubverseFragment extends Fragment {

    private SubverseAdapter mSubverseAdapter;

    @Inject
    ApiService mApiService;

    @InjectView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        VoatApp.component.inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_subverse_list, container, false);
        ButterKnife.inject(this, view);

        setRetainInstance(true);

        if (savedInstanceState == null) {
            getSubmissions("_default");
        } else {
            mRecyclerView.setAdapter(mSubverseAdapter);
        }

        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false));

        mRecyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getActivity().getApplicationContext(), (view1, position) -> {
                    Submission submission = Subverse.MAIN.getData().get(position);
                    onItemSelected(Integer.toString(submission.getId()));
                })
        );

        return view;
    }

    public void onItemSelected(String id) {
        Intent detailIntent = new Intent(getActivity(), DetailActivity.class);
        detailIntent.putExtra(Integer.toString(R.id.thread_id), id);
        startActivity(detailIntent);
    }

    private void getSubmissions(String subverse) {
        mApiService.listSubmissions(subverse, new Callback<Subverse>() {

            @Override
            public void success(Subverse subverse, Response response) {

                mSubverseAdapter = new SubverseAdapter(subverse.getData());

                Subverse.MAIN = subverse;
                mRecyclerView.setAdapter(mSubverseAdapter);

                Timber.d("Success!");
                Timber.d("Threads size " + subverse.getData().size());
            }

            @Override
            public void failure(RetrofitError error) {
                Timber.d("Fail!!");
                Timber.e(error.getMessage());
            }
        });
    }
}
