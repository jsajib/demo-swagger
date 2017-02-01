package com.jubydull.web.model;

/**
 * Created by bs141 on 2/1/2017.
 */
public class Greeting {

    private long id;
    private String content;

    public Greeting(){}

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
