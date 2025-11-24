package com.example.course.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.course.model.StudentCourse;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long> {
    List<StudentCourse> findByStudentId(Long studentId);
    List<StudentCourse> findByCourseId(Long courseId);
}
