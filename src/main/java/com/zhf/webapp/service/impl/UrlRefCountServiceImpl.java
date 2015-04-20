package com.zhf.webapp.service.impl;

import com.zhf.webapp.dao.UrlRefCountDAO;
import com.zhf.webapp.model.UrlRefCount;
import com.zhf.webapp.service.UrlRefCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhaohf on 2015/4/12.
 */
@Service
@Transactional
public class UrlRefCountServiceImpl implements UrlRefCountService{

    @Autowired
    private UrlRefCountDAO urlRefCountDAO;
    public List<UrlRefCount> getURC(String url) {
        return this.urlRefCountDAO.getURC(url);
    }

    public List<UrlRefCount> getURC2(String ref) {
        return this.urlRefCountDAO.getURC2(ref);
    }
}
