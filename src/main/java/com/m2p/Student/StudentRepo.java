package com.m2p.Student;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class StudentRepo {
    List<Student> studentList = new ArrayList<>();

    public List<Student> getStudentList(Integer id, String name) {
//        System.out.println(id);
//        System.out.println(name);
        return studentList;
    }

    public void saves(Student student) {
//        System.out.println(student);
        studentList.add(student);
//        System.out.println(studentList);
    }

    public void getStudentById(Integer id) {
//        System.out.println(studentList);


    }
}
