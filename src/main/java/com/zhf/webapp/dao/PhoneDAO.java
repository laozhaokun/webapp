package com.zhf.webapp.dao;

import com.zhf.webapp.model.Phone;

import java.util.List;

/**
 * Created by zhaohf on 2015/4/22.
 */
public interface PhoneDAO {
    public List<Phone> listPhones(int day);
}
