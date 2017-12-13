package com.everzones.reflectdemo.bean;

import java.io.Serializable;

/**
 * Created by sunny on 2017/10/27.
 * anthor:sunny
 * date: 2017/10/27
 * function:
 */

public class Person implements Serializable{
    private String name;
    private String age;

    public Person() {}

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getData(String name,String age){
        String result = name + "--->" + age;
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
