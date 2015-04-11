package com.zhf.webapp.service;

import com.zhf.webapp.model.Host;

import java.util.List;

/**
 * Created by zhaohf on 2015/4/6.
 */
public interface HostService {
    public List<Host> listHosts(Integer offset, Integer maxResults);
    public void add(Host host);
    public void update(Host host);
    public void delete(int id);
    public Host getHostById(int id);
    public void delete_real(int id);
    public int count();
}
