package com.kfit.domain;

import java.io.Serializable;

public class Stu implements Serializable {
    private String name;

    private String sex;

    private String age;

    public Stu(String name, String sex, String age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public Stu() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age == null ? null : age.trim();
    }
}