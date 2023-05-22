package com.m2p.Student;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @InjectMocks
    private StudentService studentService;

    @Mock
    private StudentRepo studentRepo;

    List<Student> studentList = new ArrayList<>();

    @BeforeEach
    public void setup()
    {
        Student student = new Student("Geethika",3);
        studentList.add(student);
    }
    @Test
    public void shouldReturnStudentList(){
        Mockito.when(studentRepo.getStudentList()).thenReturn(studentList);
        List<Student> getStudentList = studentService.getStudents();
        assertThat(getStudentList).isNotNull();
        assertThat(getStudentList.size()).isEqualTo(1);
        verify(studentRepo).getStudentList();
    }
}
