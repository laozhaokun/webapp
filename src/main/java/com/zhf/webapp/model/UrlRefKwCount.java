package com.zhf.webapp.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by zhaohf on 2015/4/20.
 */
@Entity
@Table(name = "url_ref_kw_count")
public class UrlRefKwCount implements Serializable{
    public UrlRefKwCount(int count,String kw) {

        this.count = count;
        this.kw = kw;
    }
    public UrlRefKwCount(String ref,int count) {

        this.count = count;
        this.ref = ref;
    }
    public UrlRefKwCount() {

    }

    @Id
    @Column(name = "id")

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "url")
    private String url;
    @Column(name = "ref")
    private String ref;
    @Column(name = "kw")
    private String kw;
    @Column(name = "count")
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKw() {
        return kw;
    }

    public void setKw(String kw) {
        this.kw = kw;
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
        return "UrlRefKwCount{" +
                "count=" + count +
                ", id=" + id +
                ", url='" + url + '\'' +
                ", ref='" + ref + '\'' +
                ", kw='" + kw + '\'' +
                '}';
    }
}
