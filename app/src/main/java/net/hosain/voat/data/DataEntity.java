package net.hosain.voat.data;


public class DataEntity {

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
}