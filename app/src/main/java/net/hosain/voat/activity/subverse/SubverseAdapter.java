package net.hosain.voat.activity.subverse;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import net.hosain.voat.R;
import net.hosain.voat.VoatApp;
import net.hosain.voat.data.Submission;
import net.hosain.voat.service.ImageService;

import java.util.List;

import javax.inject.Inject;

public class SubverseAdapter extends RecyclerView.Adapter<SubverseAdapter.DetailItemViewHolder> {

    private List<Submission> mSubmissions;

    @Inject
    ImageService imageService;

    public SubverseAdapter(List<Submission> submissions) {
        this.mSubmissions = submissions;
        VoatApp.component.inject(this);
    }

    @Override
    public DetailItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_subverse_list_item, parent, false);
        return new DetailItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DetailItemViewHolder holder, int position) {
        Submission submission = mSubmissions.get(position);
        imageService.loadThumbnail(submission.getThumbnail(), holder.mImageView);
        holder.mTitleView.setText(submission.getTitle());
        holder.mCommentCount.setText(Integer.toString(submission.getCommentCount()));
        holder.mVoteCount.setText(Integer.toString(submission.getUpVotes()));
        holder.mDomain.setText(submission.getDomain());
    }

    @Override
    public int getItemCount() {
        return mSubmissions.size();
    }

    public static class DetailItemViewHolder extends RecyclerView.ViewHolder {

        protected ImageView mImageView;
        protected TextView mTitleView;
        protected TextView mCommentCount;
        protected TextView mVoteCount;
        protected TextView mDomain;

        public DetailItemViewHolder(View itemView) {
            super(itemView);
            this.mImageView = (ImageView) itemView.findViewById(R.id.subverse_item_image);
            this.mTitleView = (TextView) itemView.findViewById(R.id.subverse_item_title);
            this.mCommentCount = (TextView) itemView.findViewById(R.id.subverse_item_comment_count);
            this.mVoteCount = (TextView) itemView.findViewById(R.id.subverse_item_vote_count);
            this.mDomain = (TextView) itemView.findViewById(R.id.subverse_item_domain);
        }
    }

}
