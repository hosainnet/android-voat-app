package net.hosain.voat.activity.subverse;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.hosain.voat.R;
import net.hosain.voat.VoatApp;
import net.hosain.voat.data.Subverse;
import net.hosain.voat.service.ApiService;

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
        getThreads("all");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_subverse_list, container, false);
        ButterKnife.inject(this, view);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        return view;
    }

    private void getThreads(String subverse) {
        mApiService.listThreads(subverse, new Callback<Subverse>() {

            @Override
            public void success(Subverse subverse, Response response) {

                mSubverseAdapter = new SubverseAdapter(getActivity().getApplicationContext(), subverse.getData());

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
