package com.example.course;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.course.model.StudentCourse;
import com.example.course.repository.StudentCourseRepository;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentCourseRepositoryTest {

    @Autowired
    private StudentCourseRepository repository;

    @Test
    @Order(1)
    void shouldSaveStudentCourse() {
        StudentCourse sc = new StudentCourse();
        sc.setStudentId(10L);
        sc.setCourseId(5L);

        repository.save(sc);

        assertThat(repository.count()).isEqualTo(1);
    }

    @Test
    @Order(2)
    void shouldFindByStudentId() {
        List<StudentCourse> list = repository.findByStudentId(10L);

        assertThat(list).hasSize(1);
        assertThat(list.get(0).getCourseId()).isEqualTo(5L);
    }
}
