package com.zhf.webapp.dao.impl;

import com.zhf.webapp.dao.UrlRefCountDAO;
import com.zhf.webapp.model.UrlRefCount;
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
 * Created by zhaohf on 2015/4/11.
 */
@Repository
public class UrlRefCountDAOImpl implements UrlRefCountDAO{
    public static final Logger logger = LoggerFactory.getLogger(UrlRefCountDAOImpl.class);
    @Autowired
    private SessionFactory sessionFactory;
    private Session getCurrentSession(){
        return this.sessionFactory.getCurrentSession();
    }
    public List<UrlRefCount> getURC(String url) {
        Iterator iterator = getCurrentSession().createSQLQuery("select u.ref,u.count from url_ref_count u where u.url = '" + url + "' and url!=ref order by count desc limit 15").list().iterator();
        List<UrlRefCount> lists = new ArrayList<UrlRefCount>();
        while(iterator.hasNext()){
            Object[] tuple = (Object[])iterator.next();
            String ref = tuple[0].toString();
            int count = Integer.parseInt(tuple[1].toString());
            logger.info("ref_count is :" + ref + "," + count);
            UrlRefCount urf = new UrlRefCount(ref,count);
            lists.add(urf);
        }
        return lists;
    }

    public List<UrlRefCount> getURC2(String ref) {
        Iterator iterator = getCurrentSession().createSQLQuery("select u.url,u.count from url_ref_count u where u.ref = '" + ref + "' and url !=ref order by count desc limit 15").list().iterator();
        List<UrlRefCount> lists = new ArrayList<UrlRefCount>();
        while(iterator.hasNext()){
            Object[] tuple = (Object[])iterator.next();
            String url = tuple[0].toString();
            int count = Integer.parseInt(tuple[1].toString());
            logger.info("url_count is :" + url + "," + count);
            UrlRefCount urf = new UrlRefCount(url,count);
            lists.add(urf);
        }
        return lists;
    }
}
