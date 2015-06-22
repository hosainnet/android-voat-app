package net.hosain.voat.activity.submission;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import net.hosain.voat.R;
import net.hosain.voat.VoatApp;
import net.hosain.voat.data.Comment;
import net.hosain.voat.data.Discussion;
import net.hosain.voat.service.ApiService;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import timber.log.Timber;


public class DetailCommentsFragment extends BaseDetailFragment {

    @Inject
    ApiService mApiService;

    @InjectView(R.id.comments_container)
    LinearLayout mCommentsContainer;

    @InjectView(R.id.self_text_container)
    LinearLayout mSelfTextContainer;

    @InjectView(R.id.self_text)
    TextView mSelfTextView;

    public static Fragment newInstance(String threadId) {
        DetailCommentsFragment fragment = new DetailCommentsFragment();
        return newInstance(threadId, fragment);
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail_comments, container, false);

        VoatApp.component.inject(this);
        ButterKnife.inject(this, view);

        if (mItem.isSelf()) {
            mSelfTextView.setText(Html.fromHtml(mItem.getFormattedContent()));
            mSelfTextContainer.setVisibility(View.VISIBLE);
        }

        mApiService.listComments(mItem.getSubverse(), mItem.getId(), new Callback<Discussion>() {
            @Override
            public void success(Discussion discussion, Response response) {
                for (Comment comment : discussion.getData()) {
                    Timber.d("Comment " + comment.getContent());
                    TextView textView = (TextView) inflater.inflate(R.layout.fragment_comment, container, false);
                    textView.setText(Html.fromHtml(comment.getFormattedContent()));
                    mCommentsContainer.addView(textView);
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
