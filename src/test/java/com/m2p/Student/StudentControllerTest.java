package com.m2p.Student;

import ch.qos.logback.core.net.ObjectWriter;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @MockBean
    private StudentService studentService;
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;




    @Test
    void shouldGetALlTheStudentList() throws Exception{

        when(studentService.getStudents()).thenReturn(Arrays.asList(new Student("Utkarsh",1)));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/students"))
                .andExpect(status().isOk()) // default 200
                .andExpect(content().json(objectMapper.writeValueAsString(Arrays.asList(new Student("Utkarsh",1)))));

    }

    @Test
    void shouldGetStudentById() throws Exception {
        when(studentService.getStudent(1)).thenReturn((new Student("Sruthi",1)));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/student/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(new Student("Sruthi",1))));
    }

    @Test
    void shouldAddAStudentToStudentList() throws Exception {

        Student dummyStudent = new Student("Chalini",2);
//        when(studentService.saveStudent(dummyStudent)).thenReturn()
        String json = objectMapper.writer().writeValueAsString(dummyStudent);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/student")
                        .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isCreated());
        verify(studentService).saveStudent(dummyStudent);
    }
}

