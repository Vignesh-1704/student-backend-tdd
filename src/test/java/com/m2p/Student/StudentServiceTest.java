package com.m2p.Student;


import com.m2p.Student.exception.RequestException;
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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @InjectMocks
    private StudentService studentService;

    @Mock
    private StudentRepo studentRepo;

    List<Student> studentList = new ArrayList<>();

    Student student;
    @BeforeEach
    public void setup()
    {
        student = new Student("Geethika",3);
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

    @Test
    public void shouldReturnSuccessWhenValidIdIsPassed()
    {
        Mockito.when(studentRepo.getStudentById(3)).thenReturn(student);
        Student student1 = studentService.getStudent(3);
        assertThat(student1.getId()).isEqualTo(student.getId());
        verify(studentRepo).getStudentById(3);
    }

    @Test
    public void shouldThrowAnExceptionWhenInvalidIdIsPassed()
    {
        Student invalidStudent = new Student(null, null);
        Mockito.when(studentRepo.getStudentById(2)).thenReturn(invalidStudent);
        assertThrows(RequestException.class,() -> {
            studentService.getStudent(2);
        });

        verify(studentRepo).getStudentById(2);
    }


}
