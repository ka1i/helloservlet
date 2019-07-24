package com.uestc.mardan.domain;

import java.util.Date;

public class Post {

    private int postId;
    private String title;
    private String content;
    private Date created;

    private Account account;


    public int getPostId() {
        return postId;
    }
    public void setPostId(int postId) {
        this.postId = postId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }
    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }
    @Override
    public String toString() {
        return "Post [postId=" + postId + ", title=" + title + ", content=" + content + ", created=" + created
                + ", account=" + account + "]";
    }


}
