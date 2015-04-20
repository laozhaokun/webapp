package com.zhf.webapp.dao;

import com.zhf.webapp.model.UrlRefKwCount;

import java.util.List;

/**
 * Created by zhaohf on 2015/4/20.
 */
public interface UrlRefKwCountDAO {
    /**
     * 关键词排名
     * @param url
     * @return
     */
    public List<UrlRefKwCount> getRefKw(String url);

    /**
     * 搜索引擎排名
     * @param url
     * @return
     */
    public List<UrlRefKwCount> getRefEngine(String url);

}
