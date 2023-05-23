package com.m2p.Student;
import com.m2p.Student.exception.RequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public List<Student> getStudents(){
        return studentRepo.getStudentList();
    };

    public void saveStudent(Student student) {
        studentRepo.saves(student);
    }


    public Student getStudent(Integer id) {
        Student student =  studentRepo.getStudentById(id);
        if(student.getId() == null)
        {
            throw new RequestException("Not Found");
        }
        else
        {
            return student;
        }
    }
}
