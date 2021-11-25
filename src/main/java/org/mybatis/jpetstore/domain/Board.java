package org.mybatis.jpetstore.domain;

import net.sourceforge.stripes.validation.Validate;

import java.io.Serializable;
import java.util.Date;

public class Board implements Serializable {

    private static final long serialVersionUID = 3992469837058393712L;

    private int bnum;
    private String userId;
    private String title;
    private String content;
    private Date date;

    public int getBnum() {
        return bnum;
    }

    public void setBnum(int bnum) {
        this.bnum = bnum;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}