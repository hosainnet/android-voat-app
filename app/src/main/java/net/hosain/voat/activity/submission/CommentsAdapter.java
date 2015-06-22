package net.hosain.voat.activity.submission;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.hosain.voat.R;
import net.hosain.voat.data.Comment;

import java.util.List;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.CommentItemViewHolder> {
    private final List<Comment> mComments;

    public CommentsAdapter(List<Comment> comments) {
        this.mComments = comments;
    }

    @Override
    public CommentItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_comment, parent, false);
        return new CommentItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CommentItemViewHolder holder, int position) {
        holder.mComment.setText(Html.fromHtml(mComments.get(position).getFormattedContent()));
    }

    @Override
    public int getItemCount() {
        return mComments.size();
    }

    public static class CommentItemViewHolder extends RecyclerView.ViewHolder {

        TextView mComment;

        public CommentItemViewHolder(View itemView) {
            super(itemView);
            this.mComment = (TextView) itemView.findViewById(R.id.comment);
        }
    }
}
