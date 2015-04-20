package com.zhf.webapp.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by zhaohf on 2015/4/11.
 */
@Entity
@Table(name = "url_ref_count")
public class UrlRefCount implements Serializable{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "url")
    private String url;
    @Column(name = "ref")
    private String ref;

    public UrlRefCount() {
    }

    public UrlRefCount(String ref,int count) {
        this.count = count;
        this.ref = ref;
    }

    public UrlRefCount(int count, String ref, String url) {

        this.count = count;
        this.ref = ref;

        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "count")

    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "UrlRefCount{" +
                "count=" + count +
                ", id=" + id +
                ", url='" + url + '\'' +
                ", ref='" + ref + '\'' +
                '}';
    }
}
