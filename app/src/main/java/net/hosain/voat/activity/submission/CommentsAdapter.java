package net.hosain.voat.activity.submission;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import net.hosain.voat.R;
import net.hosain.voat.VoatApp;
import net.hosain.voat.data.Comment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.CommentItemViewHolder> {
    private final List<Comment> mComments;
    private final List<Comment> mTopLevelComments;

    @Inject
    Context context;

    public CommentsAdapter(List<Comment> comments) {
        this.mComments = comments;
        this.mTopLevelComments = getTopLevelComments(comments);
        VoatApp.component.inject(this);
    }

    @Override
    public CommentItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_comment_container, parent, false);
        return new CommentItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CommentItemViewHolder holder, int position) {
        holder.mCommentsContainer.removeAllViews();
        Comment currentComment = mTopLevelComments.get(position);
        ArrayList<Comment> childComments = currentComment.getChildComments(mComments);

        TextView topLeveComment = (TextView) LayoutInflater.from(context).inflate(R.layout.fragment_comment, holder.mCommentsContainer, false);
        topLeveComment.setText(Html.fromHtml(currentComment.getContent()));
        holder.mCommentsContainer.addView(topLeveComment);

        for (Comment comment : childComments) {
            TextView commentTextView = (TextView) LayoutInflater.from(context).inflate(R.layout.fragment_comment, holder.mCommentsContainer, false);
            commentTextView.setText(Html.fromHtml(comment.getFormattedContent()));
            commentTextView.setPadding(100, 0, 0, 0);
            holder.mCommentsContainer.addView(commentTextView);
        }
    }

    @Override
    public int getItemCount() {
        return mTopLevelComments.size();
    }

    public ArrayList<Comment> getTopLevelComments(List<Comment> comments) {
        ArrayList<Comment> topLevelComments = new ArrayList<>();
        for (Comment comment : comments) {
            if (comment.getLevel() == 0) {
                topLevelComments.add(comment);
            }
        }
        return topLevelComments;
    }

    public static class CommentItemViewHolder extends RecyclerView.ViewHolder {
        LinearLayout mCommentsContainer;

        public CommentItemViewHolder(View itemView) {
            super(itemView);
            this.mCommentsContainer = (LinearLayout) itemView.findViewById(R.id.comments_container);
        }
    }
}
