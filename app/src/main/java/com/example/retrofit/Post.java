package com.example.retrofit;

public class Post {
    private String title;
    private String body;
    private int userid;
    private int id;

    public Post(String title, String body, int userid, int id) {
        this.title = title;
        this.body = body;
        this.userid = userid;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", userid=" + userid +
                ", id=" + id +
                '}';
    }
}

