package com.zhf.webapp.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

/**
 * Created by zhaohf on 2015/4/6.
 */
@Entity
@Table(name = "host")
public class Host {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "host")
    @NotEmpty(message = "域名不能为空")
    private String host;
    @Column(name = "add_date")
    @NotEmpty(message = "添加日期不能为空")
    @Pattern(regexp = "\\d{8}",message = "日期格式必须为YYYYMMDD")
    private String add_date;
    @Column(name = "flag")
    private String flag;
    @Column(name = "delete_date")
    private String delete_date;
    @Column(name = "message")
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHost() {

        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getFlag() {

        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getDelete_date() {

        return delete_date;
    }

    public void setDelete_date(String delete_date) {
        this.delete_date = delete_date;
    }

    public String getAdd_date() {

        return add_date;
    }

    public void setAdd_date(String add_date) {
        this.add_date = add_date;
    }

    @Override
    public String toString() {
        return "Host{" +
                "add_date='" + add_date + '\'' +
                ", id=" + id +
                ", host='" + host + '\'' +
                ", flag='" + flag + '\'' +
                ", delete_date='" + delete_date + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
