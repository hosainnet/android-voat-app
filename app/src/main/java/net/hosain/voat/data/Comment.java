package net.hosain.voat.data;

import java.util.ArrayList;
import java.util.List;

public class Comment {

    private String date;
    private int level;
    private String lastEditDate;
    private int upVotes;
    private int childCount;
    private String userName;
    private String parentID;
    private String content;
    private int downVotes;
    private String formattedContent;
    private int submissionID;
    private String id;
    private String subverse;

    public void setDate(String date) {
        this.date = date;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setLastEditDate(String lastEditDate) {
        this.lastEditDate = lastEditDate;
    }

    public void setUpVotes(int upVotes) {
        this.upVotes = upVotes;
    }

    public void setChildCount(int childCount) {
        this.childCount = childCount;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setParentID(String parentID) {
        this.parentID = parentID;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDownVotes(int downVotes) {
        this.downVotes = downVotes;
    }

    public void setFormattedContent(String formattedContent) {
        this.formattedContent = formattedContent;
    }

    public void setSubmissionID(int submissionID) {
        this.submissionID = submissionID;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSubverse(String subverse) {
        this.subverse = subverse;
    }

    public String getDate() {
        return date;
    }

    public int getLevel() {
        return level;
    }

    public String getLastEditDate() {
        return lastEditDate;
    }

    public int getUpVotes() {
        return upVotes;
    }

    public int getChildCount() {
        return childCount;
    }

    public String getUserName() {
        return userName;
    }

    public String getParentID() {
        return parentID;
    }

    public String getContent() {
        return content;
    }

    public int getDownVotes() {
        return downVotes;
    }

    public String getFormattedContent() {
        return formattedContent;
    }

    public int getSubmissionID() {
        return submissionID;
    }

    public String getId() {
        return id;
    }

    public String getSubverse() {
        return subverse;
    }

    public ArrayList<Comment> getChildComments(List<Comment> comments) {
        ArrayList<Comment> childComments = new ArrayList<>();

        for (Comment comment : comments) {
            if (comment.level == 1 && comment.parentID.equals(id)) {
                childComments.add(comment);
            }
        }
        return childComments;
    }
}