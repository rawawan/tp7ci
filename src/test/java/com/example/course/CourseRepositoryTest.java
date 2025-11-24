package com.example.course;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.course.model.Course;
import com.example.course.repository.CourseRepository;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    @Order(1)
    void shouldSaveCourse() {
        Course course = new Course();
        course.setName("Mathematics");
        course.setInstructor("John Doe");
        course.setCategory("Science");
        course.setSchedule("Monday 10:00");

        courseRepository.save(course);

        assertThat(courseRepository.count()).isEqualTo(1);
    }

    @Test
    @Order(2)
    void shouldFindAllCourses() {
        List<Course> courses = courseRepository.findAll();

        assertThat(courses).hasSize(1);
        assertThat(courses.get(0).getName()).isEqualTo("Mathematics");
    }

    @Test
    @Order(3)
    void shouldSearchByName() {
        List<Course> courses = courseRepository.findByNameContainingIgnoreCase("math");

        assertThat(courses).hasSize(1);
        assertThat(courses.get(0).getInstructor()).isEqualTo("John Doe");
    }
}
