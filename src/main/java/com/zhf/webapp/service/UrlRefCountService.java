package com.zhf.webapp.service;

import com.zhf.webapp.model.UrlRefCount;

import java.util.List;

/**
 * Created by zhaohf on 2015/4/12.
 */
public interface UrlRefCountService {
    public List<UrlRefCount> getURC(String url);
    public List<UrlRefCount> getURC2(String ref);
}
