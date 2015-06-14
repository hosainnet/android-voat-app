package net.hosain.voat.activity.thread;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.hosain.voat.R;
import net.hosain.voat.VoatApp;
import net.hosain.voat.data.Comment;
import net.hosain.voat.data.Discussion;
import net.hosain.voat.service.ApiService;

import javax.inject.Inject;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import timber.log.Timber;


public class DetailCommentsFragment extends BaseDetailFragment {

    @Inject
    ApiService apiService;

    public static Fragment newInstance(String threadId) {
        DetailCommentsFragment fragment = new DetailCommentsFragment();
        return newInstance(threadId, fragment);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail_comments, container, false);
        VoatApp.component.inject(this);

        apiService.listComments(mItem.getSubverse(), mItem.getId(), new Callback<Discussion>() {
            @Override
            public void success(Discussion discussion, Response response) {
                for (Comment comment : discussion.getData()) {
                    Timber.d("Comment " + comment.getContent());
                }
            }

            @Override
            public void failure(RetrofitError error) {
                Timber.e("Error getting comments " + error.getMessage());
            }
        });
        return view;
    }

}
