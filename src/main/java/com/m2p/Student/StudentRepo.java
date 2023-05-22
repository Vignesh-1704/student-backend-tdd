package com.m2p.Student;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class StudentRepo {
    List<Student> studentList = new ArrayList<>();

    public List<Student> getStudentList() {
//        System.out.println(id);
//        System.out.println(name);
        return studentList;
    }

    public void saves(Student student) {
//        System.out.println(student);
        studentList.add(student);
//        System.out.println(studentList);
    }

    public Student getStudentById(Integer id) {
        System.out.println(id);
        Student requiredStudent = new Student(null,null);
        for(Student student:studentList) {
            if(student.getId() == id)
            {
               requiredStudent = student;
            }
        }

        return requiredStudent;


    }
}
