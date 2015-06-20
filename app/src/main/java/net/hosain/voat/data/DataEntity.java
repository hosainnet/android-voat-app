package net.hosain.voat.data;


import java.net.MalformedURLException;
import java.net.URL;

import timber.log.Timber;

public class DataEntity {

    private static final int TYPE_SELF = 1;
    private static final int TYPE_LINK = 2;


    private String date;
    private String thumbnail;
    private String lastEditDate;
    private int upVotes;
    private String userName;
    private String title;
    private int type;
    private String url;
    private String content;
    private int commentCount;
    private int downVotes;
    private String formattedContent;
    private int id;
    private String subverse;
    private int views;

    public void setDate(String date) {
        this.date = date;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setLastEditDate(String lastEditDate) {
        this.lastEditDate = lastEditDate;
    }

    public void setUpVotes(int upVotes) {
        this.upVotes = upVotes;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public void setDownVotes(int downVotes) {
        this.downVotes = downVotes;
    }

    public void setFormattedContent(String formattedContent) {
        this.formattedContent = formattedContent;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSubverse(String subverse) {
        this.subverse = subverse;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public String getDate() {
        return date;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getLastEditDate() {
        return lastEditDate;
    }

    public int getUpVotes() {
        return upVotes;
    }

    public String getUserName() {
        return userName;
    }

    public String getTitle() {
        return title;
    }

    public int getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

    public String getContent() {
        return content;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public int getDownVotes() {
        return downVotes;
    }

    public String getFormattedContent() {
        return formattedContent;
    }

    public int getId() {
        return id;
    }

    public String getSubverse() {
        return subverse;
    }

    public int getViews() {
        return views;
    }

    public boolean isSelf() {
        return type == TYPE_SELF;
    }

    public boolean isLink() {
        return type == TYPE_LINK;
    }

    public String getDomain() {
        if (isSelf()) {
            return "self";
        } else {
            try {
                URL url = new URL(getUrl());
                return url.getHost();
            } catch (MalformedURLException e) {
                Timber.e(e.getMessage());
            }
            return "";
        }
    }

    @Override
    public String toString() {
        return title;
    }
}