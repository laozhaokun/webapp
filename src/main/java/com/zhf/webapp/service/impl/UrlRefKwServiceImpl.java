package com.zhf.webapp.service.impl;

import com.zhf.webapp.dao.UrlRefKwCountDAO;
import com.zhf.webapp.model.UrlRefKwCount;
import com.zhf.webapp.service.UrlRefKwService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhaohf on 2015/4/20.
 */
@Service
@Transactional
public class UrlRefKwServiceImpl implements UrlRefKwService{

    @Autowired
    private UrlRefKwCountDAO urlRefKwCountDAO;
    public List<UrlRefKwCount> getRefKw(String url) {
        return this.urlRefKwCountDAO.getRefKw(url);
    }

    public List<UrlRefKwCount> getRefEngine(String url) {
        return this.urlRefKwCountDAO.getRefEngine(url);
    }
}
