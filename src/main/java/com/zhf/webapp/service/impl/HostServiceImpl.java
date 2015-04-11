package com.zhf.webapp.service.impl;

import com.zhf.webapp.dao.HostDAO;
import com.zhf.webapp.model.Host;
import com.zhf.webapp.service.HostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhaohf on 2015/4/6.
 */
@Service
@Transactional
public class HostServiceImpl implements HostService{

    @Autowired
    private HostDAO hostDAO;
    public void add(Host host) {
        this.hostDAO.add(host);
    }

    public void delete(int id) {
        this.hostDAO.delete(id);
    }

    public void delete_real(int id){
        this.hostDAO.delete_real(id);
    }
    public Host getHostById(int id) {
        return this.hostDAO.getHostById(id);
    }

    public List<Host> listHosts(Integer offset, Integer maxResults) {
        return this.hostDAO.listHosts(offset, maxResults);
    }

    public void update(Host host) {
        this.hostDAO.update(host);
    }

    public int count(){
        return this.hostDAO.count();
    }
}
