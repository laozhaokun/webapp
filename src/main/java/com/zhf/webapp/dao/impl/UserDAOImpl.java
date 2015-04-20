package com.zhf.webapp.dao.impl;

import com.zhf.webapp.dao.UserDAO;
import com.zhf.webapp.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhaohf on 2015/4/5.
 */
@Repository
public class UserDAOImpl implements UserDAO{
      private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
    @Autowired
    private SessionFactory sessionFactory;
    private Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    public List<User> listUsers(Integer offset, Integer maxResults){
        List<User> users = getCurrentSession().createCriteria(User.class)
                .setFirstResult(offset!=null?offset:0)
                .setMaxResults(maxResults!=null?maxResults:10)
                .list();
        for(User u : users)
            logger.info("user loaded successfully,user detail:" + u);
        return users;
    }

    public User getUserById(int id) {
        User user = (User)getCurrentSession().load(User.class,new Integer(id));
        logger.info("user loaded successfully,user details:" + user);
        return user;
    }

    public void update(User user) {
        getCurrentSession().update(user);
        logger.info("user updated successfully,user details:" + user);
    }

    public void delete(int id) {
        User user = (User)getCurrentSession().load(User.class,new Integer(id));
        if(null != user)
            getCurrentSession().delete(user);
        logger.info("user deleted successfully,user details:" + user);
    }

    public void add( User user) {
        getCurrentSession().persist(user);
        logger.info("user add successfully,user details:"+ user);
    }

    public int count(){
        logger.info("count user successfully");
        return getCurrentSession().createQuery("from User").list().size();
    }

    public User getUserByNamePass(String username, String password) {
        List<User> userList = getCurrentSession().createQuery("from User u where u.username = '" + username +"' and u.password = '" + password + "'").list();
        logger.info("get user successfully,user details:" + username);
        if (userList.size() > 0)
             return userList.get(0);
        return null;
    }
}
