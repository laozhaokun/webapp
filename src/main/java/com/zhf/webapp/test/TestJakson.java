package com.zhf.webapp.test;

import java.util.Map;

/**
 * Created by zhaohf on 2015/4/11.
 */
public class TestJakson {
    static class School {
        private String class_name;
        private Map<String, Integer> class_num;

        public String getClass_name() {
            return class_name;
        }

        public void setClass_name(String class_name) {
            this.class_name = class_name;
        }

        public Map<String, Integer> getClass_num() {
            return class_num;
        }

        public void setClass_num(Map<String, Integer> class_num) {
            this.class_num = class_num;
        }

        public School(String class_name, Map<String, Integer> class_num) {
            this.class_name = class_name;
            this.class_num = class_num;
        }

        @Override
        public String toString() {
            return "School{" +
                    "class_name='" + class_name + '\'' +
                    ", class_num=" + class_num +
                    '}';
        }
    }

    public static void main(String[] args) {


    }

}

