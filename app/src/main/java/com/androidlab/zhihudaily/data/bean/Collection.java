package com.androidlab.zhihudaily.data.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Haodong on 2017/2/14.
 */
@Entity(nameInDb = "Collection")
public class Collection {
    @Id(autoincrement = true)
    private Long id;
    @Property(nameInDb = "time")
    private String time;
    @Property(nameInDb = "noteText")
    private String noteText;
    @Property(nameInDb = "picture")
    private String picture;
    @Property(nameInDb = "url")
    private String url;
    @Generated(hash = 216314665)
    public Collection(Long id, String time, String noteText, String picture,
            String url) {
        this.id = id;
        this.time = time;
        this.noteText = noteText;
        this.picture = picture;
        this.url = url;
    }
    @Generated(hash = 1149123052)
    public Collection() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTime() {
        return this.time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getNoteText() {
        return this.noteText;
    }
    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }
    public String getPicture() {
        return this.picture;
    }
    public void setPicture(String picture) {
        this.picture = picture;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }


}
