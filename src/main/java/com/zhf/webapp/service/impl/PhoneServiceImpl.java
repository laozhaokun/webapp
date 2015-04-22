package com.zhf.webapp.service.impl;

import com.zhf.webapp.dao.PhoneDAO;
import com.zhf.webapp.model.Phone;
import com.zhf.webapp.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhaohf on 2015/4/22.
 */
@Service
@Transactional
public class PhoneServiceImpl implements PhoneService{
    @Autowired
    private PhoneDAO phoneDAO;
    public List<Phone> listPhones(int day) {
        return this.phoneDAO.listPhones(day);
    }
}
