package com.example.course.controller;

import com.example.course.model.StudentCourse;
import com.example.course.service.StudentCourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentCourseController {

    private final StudentCourseService service;

    public StudentCourseController(StudentCourseService service) {
        this.service = service;
    }

    @GetMapping("/student_courses")
    public List<StudentCourse> getAll() {
        return service.getAll();
    }

    @GetMapping("/student_courses/student/{studentId}")
    public List<StudentCourse> getByStudentId(@PathVariable Long studentId) {
        return service.getByStudentId(studentId);
    }

    @GetMapping("/student_courses/course/{courseId}")
    public List<StudentCourse> getByCourseId(@PathVariable Long courseId) {
        return service.getByCourseId(courseId);
    }
}
