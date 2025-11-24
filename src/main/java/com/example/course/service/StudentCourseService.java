package com.example.course.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.course.model.StudentCourse;
import com.example.course.repository.StudentCourseRepository;

@Service
public class StudentCourseService {
    private final StudentCourseRepository repository;

    public StudentCourseService(StudentCourseRepository repository) {
        this.repository = repository;
    }

    public List<StudentCourse> getAll() {
        return repository.findAll();
    }

    public List<StudentCourse> getByStudentId(Long studentId) {
        return repository.findByStudentId(studentId);
    }

    public List<StudentCourse> getByCourseId(Long courseId) {
        return repository.findByCourseId(courseId);
    }
}
