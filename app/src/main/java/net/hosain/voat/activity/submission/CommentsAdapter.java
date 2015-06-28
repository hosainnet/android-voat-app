package net.hosain.voat.activity.submission;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import net.hosain.voat.R;
import net.hosain.voat.VoatApp;
import net.hosain.voat.data.Comment;
import net.hosain.voat.data.Node;
import net.hosain.voat.data.Tree;
import net.hosain.voat.utils.TextUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.CommentItemViewHolder> {
    private final List<Node<Comment>> mTopLevelComments;

    @Inject
    Context context;

    public CommentsAdapter(List<Comment> comments) {
        mTopLevelComments = new ArrayList<>();
        buildCommentsTree(comments);
        VoatApp.component.inject(this);
    }

    private void buildCommentsTree(List<Comment> comments) {
        Node<Comment> rootNode = new Node<>(new Comment());
        Tree<Comment> mCommentsTree = new Tree<>(rootNode);
        HashMap<String, Comment> mCommentsMap = new HashMap<>();
        for (Comment comment : comments) {
            Node<Comment> commentNode = new Node<>(comment);
            if (comment.getLevel() == 0) {
                mCommentsTree.getRoot().addChild(commentNode);
                mCommentsMap.put(comment.getId(), comment);
                mTopLevelComments.add(commentNode);
            } else {
                Node<Comment> parentNode = mCommentsTree.findNode(mCommentsTree.getRoot(), mCommentsMap.get(comment.getParentID()));
                parentNode.addChild(commentNode);
                mCommentsMap.put(comment.getId(), comment);
            }
        }
    }

    @Override
    public CommentItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_comments_container, parent, false);
        return new CommentItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CommentItemViewHolder holder, int position) {
        holder.mCommentsContainer.removeAllViews();
        Node<Comment> rootCommentNode = mTopLevelComments.get(position);
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.fragment_comments_container, holder.mCommentsContainer, false);
        TextView rootCommentTextView = (TextView) LayoutInflater.from(context).inflate(R.layout.fragment_comment, holder.mCommentsContainer, false);
        rootCommentTextView.setText(TextUtils.FromHtmlTrimmed(rootCommentNode.getData().getFormattedContent()));
        linearLayout.addView(rootCommentTextView);
        addChildComments(rootCommentNode, linearLayout);
        holder.mCommentsContainer.addView(linearLayout);
    }

    private LinearLayout addChildComments(Node<Comment> node, LinearLayout linearLayout) {
        int childCount = node.getChildren().size();
        for (int i = 0; i < childCount; i++) {
            Node<Comment> childNode = node.getChildAt(i);
            TextView commentTextView = (TextView) LayoutInflater.from(context).inflate(R.layout.fragment_comment, linearLayout, false);
            Comment childComment = childNode.getData();
            commentTextView.setText(TextUtils.FromHtmlTrimmed(childComment.getFormattedContent()));
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) commentTextView.getLayoutParams();
            params.setMargins(20 * childComment.getLevel(), 0, 0, 0);
            commentTextView.setLayoutParams(params);
            linearLayout.addView(commentTextView);
            if (childNode.getChildren().size() > 0) {
                addChildComments(childNode, linearLayout);
            }
        }
        return linearLayout;
    }

    @Override
    public int getItemCount() {
        return mTopLevelComments.size();
    }

    public static class CommentItemViewHolder extends RecyclerView.ViewHolder {
        LinearLayout mCommentsContainer;

        public CommentItemViewHolder(View itemView) {
            super(itemView);
            this.mCommentsContainer = (LinearLayout) itemView.findViewById(R.id.comments_container);
        }
    }
}
