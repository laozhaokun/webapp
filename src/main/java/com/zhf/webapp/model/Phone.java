package com.zhf.webapp.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by zhaohf on 2015/4/22.
 */
@Entity
@Table(name = "phone")
public class Phone implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "brand")
    private String brand;
    @Column(name = "count")
    private int count;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "brand='" + brand + '\'' +
                ", id=" + id +
                ", count=" + count +
                '}';
    }
}
