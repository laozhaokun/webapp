package com.zhf.webapp.dao.impl;

import com.zhf.webapp.dao.UrlRefKwCountDAO;
import com.zhf.webapp.model.UrlRefKwCount;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zhaohf on 2015/4/20.
 */
@Repository
public class UrlRefKwCountDAOImpl implements UrlRefKwCountDAO{

    public static final Logger logger = LoggerFactory.getLogger(UrlRefKwCountDAOImpl.class);
    @Autowired
    private SessionFactory sessionFactory;
    private Session getCurrentSession(){
        return this.sessionFactory.getCurrentSession();
    }

    public List<UrlRefKwCount> getRefEngine(String url) {
        Iterator iterator = getCurrentSession().createSQLQuery("select u.ref,sum(u.count) from url_ref_kw_count u where u.url = '" + url + "' group by u.ref order by sum(u.count) desc limit 15").list().iterator();
        List<UrlRefKwCount> lists = new ArrayList<UrlRefKwCount>();
        while(iterator.hasNext()){
            Object[] tuple = (Object[])iterator.next();
            String ref = tuple[0].toString();
            int count = Integer.parseInt(tuple[1].toString());
            logger.info("ref_count :" + ref + "," + count);
            UrlRefKwCount urf = new UrlRefKwCount(ref,count);
            lists.add(urf);
        }
        return lists;
    }

    public List<UrlRefKwCount> getRefKw(String url) {
        Iterator iterator = getCurrentSession().createSQLQuery("select u.kw,u.count from url_ref_kw_count u where u.url = '" + url + "' order by count desc limit 15").list().iterator();
        List<UrlRefKwCount> lists = new ArrayList<UrlRefKwCount>();
        while(iterator.hasNext()){
            Object[] tuple = (Object[])iterator.next();
            String kw = tuple[0].toString();
            int count = Integer.parseInt(tuple[1].toString());
            logger.info("kw_count : " + kw + "," + count);
            UrlRefKwCount urf = new UrlRefKwCount(count,kw);
            lists.add(urf);
        }
        return lists;
    }
}
