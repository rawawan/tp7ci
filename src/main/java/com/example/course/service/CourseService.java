package com.example.course.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.course.model.Course;
import com.example.course.repository.CourseRepository;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses() { return courseRepository.findAll(); }

    public Course getCourseById(Long id) { return courseRepository.findById(id).orElse(null); }

    public Course saveCourse(Course course) { return courseRepository.save(course); }

    public void deleteCourse(Long id) { courseRepository.deleteById(id); }

    public List<Course> searchByName(String name) { return courseRepository.findByNameContainingIgnoreCase(name); }

    public List<Course> searchByInstructor(String instructor) { return courseRepository.findByInstructorContainingIgnoreCase(instructor); }

    public List<Course> searchByCategory(String category) { return courseRepository.findByCategoryContainingIgnoreCase(category); }
}
