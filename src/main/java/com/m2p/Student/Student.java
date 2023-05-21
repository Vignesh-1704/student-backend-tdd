package com.m2p.Student;

import org.springframework.stereotype.Component;

import java.beans.JavaBean;


public class Student {

    private Integer id;
    private String name;


    public Student(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
