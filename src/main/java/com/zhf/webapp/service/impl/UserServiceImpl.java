package com.zhf.webapp.service.impl;

import com.zhf.webapp.dao.UserDAO;
import com.zhf.webapp.model.User;
import com.zhf.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhaohf on 2015/4/5.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<User> listUsers(Integer offset, Integer maxResults) {
        return this.userDAO.listUsers(offset, maxResults);
    }

    public void delete(int id) {
        this.userDAO.delete(id);
    }

    public User getUserById(int id) {
        return this.userDAO.getUserById(id);
    }

    public void update(User user) {
        this.userDAO.update(user);
    }

    public void add(User user) {
        this.userDAO.add(user);
    }

    public int count() {
        return this.userDAO.count();
    }
}
