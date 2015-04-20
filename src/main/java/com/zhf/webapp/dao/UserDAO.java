package com.zhf.webapp.dao;

import com.zhf.webapp.model.User;

import java.util.List;

/**
 * Created by zhaohf on 2015/4/5.
 */
public interface UserDAO {
    public List<User> listUsers(Integer offset, Integer maxResults);
    public void add(User user);
    public void delete(int id);
    public User getUserById(int id);
    public void update(User user);
    public int count();
    public User getUserByNamePass(String username,String password);
}
