package com.zhf.webapp.dao.impl;

import com.zhf.webapp.dao.PhoneDAO;
import com.zhf.webapp.model.Phone;
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
 * Created by zhaohf on 2015/4/22.
 */
@Repository
public class PhoneDAOImpl implements PhoneDAO{

    public static final Logger logger = LoggerFactory.getLogger(HostDAOImpl.class);
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public List<Phone> listPhones(int day) {
        Iterator iterator = getCurrentSession().createSQLQuery("select u.brand,u.count from phone_count u order by u.count desc").list().iterator();
        List<Phone> lists = new ArrayList<Phone>();
        while(iterator.hasNext()){
            Object[] objects = (Object[])iterator.next();
            String brand = objects[0].toString();
            int count = Integer.parseInt(objects[1].toString());
            Phone phone = new Phone();
            phone.setBrand(brand);
            phone.setCount(count);
            logger.info("phone detail : " + brand + "," + count);
            lists.add(phone);
        }
        return lists;
    }
}
