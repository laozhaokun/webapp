package com.zhf.webapp.model;

import org.apache.solr.client.solrj.beans.Field;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by zhaohf on 2015/5/10.
 */
@Entity
public class SiteSearch {
    @Field
    @Id
    private String id;
    @Field
    private String url;
    @Field
    private String sitetitle;
    @Field
    private String sitedesc;
    @Field
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getSitedesc() {
        return sitedesc;
    }

    public void setSitedesc(String sitedesc) {
        this.sitedesc = sitedesc;
    }

    public String getId() {
        return id;
    }

    @Field
    public void setId(String id) {
        this.id = id;
    }

    public String getSitetitle() {
        return sitetitle;
    }

    public void setSitetitle(String sitetitle) {
        this.sitetitle = sitetitle;
    }

    public String getUrl() {
        return url;
    }

    @Field
    public void setUrl(String url) {
        this.url = url;
    }
}
