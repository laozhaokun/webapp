package com.zhf.webapp.dao.impl;

import com.zhf.webapp.dao.HostDAO;
import com.zhf.webapp.model.Host;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhaohf on 2015/4/6.
 */
@Repository
public class HostDAOImpl implements HostDAO {

    public static final Logger logger = LoggerFactory.getLogger(HostDAOImpl.class);
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void add(Host host) {
        getCurrentSession().persist(host);
        logger.info("save host successfully,host details:" + host);
    }

    public void delete(int id) {
        String yyyymmdd = new DateTime().toString("yyyyMMdd");
        getCurrentSession().createSQLQuery("update host set flag = 'deleted',delete_date = '" + yyyymmdd + "'where id=" + id).executeUpdate();
        logger.info("set the flag to 'deleted' successfully,host id:" + id);
    }

    public void delete_real(int id) {
        getCurrentSession().createSQLQuery("delete from host where id = " + id).executeUpdate();
        logger.info("deleted successfully,host id:" + id);
    }

    public Host getHostById(int id) {
        Host host = (Host) getCurrentSession().load(Host.class, new Integer(id));
        logger.info("get host successfully,host detail:" + host);
        return host;
    }

    public List<Host> listHosts(Integer offset, Integer maxResults) {
        List<Host> hosts = getCurrentSession().createCriteria(Host.class)
                .setFirstResult(offset!=null?offset:0)
                .setMaxResults(maxResults!=null?maxResults:10)
                .list();
        for (Host h : hosts)
            logger.info("host detail:" + h);
        return hosts;
    }

    public void update(Host host) {
        getCurrentSession().update(host);
        logger.info("update host successfully,host detail:" + host);
    }
    public int count(){
        logger.info("count host successfully");
        return getCurrentSession().createQuery("from Host").list().size();
    }
}
