package com.zhf.webapp.dao;

import com.zhf.webapp.model.UrlRefCount;

import java.util.List;

/**
 * Created by zhaohf on 2015/4/11.
 */
public interface UrlRefCountDAO {
    /**
     * 流量来源网址列表
     * @param url
     * @return
     */
    public List<UrlRefCount> getURC(String url);

    /**
     * 流量去向网址列表
     * @param ref
     * @return
     */
    public List<UrlRefCount> getURC2(String ref);
}
